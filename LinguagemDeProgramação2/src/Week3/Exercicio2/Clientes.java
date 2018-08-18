package Week3.Exercicio2;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Clientes extends Thread{
    String nome;
    boolean emUso;
    ArrayList<Pratos> pratos;
    
    public Clientes(String n, ArrayList<Pratos> p){
        nome = n;
        emUso = false;
        pratos = new ArrayList(p);
        //EntrarNoRestaurante();
    }
    
        @Override
    public void run(){
            try{
                
            EntrarNoRestaurante();
                
            }catch(Exception e){
                System.out.println(e);
            }
    }
    
    
    public void EntrarNoRestaurante(){
        System.out.println(nome + " entrou e está escolhendo");
        try {
            sleep((long) (Math.random()*7500));
            PratoDisponivel();
        } catch (InterruptedException ex) {
            Logger.getLogger(Clientes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void PratoDisponivel(){
        boolean aconteceu = false;
        for(int i = 0; i < pratos.size()-1; i++){
            if(pratos.get(i).isSujo()==false){
                Comer(pratos.get(i));
                aconteceu = true;
            }
        }
        
        
        
        if(aconteceu == false){
            System.out.println(nome +" Foi embora por falta de pratos");
        }
        
    }
    
    public void Comer(Pratos p){
                
         while( (this.emUso == true) && (p.isEmUso() == true) ) {  // Aguarda a liberação da conta para operação
            try {
                sleep((long) (Math.random()*3000));
            } catch (InterruptedException e) {
            }
        }
         this.emUso = true;
         p.Usando();
         System.out.println(nome + " Está comendo com o "+p.getNome());
        
        try {
            Thread.sleep((long) (Math.random()*8000));
            System.out.println(nome + " Terminou a Refeição e foi embora!");
        } catch (InterruptedException e) {
        }

    }
    
    public void Sair(){
        
    }
    
    
}
