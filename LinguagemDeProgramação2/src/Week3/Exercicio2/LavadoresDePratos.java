package Week3.Exercicio2;

import java.util.ArrayList;

public class LavadoresDePratos extends Thread{
    
    private boolean emUso;
    private String nome;
    private ArrayList<Pratos> pratos;
    
    public LavadoresDePratos(String n, ArrayList<Pratos> p){
        emUso = false;
        nome = n;
        pratos = new ArrayList(p);
    }

        @Override
    public void run(){
        while(true){
            try{
                System.out.println(nome+" Procurando Pratos Sujos!");
                for(int i = 0; i < pratos.size(); i++){
                    if(true == pratos.get(i).sujo){
                        System.out.println(nome+" Lavando o "+pratos.get(i).getNome());
                        sleep((long) (Math.random()*10000));
                        LavarPrato(pratos.get(i));
                        //pratos.get(i).Switch();

                    }
                }
                sleep((long) (Math.random()*8500));
            }catch(Exception e){
                System.out.println(e);
            }
        }
    }


    
    public synchronized void LavarPrato(Pratos p){

        p.setSujo(false);
        System.out.println(p.getNome()+" Está lavado!");
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    
    
    
    
    
    
    
}
