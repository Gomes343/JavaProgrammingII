package Week3.Sincronizado;

public class caixaEletronicoSaque extends Thread{
    float valor;
    ContaCorrente cc;
    
    caixaEletronicoSaque(ContaCorrente c,float v){
        this.valor = v;
        this.cc = c;
    }
    
    @Override
    public void run(){
        
       if(cc.saldoAtual() > this.valor)
        this.cc.sacarSinc(this.valor);
       else
        System.out.println("Não há saldo suficiente!\n");
       
    }
    
}
