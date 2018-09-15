
// Java implementation for multithreaded chat client 
// Save file as Client.java 
  
import java.io.*; 
import java.net.*; 
import java.util.Scanner; 
  
public class Client  
{
    final static int ServerPort = 12345; 
  
    public static void main(String args[]) throws UnknownHostException, IOException{ 

        Socket s = new Socket("10.10.117.9", ServerPort); 
        
        Scanner sc = new Scanner(System.in); 
        DataInputStream entrada = new DataInputStream(s.getInputStream()); 
        DataOutputStream saida =  new DataOutputStream(s.getOutputStream()); 
  
        Thread sendMessage = new Thread(new Runnable()  { 
            @Override
            public void run() { 
                while (true) { 
  
                    // read the message to deliver. 
                    String msg = sc.nextLine(); 
                      
                    try { 
                        // write on the output stream 
                        saida.writeUTF(msg); 
                    } catch (IOException e) { 
                        e.printStackTrace(); 
                    } 
                } 
            } 
        }); 
          
       
        Thread readMessage = new Thread(new Runnable()  
        { 
            @Override
            public void run() { 
                
                while (true) { 
                    try { 
                        // read the message sent to this client 
                        String msg = entrada.readUTF(); 
                        System.out.println(msg); 
                    } catch (IOException e) { 
  
                        e.printStackTrace(); 
                    } 
                } 
            } 
        }); 
  
        sendMessage.start(); 
        readMessage.start(); 
  
    } 
} 