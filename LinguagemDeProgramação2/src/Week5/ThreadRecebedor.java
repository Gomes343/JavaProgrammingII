package Week5;

import Projeto_Chat_1ºBimestre.Servidor;
import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;



public class ThreadRecebedor extends Thread{
    Scanner entrada;
    PrintStream saida;
    Scanner teclado = new Scanner(System.in);
    Servidor server = new Servidor();
    boolean isAServer = false;
    
    public ThreadRecebedor(Socket p,Servidor server) throws IOException{
        entrada = new Scanner(p.getInputStream());
        saida = new PrintStream(p.getOutputStream());
        this.server = server;
        isAServer = true;
    }
    public ThreadRecebedor(Socket p) throws IOException{
        entrada = new Scanner(p.getInputStream());
        saida = new PrintStream(p.getOutputStream());
    }
    
    // esse código é executando quando a thread é inicializada
    public void run(){
        if(isAServer == false){
            String entry = null;
            if(entrada.hasNextLine()){
                entry = entrada.nextLine();
                if(!entry.isEmpty())
                    System.out.println(entry);
            }
        }
        if(isAServer == true){
            String entry = null;
            if(entrada.hasNextLine()){
                entry = entrada.nextLine();
                if(!entry.isEmpty())
                    server.setReceb(entry);
            }
        }
    }  
}

