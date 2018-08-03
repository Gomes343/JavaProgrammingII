package Week2.Exercicio2;

public class Main {
    static int value = 0;
    
    public static void main(String[]args){
        
        //Faca um programa que imprima os números primos existentes entre 
        //0 e 99999 utilizando threads de forma que para cada faixa de mil 
        //valores seja criada uma thread e os processos sejam disparados 
        //simultaneamente.
        
        
        threadSimples[] Threads = new threadSimples[30];
        while(value < 10000){
            for (int i = 0; i < 20 ; i++){
            Threads[i] = new threadSimples(value);
            Threads[i].start();
            
            }
            
            
        }
        
        System.out.println(value);
        
        
        
        
        
    }
}
