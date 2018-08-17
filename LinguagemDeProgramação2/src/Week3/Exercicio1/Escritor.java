package Week3.Exercicio1;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Escritor extends Thread{
    
    Mensagem m;
    ArrayList<String> mensagens = new ArrayList();
    
    int i = 0;
    
    
    public Escritor(Mensagem m){
        this.m = m;
        GerarMensagem();
    }
    
    public void EnviarMensagem(){
        if(m.MensagemIsNull()){
            this.m.EscreverMensagem(mensagens.get(i));
            i++;
        }else{
            try {
                sleep((long) (Math.random()*20));
            } catch (InterruptedException ex) {
                Logger.getLogger(Escritor.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.out.println("Impossível Escrever, já existe uma Mensagem!");
        }    
            
    }
    
    public void GerarMensagem(){
        
        mensagens.add("Palavra 1");
        mensagens.add("Palavra 2");
        mensagens.add("Palavra 3");
        mensagens.add("Palavra 4");
        mensagens.add("Palavra 5");
        mensagens.add("Palavra 6");
        mensagens.add("Palavra 7");
        mensagens.add("Palavra 8");
        mensagens.add("Palavra 9");
        mensagens.add("Palavra 10");
        mensagens.add("Palavra 11");
        mensagens.add("Palavra 12");

        
        /*
        if(i < 50){
        Double x = Math.random()*100;
        this.mensagem = Double.toString(x);
        i++;
        }else{
            this.mensagem = "0";
            stop();
        }*/ 
        //PRIMEIRO MODELO PARA O EXERCICIO, PORÉM, COMO GERAVA ALEATORIAMENTE
        //NÃO ERA POSSÍVEL SABER SE HAVIA OU NÃO SINCRONIA!

    }
    
    @Override
    public void run(){
        while(true){
            EnviarMensagem();   
            try{
                sleep((long) (Math.random()*1000));
            }catch(Exception e){
                System.out.println(e);
            }
            
        }
    }
    
}
