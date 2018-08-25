package Week5;

import java.io.IOException;
import java.io.PrintStream;
import static java.lang.Thread.sleep;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

public class Servidor {
    
    static ArrayList<String> logados = new ArrayList();
    static ArrayList<Socket> conexoes = new ArrayList();
    static ArrayList<String> comandos = new ArrayList();
    public static String receb = null;

    public void setReceb(String receb) {
        Servidor.receb = receb;
    }
    
    public void getReceb(){
        System.out.println(receb);
        receb = null;
    }
    
    public static void main(String[] args) throws IOException, InterruptedException {
        Servidor server = new Servidor();
        ServerSocket servidor = new ServerSocket(12345);
        System.out.println("Porta 12345 aberta! Aguardando conexão...");
        
        Socket provisorio = servidor.accept();
        
        Scanner teclado = new Scanner(System.in);
        Scanner entrada = new Scanner(provisorio.getInputStream());
        PrintStream saida = new PrintStream(provisorio.getOutputStream());
            ThreadRecebedor recebedor = new ThreadRecebedor(provisorio,server);
            ThreadEnviador enviador = new ThreadEnviador(provisorio);
            
        while(true){
            recebedor.run();

            server.getReceb();
            
            enviador.run();
            
            
            
            /*
            if(entrada.hasNextLine()){
                entry = entrada.nextLine();
                if(!entry.isEmpty())
                    System.out.println(entry);
            }*/


        }  
        

     
        //System.out.println("Nova conexão com o cliente " + cliente.getInetAddress().getHostAddress());
        //System.out.println("Esse socket ficará aberto até que o cliente se desconecte");
     

        
        //Scanner entrada = new Scanner(cliente.getInputStream());
        //PrintStream saida = new PrintStream(cliente.getOutputStream());

   }

    
}
