package Week4.Exercicio2;

import Week4.*;
import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Servidor {
    public static void main(String[] args) throws IOException {
     ServerSocket servidor = new ServerSocket(8000);
     
     System.out.println("Porta 8000 aberta! Aguardando conexão...");
     
     Socket cliente = servidor.accept();
     
    PrintStream saida = new PrintStream(cliente.getOutputStream());
    
    Scanner entrada = new Scanner(cliente.getInputStream());
     
     while(entrada.hasNextLine()){

         System.out.println(entrada.nextLine());
         
         
         
         if(entrada.nextLine().isEmpty()){
             saida.println("HTTP/1.1 200 OK\n" +
                           "Content-Type: text/html; charset=utf-8\n" +
                           "\n" +
                           "<h1>Olá Mundo</h1>");
             
             cliente.close();
             
             servidor.close();
             
         }

     }

   }
    
}

