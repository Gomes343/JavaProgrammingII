package Week2.Exercicio2;

public class Main {
    
    
    public static void main(String[]args){


            for(int i = 0; i < 100 ; i++){
            threadSimples t = new threadSimples((i*1000),((i*1000)+1000));
            t.start();

            }

    }
}
