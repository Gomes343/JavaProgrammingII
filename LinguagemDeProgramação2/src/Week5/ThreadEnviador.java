package Week5;

import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;



public class ThreadEnviador extends Thread{
    Scanner entrada;
    PrintStream saida;
    Scanner teclado = new Scanner(System.in);
    Servidor s = new Servidor();
    
    public ThreadEnviador(Socket p) throws IOException{
        entrada = new Scanner(p.getInputStream());
        saida = new PrintStream(p.getOutputStream());

    }
    
    // esse código é executando quando a thread é inicializada
    public void run(){
        String mensagem = teclado.nextLine();
            if(!mensagem.isEmpty()){
                saida.println(mensagem);
            }
    }  
}

