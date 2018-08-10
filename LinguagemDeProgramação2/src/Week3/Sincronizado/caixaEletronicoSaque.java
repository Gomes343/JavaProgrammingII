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
 
       this.cc.sacarSinc(this.valor);
       
    }
    
}
