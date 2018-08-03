package Week2.Exercicio1;

import java.util.Scanner;
import java.util.Timer;

public class RodandoCaraouCoroa{
    
        
    public static void main(String[]args){
        
        Scanner sc = new Scanner(System.in);
        String x = null;
        
        Moeda moeda = new Moeda();  
        moeda.setStatus("teste");
        threadSimples a = new threadSimples("Cara",moeda);
        threadSimples b = new threadSimples("Coroa",moeda);
        
        
        System.out.println("LISTA 01 - THREAD - EXERCICIO 1");
        
        System.out.println("Iniciando rodagem da moeda, pressione enter para parar");
        System.out.println("Informe o seu Palpite antes:\n");
        String palpite = sc.nextLine();
        
        
        a.start();
        b.start();    
        
        x = sc.nextLine();
        
        if(x != null){
            a.stop();
            b.stop();
        }
        
        System.out.println("\n \n \n \n \n ");
        
        System.out.println("PROGRAMA FINALIZADO");
        
        if(moeda.getStatus().equals(palpite))
            System.out.println("VOCÊ ACERTOU!");
        else
            System.out.println("VOCÊ ERROU!");
        
        
        System.out.println("o Resultado foi: "+moeda.getStatus());
        
        
    }
}
