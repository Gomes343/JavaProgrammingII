package Week2.Exercicio2;

public class Main {
    
    
    public static void main(String[]args){

        //Faca um programa que imprima os números primos existentes entre 
        //0 e 99999 utilizando threads de forma que para cada faixa de mil 
        //valores seja criada uma thread e os processos sejam disparados 
        //simultaneamente.
        
        Tempoo s = new Tempoo(System.currentTimeMillis());
        


        
            for(int i = 0; i < 100 ; i++){
            threadSimples t = new threadSimples((i*1000),((i*1000)+1000),s);
            t.start();

            }
  
        
        
        
        
    }
}
