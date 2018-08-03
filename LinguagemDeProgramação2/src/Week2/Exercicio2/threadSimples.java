package Week2.Exercicio2;

import java.util.logging.Level;
import java.util.logging.Logger;

public class threadSimples extends Thread{
    int value;
    int valuefilho;
    
    threadSimples(int v){
        this.value = v;
    }
    
    // esse código é executando quando a thread é inicializada
    public void run(){
        while(valuefilho < 1000){
            
            if(valuefilho%2==1 && valuefilho%3==1)
                value = value + valuefilho;
 
        valuefilho++;    
        try {
              sleep(200);
          } catch (InterruptedException ex) {
              Logger.getLogger(threadSimples.class.getName()).log(Level.SEVERE, null, ex);
          }
          
      }
    }
}
