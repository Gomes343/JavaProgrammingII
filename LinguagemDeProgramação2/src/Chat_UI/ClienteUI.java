package Chat_UI;


// Java implementation for multithreaded chat client 
// Save file as Client.java 
  
import Projeto_Chat_1ºBimestre.InputStream.*;
import java.io.*; 
import java.net.*; 
import java.util.Scanner; 
  
public final class ClienteUI{
    
        Scanner sc = new Scanner(System.in);    
        PrintStream saida;
        Scanner entrada;
        Socket socket;
        boolean conectado = false;
        MenuInicial menu;
        
        public String receber;
        
    public ClienteUI(InetAddress ip, int port,MenuInicial menu) throws IOException{
        
        socket = new Socket(ip,port);
        saida = new PrintStream(socket.getOutputStream());
        entrada = new Scanner(socket.getInputStream());
        this.menu = menu;
        
        if(socket.isConnected())
            conectado = true;
    
        RodarCliente();
        
    }
    
    public void RodarCliente(){
          
        //Enviador.start(); 
        Recebedor.start(); 

                  menu.Recebedor.start();
    
    }
    
/*
        Thread Enviador = new Thread(new Runnable()  { 
            @Override
            public void run(){ 
                while (true){ 
                    String enviar = sc.nextLine(); 
                    menu.setString(enviar);
                    } 
                } 
            } 
        ); */
 
        Thread Recebedor = new Thread(new Runnable(){ 
            @Override
            public void run(){ 
                while (true){ 
                        String receber = entrada.nextLine();
                        menu.setString(receber);
                    } 
                } 
            } 
        ); 

} 