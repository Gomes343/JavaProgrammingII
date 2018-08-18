package Week4.Exercicio1;

import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ServidorPingPong {
    public static void main(String[]args) throws IOException{
        
        
        //QUESITOS DE CONEXÃO
    ServerSocket servidor = new ServerSocket(12345);
     
    System.out.println("Porta 12345 aberta! Aguardando conexão...");
     
    Socket cliente = servidor.accept();
    
    System.out.println("Nova conexão com o cliente " + cliente.getInetAddress().getHostAddress());
    
    
    
    
        //INICIALIZAÇÃO DOS INPUT E OUTPUT
    Scanner teclado = new Scanner(System.in);
    PrintStream saida = new PrintStream(cliente.getOutputStream());
    Scanner entrada = new Scanner(cliente.getInputStream());
    boolean VezDoServidor = true; 
    
        System.out.println(" Eu sou o Servidor! - Aguarde sua Vez!");
     while (true) {
         

            while(VezDoServidor == false){
                if(entrada.hasNext()){
                System.out.println("O Cliente escreveu: "+entrada.nextLine());
                VezDoServidor = true;
                break;
                }
            }
            
            if(VezDoServidor == true){
                System.out.println("É a Sua Vez! Escreva algo: ");
                saida.println(teclado.nextLine());
                VezDoServidor = false;
                
            }

     }

    }
}
