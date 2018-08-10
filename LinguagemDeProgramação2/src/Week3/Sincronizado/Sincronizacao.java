package Week3.Sincronizado;

import static java.lang.Thread.sleep;

public class Sincronizacao {

    public static void main(String[] args) throws InterruptedException {

         ContaCorrente a123cc4343x = new ContaCorrente("Murilo",100);
         
         System.out.println("Saldo inicial: " + a123cc4343x.saldoAtual());
         System.out.println("------------------------------------");

         caixaEletronicoDeposito operacao1 = new caixaEletronicoDeposito(a123cc4343x, 100);
         caixaEletronicoDeposito operacao2 = new caixaEletronicoDeposito(a123cc4343x, 200);
         caixaEletronicoDeposito operacao3 = new caixaEletronicoDeposito(a123cc4343x, 300);
         caixaEletronicoDeposito operacao4 = new caixaEletronicoDeposito(a123cc4343x, 400);
         
         
         operacao1.start();
         operacao2.start();
         operacao3.start();
         operacao4.start();
         
         while(operacao1.isAlive() || operacao2.isAlive() || operacao3.isAlive() || operacao4.isAlive())
             sleep(50);//GAMBIARRAS QUE FORAM NECESSARIAS
         
         
         System.out.println("INICIANDO FASE RELACIONADA A SAQUE");
         
         System.out.println("Saldo inicial: " + a123cc4343x.saldoAtual());
         System.out.println("--------------------------------------");
         
         caixaEletronicoSaque operacao5 = new caixaEletronicoSaque(a123cc4343x, 500);
         caixaEletronicoSaque operacao6 = new caixaEletronicoSaque(a123cc4343x, 150);
         
         operacao5.start();
         operacao6.start();
         
        while(operacao5.isAlive() || operacao6.isAlive())
            sleep(50);//GAMBIARRAS QUE FORAM NECESSARIAS
        
        System.out.println("INICIANDO FASE RELACIONADA A TRANSFERÊNCIA!");
        
        ContaCorrente i8009295 = new ContaCorrente("Cliente",2000);
        
        caixaEletronicoTransferencia operacao7 = new caixaEletronicoTransferencia(a123cc4343x, 200, i8009295);
        
        operacao7.start();
        
        while(operacao7.isAlive())
            sleep(50);//GAMBIARRAS QUE FORAM NECESSARIAS
        
        
        System.out.println("-----------");
        
        System.out.println("Saldo da conta destino: "+i8009295.saldoAtual());
        
        
    }
    
}
