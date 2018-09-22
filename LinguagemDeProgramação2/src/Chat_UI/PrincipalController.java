package Chat_UI;


import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.math.BigInteger;
import java.net.InetAddress;
import java.net.Socket;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class PrincipalController implements Initializable {

    @FXML
    private TextField ip;
    
    @FXML
    private TextField port;

    @FXML
    private JFXButton Logar;

    @FXML
    private void ButtonLogarAction(ActionEvent event) throws UnknownHostException, IOException {
        try{
            int i = Integer.parseInt(ip.getText());
            byte[] bytes = BigInteger.valueOf(i).toByteArray();
            InetAddress a = InetAddress.getByAddress(bytes);
            Socket socket = new Socket(a,Integer.parseInt(port.getText()));
            if(socket.isConnected()){
                /*
                FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlFile));
                Parent root;
                    try{
                        root = (Parent)loader.load();

                        BasicCalculatorView controller = (BasicCalculatorView)loader.getController();
                        controller.setModel(new BasicCalculatorModelTest(controller));
                        controller.setLogic(this);
        
                        if(fxmlFile.equals("TestSwitch.fxml")){
                            TestSwitch controller = (TestSwitch)loader.getController();
                            controller.setLogic(this);
                        }
                    this.stage.setScene(new Scene(root));
                    } 
                    catch (IOException e){
                        e.printStackTrace();
                    }*/
            }else{
                System.out.println(socket.isConnected()+" erro ao socket se conectar");
            }
        }catch(Exception e){
            System.out.println(e);
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    
    
}
