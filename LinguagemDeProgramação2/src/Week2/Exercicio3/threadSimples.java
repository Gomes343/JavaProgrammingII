package Week2.Exercicio3;

import static java.lang.Thread.sleep;
import java.util.logging.Level;
import java.util.logging.Logger;

public class threadSimples extends Thread{
    int x = 0;
    int value;
    
    threadSimples(int value){
        this.value = value;
    }
    
    // esse código é executando quando a thread é inicializada
    public void run(){
        while(true){
        if(value == 100){
            while(value != 0){
                value--;
                System.out.println(value);
                try {
                    sleep(25);
                } catch (InterruptedException ex) {
                    Logger.getLogger(threadSimples.class.getName()).log(Level.SEVERE, null, ex);
                }
            }            
        }
        
        if(value == 0){
            while(value != 100){
                System.out.println(value);
                value++;
                try {
                    sleep(25);
                } catch (InterruptedException ex) {
                    Logger.getLogger(threadSimples.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        }
    }

}
