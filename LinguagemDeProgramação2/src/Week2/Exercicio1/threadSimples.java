package Week2.Exercicio1;

import java.util.logging.Level;
import java.util.logging.Logger;

public class threadSimples extends Thread{
    String nome;
    boolean infinity = true;
    Moeda moeda = new Moeda();
    
    threadSimples(String status, Moeda moeda){
        this.nome = status;
        this.moeda = moeda;
    }
    
    // esse código é executando quando a thread é inicializada
    public void run(){
        while(infinity == true){
            moeda.setStatus(nome);
            System.out.println(nome);
          try {
              sleep((int) (Math.random() * 30));
          } catch (InterruptedException ex) {
              Logger.getLogger(threadSimples.class.getName()).log(Level.SEVERE, null, ex);
          }
          
      }
    }
}
