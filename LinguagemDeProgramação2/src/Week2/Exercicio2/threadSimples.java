package Week2.Exercicio2;

import java.util.logging.Level;
import java.util.logging.Logger;

public class threadSimples extends Thread{
    int min;
    int max;
    int x;
    Tempoo tempo;
    
    threadSimples(int m,int maximo,Tempoo t){
        this.min = m;
        this.max = maximo;
        x = m;
        this.tempo = t;
    }
    
    // esse código é executando quando a thread é inicializada
    public void run(){
        while(x < max){

            if(ehPrimo(x))
                System.out.println(x);
            
            x++;
            
      }
       // Tempoo.t = System.currentTimeMillis() - Tempoo.valor;
    }
    
        public boolean ehPrimo(int valor) {
        if (valor < 2) {
            return false;
        }
        if (valor == 2) {
            return true;
        }

        for (int i = (valor - 1); i >= 2; i--) {
            if ((valor % i) == 0) {
                return false;
            }
        }

        return true;
    }
}
