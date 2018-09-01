package Week5;

import static Week5.Servidor.comandos;
import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;



public class ThreadSocket extends Thread{
    Scanner entrada;
    static PrintStream saida;
    Scanner teclado = new Scanner(System.in);
    static Servidor server = new Servidor();
    int posicao;
    boolean logado = false;
    
    public ThreadSocket(Socket p,Servidor server, int posicao) throws IOException{
        entrada = new Scanner(p.getInputStream());
        saida = new PrintStream(p.getOutputStream());
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
            if(entrada.hasNextLine()){
                entry = entrada.nextLine();
                if(!entry.isEmpty()){
                    System.out.println("processado pela thread!");
                    try {
                        format(entry,posicao);
                    } catch (IOException ex) {
                        Logger.getLogger(ThreadSocket.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }    
            }
    }
    static void switchcase(String[] parts,int posicao) throws IOException{
        String choicer = parts[0];
        switch(choicer){
            case "help":
                saida.println("login:nome"
                        + "\nlista_usuarios:nomes"
                        + "\nmensagem:destinatário:texto da mensagem"
                        + "\ntransmitir:remetente:destinatário:texto da mensagem");
                break;
            case "login": 
                if(comandos.login(parts[1],posicao))
                    saida.println("O nome de Usuario foi Registrado com Sucesso");
                else
                    saida.println("O Nome de Usuário não pode ser registrado");
                break;
            case "listausuarios":
                String e = comandos.listarUsuarios(posicao);
                    saida.println(e);
                break;
        }
    }
    
    
    static boolean format(String formatar, int posicao) throws IOException{
        if(formatar.contains(":")){
            String[] parts = formatar.split(":"); 
            switchcase(parts,posicao);
            return true;
        }
        return false;
    }
      
}

