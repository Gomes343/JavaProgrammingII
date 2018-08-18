package Week3.Exercicio2;

import static java.lang.Thread.sleep;

public class Pratos{
    
    public boolean sujo;
    private String nome;
    private boolean emUso;

    public boolean isEmUso() {
        return emUso;
    }

    public void setEmUso(boolean emUso) {
        this.emUso = emUso;
    }
    
    public Pratos(String n){
        sujo = false;
        nome = n;
    }

    
    public synchronized void Usando(){
                
         while(this.emUso == true) {  // Aguarda a liberação da conta para operação
            try {
                sleep(2000);
            } catch (InterruptedException e) {
            }
        }
         this.emUso = true;

        try {
            Thread.sleep((long) (Math.random()*7500));
            this.emUso = false;
            this.setSujo(true);
        } catch (InterruptedException e) {
        }

    }
    
    
    
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public boolean isSujo() {
        return sujo;
    }

    public void setSujo(boolean sujo) {
        this.sujo = sujo;
    }

}
