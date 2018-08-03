package week1;

public class TestaThreads {
    public static void main(String[] args) {
        threadSimples a = new threadSimples("Ederson");
        threadSimples b = new threadSimples("o Bonito");
        threadSimples c = new threadSimples("e Mentiroso");
        
        a.start();
        b.start();
        c.start();
        

               
        System.out.println("Programa terminou ?");
        
    }
    
}
