/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Projeto_Chat_1ºBimestre;

import static Projeto_Chat_1ºBimestre.Servidor.conexoes;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

/**
 *
 * @author a1700677
 */
public class Comando {
        ServerSocket servidorConexão;
        Servidor server = new Servidor();
    
    public Comando(ServerSocket sc, Servidor s) throws IOException{
        servidorConexão = sc;
        server = s;
    }

   public boolean login(String nome,ThreadSocket a) throws IOException{
       if(a.isLogado() == false){
       for(int i = 0; i < server.getLogadosSize(); i++){
           if(server.getLogados(i).equals(nome)){
               System.out.println("SERVER: Socket Morto");
               a.saida.writeUTF("O Nome de Usuário não pode ser registrado");
               server.KillConexao(i+1);
               return false;
           }   
       }
       a.setLogado(nome);
       server.setLogados(nome);
       return true; 
       }else{
           a.saida.writeUTF("Você já está logado!");
           return false;
       }
       
   }
    
   public boolean mensagem(String rem, String dest, String text) throws IOException{
       String[] partsDests = dest.split(";");
       ArrayList<ThreadSocket> destinatarios = new ArrayList();
       int alvo = 0;
       for(int j = 0; j < partsDests.length; j++){
        for(int i = 0; i < partsDests.length; i++){
           if(partsDests[alvo] == server.getConexoes(i).nome){
               destinatarios.add(server.getConexoes(i));
               alvo++;
           }
        }
       }
       if(destinatarios.size() > 0){
           for(int i = 0; i < destinatarios.size(); i++){
               destinatarios.get(i).saida.writeUTF("mensagem de:"+rem+":"+dest+":"+text);
           }
           return true;
       }
       return false;
   }
   
   public String listarUsuarios(){
       String all = "Usuários conectados: ";
       all = all.concat(server.getLogados(0));
       for(int i = 1; i < server.getLogadosSize(); i++){
           all = all.concat(";"+server.getLogados(i));
       }
   
       return all;    
    }
   
   public String listarConexoes(){
       String all = "Usuarios dos seguintes IP's: ";
       
       for(int i = 0; i < server.getConexoesSize(); i++){
           all = all.concat(server.getConexoes(i).socket.getInetAddress().toString()+" | ");
       }
       return all;
   }
}
