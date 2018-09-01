package Week5;

import Week4.*;
import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Cliente {
    public static void main(String[] args) throws UnknownHostException, IOException {
        
        //O IP se refere a qual maquina da sala se conectar
        Socket cliente = new Socket("127.0.0.1", 12345);

        Scanner teclado = new Scanner(System.in);
        PrintStream saida = new PrintStream(cliente.getOutputStream());
        Scanner entrada = new Scanner(cliente.getInputStream());
        String mensagem = null;
        String entry = null;
        
          ThreadEnviador enviador = new ThreadEnviador(cliente);
          ThreadRecebedor recebedor = new ThreadRecebedor(cliente);        
          
        while(true){
          
          
          enviador.run();
          
          
          recebedor.run();

          

            
        }    
    }
}
