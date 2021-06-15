package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Login_Controller {
    @FXML TextField txtEmail;
    @FXML PasswordField txtContrasenia;
    Conexion conexion= new Conexion();

    public void accion (){

        String email=txtEmail.getText().trim();
        String contra=txtContrasenia.getText().trim();
        if(!email.equals("") && !contra.equals("")){
            try {
                Statement comando=conexion.conexion.createStatement();
                ResultSet registro=comando.executeQuery("SELECT * FROM usuarios WHERE email='"+email+"' AND contrasenia='"+contra+"'");
                if(registro.next()){
                    try{
                        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
                        Scene scene=new Scene(root,1000,600);
                        Main.stage.setScene(scene);
                        Main.stage.centerOnScreen();
                    }catch (IOException ex){
                        ex.printStackTrace();
                    }
                }
            } catch (SQLException e) {
                Alert alerta=new Alert(Alert.AlertType.ERROR,"Error: "+e);
                alerta.show();
            }
        }else{
            Alert alerta=new Alert(Alert.AlertType.WARNING,"Porfavor llene todos los datos");
            alerta.show();
        }
    }
    public void usuario(){
        try{
            Parent root = FXMLLoader.load(getClass().getResource("Usuario.fxml"));
            Scene scene=new Scene(root,310,400);
            Main.stage.setScene(scene);
            Main.stage.centerOnScreen();
        }catch (IOException ex){
            ex.printStackTrace();
        }
    }
}
