package Projeto_Chat_1ºBimestre;

import java.io.IOException;
import java.io.PrintStream;
import static java.lang.Thread.sleep;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

public class Servidor {
    
    public static ArrayList<String> logados = new ArrayList();
    public static ArrayList<Socket> sockets = new ArrayList();
    public static ArrayList<ThreadSocket> conexoes = new ArrayList();
    public static String[] recebido;

    public static Comando comandos;
    public static String receb = null;

    public static Socket provisorio;
    public static PrintStream saida;

    public ThreadSocket getConexoes(int i) {
        return conexoes.get(i);
    }

    public void setConexoes(ArrayList<ThreadSocket> conexoes) {
        Servidor.conexoes = conexoes;
    }

    public int getConexoesSize(){
        return conexoes.size();
    }
    public int getLogadosSize(){
        return logados.size();
    }
    
    public void setLogados(String nome){
        logados.add(nome);
    }
    
    public String getLogados(int i){
        return logados.get(i);
    }

    public void setReceb(String receb,int i) {
        Servidor.recebido[i] = receb;
    }
    
    public void getReceb(){
        if(receb != null){
        System.out.println(receb);
        receb = null;
        }
    }
    public void KillConexao(int i) throws IOException{
        conexoes.get(i).stop();
        sockets.get(i).close();
    }
        

    public boolean isLogado(int i){
        return conexoes.get(i).isLogado();
    }
    
    
    public static void main(String[] args) throws IOException, InterruptedException {
        Servidor server = new Servidor();
        
        ServerSocket servidor = new ServerSocket(12345);
        System.out.println("Porta 12345 aberta! Aguardando conexão...");
        
        comandos = new Comando(servidor, server);        
        
        recebido = new String[20];
        
        Scanner teclado = new Scanner(System.in);

        Socket Provisorio;

        while(true){
            try{
            Provisorio = servidor.accept();
            if(Provisorio.isConnected()){
                System.out.println("Alguem tentando se conectar! "+Provisorio.getInetAddress().getHostAddress());
                sockets.add(Provisorio);
                ThreadSocket t = new ThreadSocket(sockets.get(sockets.size()-1),server,sockets.size()-1);
                Thread d = new Thread(t);
                d.start();
                conexoes.add(t);
                //conexoes.get(conexoes.size()-1).start();
            }
            }catch(Exception e){
                
            }
            
            
            
        }  
        
   }

}
