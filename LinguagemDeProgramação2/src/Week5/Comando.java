/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Week5;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

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
    
   public boolean login(String nome,int posicao) throws IOException{
       for(int i = 0; i < server.getLogadosSize(); i++){
           if(server.getLogados(i).equals(nome)){
               System.out.println("erro");
               server.KillConexao(i);
               return false;
           }   
       }
       server.setLogados(nome);
       server.setLogado(posicao);
       return true;       
   }
    
   public String listarUsuarios(int posicao){
       String envio = "";
       for(int i = 0; i < server.getLogadosSize(); i++){
           envio.concat(server.getLogados(i)+":");
       }
   
       return envio;    
    }
}
