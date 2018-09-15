package Week5;

import static Week5.Servidor.comandos;
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
            Socket p;
    Scanner teclado = new Scanner(System.in);
    static Servidor server = new Servidor();
    int posicao;
    boolean logado = false;
    
    public ThreadSocket(Socket p,Servidor server, int posicao) throws IOException{
        this.p = p;
            entrada = new DataInputStream(p.getInputStream()); 
            saida = new DataOutputStream(p.getOutputStream());
        this.server = server;
        this.posicao = posicao;

    }
    
    public void setLogado(){
        logado = true;
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
                        // read the message sent to this client 
                        entry = entrada.readUTF(); 
                    } catch (IOException e) { 
  
                        e.printStackTrace(); 
                    } 
                if(!entry.isEmpty()){
                    System.out.println("mensagem: "+entry+" processado pela thread!");
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
            case "-h":
                saida.writeUTF("login:nome"
                        + "\nlista_usuarios:nomes"
                        + "\nmensagem:destinatário:texto da mensagem"
                        + "\ntransmitir:remetente:destinatário:texto da mensagem");
                break;
            case "login": 
                if(comandos.login(parts[1],this))
                    saida.writeUTF("O nome de Usuario foi Registrado com Sucesso");
                else
                    saida.writeUTF("O Nome de Usuário não pode ser registrado");
                break;
            case "listausuarios":
                String e = comandos.listarUsuarios(posicao);
                    saida.writeUTF(e);
                break;
        }
    }
    
    
    private boolean format(String formatar) throws IOException{
        if(formatar.contains(":")){
            String[] parts = formatar.split(":"); 
            switchcase(parts,posicao);
            return true;
        }else{
            formatar = formatar.concat(":");
            format(formatar);
        }
        return false;
    }
      
    public void stop() throws IOException{
        this.logado = false;
        this.p.close();

    }
}

