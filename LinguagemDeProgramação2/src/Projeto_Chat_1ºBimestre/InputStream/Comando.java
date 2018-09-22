/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Projeto_Chat_1ºBimestre.InputStream;

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
               System.out.println("SERVER: Socket Morto por nome duplicado");
               a.saida.println("O Nome de Usuário não pode ser registrado");
               server.KillConexao(i+1);
               return false;
           }   
       }
           if(nome.equals("*") || nome.equals(":")){
               System.out.println("SERVER: Socket Morto por nome invalido");
               a.saida.println("O Nome de Usuário não pode ser registrado");
               int p = a.posicao;
               server.KillConexao(p);
               return false;
           }
           
       a.setLogado(nome);
       server.setLogados(nome);
       return true; 
       }else{
           a.saida.println("Você já está logado!");
       }
       return false;
   }
    
   public boolean mensagem(ThreadSocket s, String rem, String dest, String text) throws IOException{
       if(dest.equals("*")){
           for(int i = 0; i < server.getConexoesSize(); i++){
               if(server.getConexoes(i).nome!=rem)
               server.getConexoes(i).saida.println("transmitindo:"+rem+":"+dest+":"+text);
           }
       }
       
       if(dest.contains(";")){
           String[] dests = dest.split(";");
           String nomes = dests[0];
           for(int i = 1; i < dests.length; i++){
               nomes = nomes.concat(";"+dests[i]);
           }
           int x = server.getConexoesSize(),y = dests.length;
           for(int j = 0; j < x; j++){
            for(int i = 0; i < y; i++){
                if(server.getConexoes(j).nome.equals(dests[i])){
                    server.getConexoes(j).saida.println("transmitindo:"+rem+":"+nomes+":"+text);
                }
            }
           }
           return true;
       }else{
           for(int i = 0; i < server.getConexoesSize(); i++){
            if(server.getConexoes(i).nome.equals(dest)){
                   server.getConexoes(i).saida.println("transmitindo:"+rem+":"+dest+":"+text); 
            }
           }
       }
        return true;
   }
   
   public void informarTodos() throws IOException{
       for(int i = 0; i < server.getConexoesSize(); i++){
            String e = listarUsuarios();
            server.getConexoes(i).saida.println(e);
       }
   }
   public String listarUsuarios(){
       String all = "lista_usuarios:";
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
