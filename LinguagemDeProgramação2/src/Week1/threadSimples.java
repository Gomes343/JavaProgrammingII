package Week1;

import java.util.logging.Level;
import java.util.logging.Logger;

public class threadSimples extends Thread{
    String usuario;
    
    threadSimples(String usr){
        this.usuario = usr;
    }
    
    // esse código é executando quando a thread é inicializada
    @Override
    public void run(){
      for(int i=1; i<=50; i++){
            System.out.println("Usuário:"+usuario+" Valor:"+i);
          try {
              sleep(10);
          } catch (InterruptedException ex) {
              Logger.getLogger(threadSimples.class.getName()).log(Level.SEVERE, null, ex);
          }
      }
      
        System.out.println("Código Finalizado para o Usuário "+usuario);
    }
}
