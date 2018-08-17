package Week3.Exercicio2;

public class Pratos {
    
    private boolean status = false;
    
    public void Switch(){
        if(status == false)
            status = true;
                    
        if(status == true)           
            status = false;
        
    }
    
    public boolean IsPratoEmUso(){
        return status;
    }
    

}
