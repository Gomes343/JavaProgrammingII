package Week3.Exercicio1;

public class Main {
    public static void main(String[]args){
        Mensagem mensagem = new Mensagem();
        Escritor escritor = new Escritor(mensagem);
        Leitor leitor = new Leitor(mensagem);
        
        escritor.start();
        leitor.start();
        
        
        
        
        
        
        
        
        
        
        
        
    }
}
