package Projeto_Chat_1ºBimestre;


// Java implementation for multithreaded chat client 
// Save file as Client.java 
  
import java.io.*; 
import java.net.*; 
import java.util.Scanner; 
  
public class Cliente{
    public static void main(String args[]) throws UnknownHostException, IOException{ 

        Socket s = new Socket("127.0.0.1", 12345); 
        
        Scanner sc = new Scanner(System.in); 
        
        DataInputStream entrada = new DataInputStream(s.getInputStream()); 
        DataOutputStream saida =  new DataOutputStream(s.getOutputStream()); 
  
        
        
        
        
        
        
        
        
        
        
        
        
        Thread Enviador = new Thread(new Runnable()  { 
            @Override
            public void run(){ 
                while (true){ 
                    String enviar = sc.nextLine(); 
                    try { 
                        saida.writeUTF(enviar); 
                    } catch (IOException e) { 
                        e.printStackTrace(); 
                    } 
                } 
            } 
        }); 
          
        
        
        
        
        
        
        
        
       
        Thread Recebedor = new Thread(new Runnable(){ 
            @Override
            public void run(){ 
                while (true){ 
                    try{ 
                        String receber = entrada.readUTF(); 
                        System.out.println(receber); 
                    }catch(IOException e){ 
  
                        e.printStackTrace(); 
                    } 
                } 
            } 
        }); 
  
        
        Enviador.start(); 
        Recebedor.start(); 
  
    } 
} 