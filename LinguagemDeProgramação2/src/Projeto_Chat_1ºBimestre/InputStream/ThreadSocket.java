package Projeto_Chat_1ºBimestre.InputStream;

import static Projeto_Chat_1ºBimestre.InputStream.Servidor.comandos;
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
        PrintStream saida;
        Scanner entrada;
    Socket socket;
    Scanner teclado = new Scanner(System.in);
    static Servidor server = new Servidor();
    int posicao;
    boolean logado = false;
    String nome;
    
    public ThreadSocket(Socket p,Servidor server, int posicao) throws IOException{
        this.socket = p;
        this.server = server;
            saida = new PrintStream(socket.getOutputStream());
            entrada = new Scanner(socket.getInputStream());
        this.posicao = posicao;
        //saida.println("eae");

    }
    
    public void liberarAcesso() throws IOException{
        if(this.isLogado())
            saida = new PrintStream(socket.getOutputStream());
            entrada = new Scanner(socket.getInputStream());
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
            
            //saida.println("=== BEM VINDO ===");
            //saida.println("Escreva -h para visualizar os comandos");
            
            while(true){
                
                entry = entrada.nextLine(); 
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
                    //saida.println("O nome de Usuario foi Registrado com Sucesso");
                    comandos.informarTodos();
                }
                break;
            case "mensagem":
                if(comandos.mensagem(this, this.nome, parts[1], parts[2]))
                    //saida.println("Mensagem enviada");
                //else
                    //saida.println("Mensagem não enviada!");
                    break;
        }
    }
    
    
    private void switchcase(String info,int posicao) throws IOException{
        switch(info){
            case "-h":
                saida.println("login:nome"
                        + "\nmensagem:destinatário:texto da mensagem"
                        + "\ntransmitir:remetente:destinatário:texto da mensagem");
                break;
            case "listausuarios":
                String e = comandos.listarUsuarios();
                    saida.println(e);
                break;
            case "listaconexoes":
                String all = comandos.listarConexoes();
                saida.println(all);
                break;
            default:
                saida.println("Não contêm um comando em sua mensagem;");
                break;
        }
    }    
    /*
    public void renovar(){
        for(int i = 0; i < server.getConexoesSize(); i++){
                server.getConexoes(i).saida.
        }
    }*/
    
    private boolean format(String formatar) throws IOException{
        formatar = formatar.toLowerCase();
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

