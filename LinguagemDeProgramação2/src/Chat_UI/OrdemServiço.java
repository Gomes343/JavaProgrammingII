package Chat_UI;

public class OrdemServiço {

    private String nome;
    private int numero;
    
    public OrdemServiço(String n, int nu){
        nome = n;
        numero = nu;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

}
