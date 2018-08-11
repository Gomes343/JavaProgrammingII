package Week3.Exercicio1;

import static java.lang.Thread.sleep;

public class Leitor extends Thread{
    
    Mensagem m;
    String mensagem;
    
    public Leitor(Mensagem m){
        this.m = m;
    }
    
    public void LerMensagem(){
        if(m.MensagemIsNull())
            System.out.println("Não há mensagem para ler");
        else{   
            this.m.LerMensagem();
            if(m.finalizado == true)
                stop();
        }    
    }

    @Override
    public void run(){
        while(true){
            LerMensagem();   
            try{
                sleep((long) (Math.random()*1000));
            }catch(Exception e){
                System.out.println(e);
            }
            
        }
    }
    
}
