package Week3.NãoSincronizado;

public class ContaCorrente {

    private float saldo;

    
    ContaCorrente(float s){
        this.saldo = s;

    }
    
    public void depositar(float valor){
        System.out.println("Depositando: "+valor);
        
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
        }
        
        this.saldo+=valor;
        System.out.println("Depósito de "+valor+" efetuado com sucesso...\n"
                + "\nSaldo na conta: " + this.saldoAtual()
                + "-----------------------------------------------------\n");
        //System.out.println("Saldo na conta: " + this.saldoAtual());
        //System.out.println("------------------------------------");
        
    }
    
    
    public float saldoAtual(){
        return this.saldo;
    }
    
}
