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
       if(!a.isLogado()){
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
       }
       return false;
   }
    
   public boolean mensagem(ThreadSocket s, String rem, String dest, String text) throws IOException{
       if(dest.contains(";")){
           String[] dests = dest.split(";");
           System.out.println(dests[0]+dests[1]);
           System.out.println(dests.length);
           System.out.println(server.getConexoesSize());
           String nomes = dests[0];
           for(int i = 1; i < dests.length; i++){
               nomes = nomes.concat(";"+dests[i]);
           }
           for(int j = 0; j < 3; j++){
            for(int i = 0; i < 2; i++){
                System.out.println("Se "+server.getConexoes(j).nome+" == "+dests[i]);
                if(server.getConexoes(j).nome.equals(dests[i])){
                    server.getConexoes(j).saida.writeUTF("mensagem de "+rem+":"+nomes+":"+text);
                }
            }
           }
           return true;
       }else{
           for(int i = 0; i < server.getConexoesSize(); i++){
            if(server.getConexoes(i).nome.equals(dest)){
                   server.getConexoes(i).saida.writeUTF("mensagem de "+rem+":"+dest+":"+text); 
            }
           }
       }
        return true;
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
