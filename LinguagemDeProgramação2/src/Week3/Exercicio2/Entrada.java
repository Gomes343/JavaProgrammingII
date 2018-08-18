package Week3.Exercicio2;

import static java.lang.Thread.sleep;
import java.util.ArrayList;
import java.util.Scanner;

public class Entrada {

    public static void main(String[]args) throws InterruptedException{
        ArrayList<Pratos> pratos = new ArrayList();
        ArrayList<LavadoresDePratos> lavadores = new ArrayList();
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Insira a quantidade de pratos a serem utilizados");
        //int qtPratos = sc.nextInt();
        
        //TESTANDO TUDO
        for(int i = 0; i < 5; i++){
            Pratos p = new Pratos("Prato "+i);
            pratos.add(p);
            System.out.println(pratos.get(i).getNome());
        }
        
        
        
        
        LavadoresDePratos lavador1 = new LavadoresDePratos("Lavador 1", pratos);

        lavador1.start();
               
        
        for(int i = 0; i < 15; i++){
            sleep((long) (Math.random()*4500));
            Clientes c = new Clientes("Cliente "+i,pratos);
            c.start();
        }
        
        
        
        
        
    }
}
