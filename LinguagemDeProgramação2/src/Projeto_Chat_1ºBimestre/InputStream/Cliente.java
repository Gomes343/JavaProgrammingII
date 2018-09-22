package Projeto_Chat_1ºBimestre.InputStream;


// Java implementation for multithreaded chat client 
// Save file as Client.java 
  
import java.io.*; 
import java.net.*; 
import java.util.Scanner; 
  
public class Cliente{
    
    public static void main(String args[]) throws UnknownHostException, IOException{ 

        Socket s = new Socket("10.10.117.28", 6666); 
        
        Scanner sc = new Scanner(System.in); 
        
        PrintStream saida = new PrintStream(s.getOutputStream());
        Scanner entrada = new Scanner(s.getInputStream());
        
        
        Thread Enviador = new Thread(new Runnable()  { 
            @Override
            public void run(){ 
                while (true){ 
                    String enviar = sc.nextLine(); 
                    saida.println(enviar);
                    } 
                } 
            } 
        ); 
 
        Thread Recebedor = new Thread(new Runnable(){ 
            @Override
            public void run(){ 
                while (true){ 
                        String receber = entrada.nextLine();
                        System.out.println(receber); 
                    } 
                } 
            } 
        ); 
  
        Enviador.start(); 
        Recebedor.start(); 
  
    } 
} 