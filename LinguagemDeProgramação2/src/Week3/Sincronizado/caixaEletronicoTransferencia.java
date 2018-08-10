package Week3.Sincronizado;

public class caixaEletronicoTransferencia extends Thread{
    private ContaCorrente remetente;
    private float valor;
    private ContaCorrente destino;
    
    public caixaEletronicoTransferencia(ContaCorrente re, float v, ContaCorrente des){
        this.remetente = re;
        this.valor = v;
        this.destino = des;
    }
    
    @Override
    public void run(){
        
        this.remetente.Transferencia(remetente,valor, destino);
        
    }
    
    
}
