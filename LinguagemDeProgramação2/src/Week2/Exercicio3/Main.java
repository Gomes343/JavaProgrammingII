package Week2.Exercicio3;

import java.util.Scanner;

public class Main {
    public static void main(String[]args){
        int value = 0;
        //Implemente um contador com operações de incremento e decremento
        //que nunca fique inferior a zero, nem superior a 100.

        Contador contador = new Contador();

        
        
        //threadSimples up = new threadSimples("up",contador);
        //threadSimples down = new threadSimples("down",contador);
        
        Scanner sc = new Scanner(System.in);
            
                threadSimples up = new threadSimples("up",contador);
                up.start();
            
                threadSimples down = new threadSimples("down",contador);
                down.start();
            
        

        

        
        
    }
}
