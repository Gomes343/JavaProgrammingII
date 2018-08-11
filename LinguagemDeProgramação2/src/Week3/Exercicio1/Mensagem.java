package Week3.Exercicio1;

import static java.lang.Thread.sleep;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Mensagem {

private String mensagem = null;
public boolean emOperacao = false;
public boolean finalizado = false;

    public synchronized void EscreverMensagem(String m){
        while(this.emOperacao == true){
            try {
                wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(Mensagem.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        this.emOperacao = true;
        
        if(MensagemIsNull())
            this.mensagem = m;
        else{
            try {
                sleep((long) (Math.random()*20));
            } catch (InterruptedException ex) {
                Logger.getLogger(Mensagem.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.out.println("Mensagem já existe!");
        }
        
        this.emOperacao = false;
        notifyAll();
    }
    
    public synchronized void LerMensagem(){
        while(this.emOperacao == true){
            try {
                wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(Mensagem.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        this.emOperacao = true;
        
        if(MensagemIsNull())
            System.out.println("NÃO HÁ MENSAGEM");
        else{
            
            if(mensagem == null)
                finalizado = true;
                
            System.out.println("Mensagem Escrita é: "+mensagem);
            mensagem = null;
        }   
        
        this.emOperacao = false;
        notifyAll();

    }

    public boolean MensagemIsNull(){
        if(mensagem == null)
            return true;
        else
            return false;
    }
}















  
