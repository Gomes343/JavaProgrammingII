package Projeto_Chat_1ºBimestre.DataStream;

import Projeto_Chat_1ºBimestre.DataStream.Servidor;
import static Projeto_Chat_1ºBimestre.DataStream.Servidor.comandos;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;



public class ThreadSocket implements Runnable{
    DataInputStream entrada;
    DataOutputStream saida;
    Socket socket;
    Scanner teclado = new Scanner(System.in);
    static Servidor server = new Servidor();
    int posicao;
    boolean logado = false;
    String nome;
    
    public ThreadSocket(Socket p,Servidor server, int posicao) throws IOException{
        this.socket = p;
            entrada = new DataInputStream(p.getInputStream()); 
            saida = new DataOutputStream(p.getOutputStream());
        this.server = server;
        this.posicao = posicao;

    }
    
    public void setLogado(String nome){
        logado = true;
        this.nome = nome;
    }

    public boolean isLogado(){
        return logado;
    }
    
    public void run(){

            String entry = null;
            
                try {
                    saida.writeUTF("=== BEM VINDO ===");
                    saida.writeUTF("Escreva -h para visualizar os comandos");
                } catch (IOException ex) {
                    Logger.getLogger(ThreadSocket.class.getName()).log(Level.SEVERE, null, ex);
                }
            
            while(true){
                
                try { 
                        entry = entrada.readUTF(); 
                    } catch (IOException e) { 
  
                        e.printStackTrace(); 
                    } 
                if(!entry.isEmpty()){
                    System.out.println("Mensagem vindo de: "+socket.getInetAddress()+" ---- "+entry+" processado pela thread!");
                    try {
                        format(entry);
                    } catch (IOException ex) {
                        Logger.getLogger(ThreadSocket.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
            
    }
    
    private void switchcase(String[] parts,int posicao) throws IOException{
        String choicer = parts[0];
        switch(choicer){
            case "login": 
                if(comandos.login(parts[1],this)){
                    saida.writeUTF("O nome de Usuario foi Registrado com Sucesso");
                    comandos.informarTodos();
                }
                break;
            case "mensagem":
                if(comandos.mensagem(this, this.nome, parts[1], parts[2]))
                    saida.writeUTF("Mensagem enviada");
                else
                    saida.writeUTF("Mensagem não enviada!");
        }
    }
    
    
    private void switchcase(String info,int posicao) throws IOException{
        switch(info){
            case "-h":
                saida.writeUTF("login:nome"
                        + "\nlista_usuarios:nomes"
                        + "\nmensagem:destinatário:texto da mensagem"
                        + "\ntransmitir:remetente:destinatário:texto da mensagem");
                break;
            case "listausuarios":
                String e = comandos.listarUsuarios();
                    saida.writeUTF(e);
                break;
            case "listaconexoes":
                String all = comandos.listarConexoes();
                saida.writeUTF(all);
                break;
            default:
                saida.writeUTF("Não contêm um comando em sua mensagem;");
                break;
        }
    }    
    
    
    private boolean format(String formatar) throws IOException{
        if(formatar.contains(":")){
            String[] parts = formatar.split(":"); 
            switchcase(parts,posicao);
            return true;
        }
            switchcase(formatar,posicao);
            return true;
    }
      
    public void stop() throws IOException{
        this.logado = false;
        this.socket.close();
    }

}

