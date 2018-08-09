package Week2.Exercicio3;

import static java.lang.Thread.sleep;
import java.util.logging.Level;
import java.util.logging.Logger;

public class threadSimples extends Thread{
    int value;
    Contador contador = new Contador();
    String choice;
    
    threadSimples(String c, Contador co){
        this.choice = c;
        this.contador = co;
    }
    
    // esse código é executando quando a thread é inicializada
    public void run(){
        while(true){
            switch(choice){
                case "up":
                    up();
                    
                case "down":
                    down();
                    
            }

        }
    }

    public void up(){
        while(true){

             if(contador.getX() == 0){
                 while(contador.getX() != 100){
                 value = contador.getX();
                 contador.setX(value+1);
                 System.out.println(contador.getX());
                 try {
                     sleep(35);
                 } catch (InterruptedException ex) {
                     Logger.getLogger(threadSimples.class.getName()).log(Level.SEVERE, null, ex);
                 }
                 }
             }   
             try {
                sleep(1900);
             } catch (InterruptedException ex) {
                Logger.getLogger(threadSimples.class.getName()).log(Level.SEVERE, null, ex);
             }  
        }
    }
    public void down(){
        while(true){
             if(contador.getX() == 100){
                 while(contador.getX() != 0){
                     value = contador.getX();
                     contador.setX(value-1);
                     System.out.println(contador.getX());
                 try {
                     sleep(35);
                 } catch (InterruptedException ex) {
                     Logger.getLogger(threadSimples.class.getName()).log(Level.SEVERE, null, ex);
                 }
                 }
                 

             }    
             try {
                sleep(1900);
             } catch (InterruptedException ex) {
                Logger.getLogger(threadSimples.class.getName()).log(Level.SEVERE, null, ex);
             }
        }
    }
}
