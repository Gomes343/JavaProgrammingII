/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Week4.Exercicio1;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author a1700677
 */
public class ClientePingPong {
    public static void main(String[]args) throws IOException{
        
        
            //QUESITOS DE CONEXÃO
        Socket cliente = new Socket("127.0.0.1", 12345);
        System.out.println("O cliente se conectou ao servidor!");
     
        
        
    
        //INICIALIZAÇÃO DOS INPUT E OUTPUT
    Scanner teclado = new Scanner(System.in);
    PrintStream saida = new PrintStream(cliente.getOutputStream());
    Scanner entrada = new Scanner(cliente.getInputStream());
    boolean VezDoCliente = false;
    
    teclado.
     System.out.println("Eu sou o Cliente! - Aguarde sua vez");
     while (true) {

            while(VezDoCliente == false){
                if(entrada.hasNext()){
                System.out.println("O Servidor escreveu: "+entrada.nextLine());
                VezDoCliente = true;
                break;
                }
            }
            
            if(VezDoCliente == true){
                System.out.println("É a Sua Vez! Escreva algo: ");
                saida.println(teclado.nextLine());
                VezDoCliente = false;
                
            }
        
        
     }

    }
}
