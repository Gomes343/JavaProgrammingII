package Week3.Sincronizado;

public class ContaCorrente {
    private String nome;
    private float saldo;
    public boolean emOperacao;
    
    ContaCorrente(String n, float s){
        this.nome = n;
        this.saldo = s;
        this.emOperacao = false;
    }
    
    
    //OBSOLETO - MÉTODO SEM SINCRONIA
    public void depositar(float valor){
        System.out.println("Depositando: "+valor);
        
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
        }
        
        this.saldo+=valor;
        System.out.println("Depósito de "+valor+" efetuado com sucesso...");
        System.out.println("Saldo na conta: " + this.saldoAtual());
        System.out.println("------------------------------------");
        
    }
    //OBSOLETO - MÉTODO SEM SINCRONIA
    
    public synchronized void depositarSinc(float valor){
        
         while(this.emOperacao == true) {  // Aguarda a liberação da conta para operação
            try {
                wait(); 
            } catch (InterruptedException e) {
            }
        }
         this.emOperacao = true;
         
         System.out.println("Depositando: "+valor);
        
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
        }
        
        this.saldo+=valor;
        System.out.println("Depósito de "+valor+" efetuado com sucesso...");
        
        System.out.println("Saldo na conta: " + this.saldoAtual());
        System.out.println("------------------------------------");
        
        this.emOperacao = false;
        notifyAll(); //notifica os objetos que estão esperando
        
    }
    
    
    //OBSOLETO - MÉTODO SEM SINCRONIA
    public void sacar(float valor){
        System.out.println("sacando: "+valor);
        
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
        }
        
        this.saldo-=valor;
        System.out.println("Saque de "+valor+" efetuado com sucesso...");
        System.out.println("Saldo na conta: " + this.saldoAtual());
        System.out.println("------------------------------------");
        
    }
    //OBSOLETO - MÉTODO SEM SINCRONIA
    
    public synchronized void sacarSinc(float valor){
        
         while(this.emOperacao == true) {  // Aguarda a liberação da conta para operação
            try {
                wait(); 
            } catch (InterruptedException e) {
            }
        }
         this.emOperacao = true;
         
         this.saldo-=valor;
        System.out.println("Saque de "+valor+" efetuado com sucesso..;");
        
        System.out.println("saldo na conta após o saque: "+this.saldoAtual());
        System.out.println("------------------------------------");
        
        this.emOperacao = false;
        notifyAll();
        }
    
    
    public synchronized void Transferencia(ContaCorrente remetente, float valor, ContaCorrente destino){
        
        while(this.emOperacao == true) {
            try{
                wait();
            }catch(InterruptedException e){
            }
        }    
            this.emOperacao = true;
            
            this.saldo-=valor;
            destino.saldo += valor;
            System.out.println("Transferindo da conta "+remetente.nome+" o valor de: "+valor+" para a conta: "+destino.nome);
            System.out.println("saldo na conta após a transferência: "+this.saldoAtual());
            System.out.println("---------------------------------");
 
            this.emOperacao = false;
            notifyAll();
        
    }
    
    
    
    public float saldoAtual(){
        return this.saldo;
    }
}
