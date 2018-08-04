package Week2.Exercicio2;

public class Main {
    
    
    public static void main(String[]args){

        //Faca um programa que imprima os números primos existentes entre 
        //0 e 99999 utilizando threads de forma que para cada faixa de mil 
        //valores seja criada uma thread e os processos sejam disparados 
        //simultaneamente.
        
        //Tempo s = new Tempo();
        
        long tempoInicio = System.currentTimeMillis();

        
            for(int i = 0; i < 1000 ; i++){
            threadSimples t = new threadSimples((i*100),((i*100)+100),tempoInicio);
            t.start();
            
                if(i == 99)
                    System.out.println("Tempo Total: "+(System.currentTimeMillis()-tempoInicio));
            }
  
        
        
        
        
    }
}
