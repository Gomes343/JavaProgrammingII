package Week2.Exercicio3;

import java.util.Scanner;

public class Main {
    public static void main(String[]args){
        int value = 0;
        //Implemente um contador com operações de incremento e decremento
        //que nunca fique inferior a zero, nem superior a 100.
        
        threadSimples a = new threadSimples(value);
        Scanner sc = new Scanner(System.in);
        
        a.start();
        
        String x = sc.nextLine();
        
        if(x != null)
            a.stop();
        
        
        
        
        
    }
}
