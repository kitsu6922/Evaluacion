package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.Statement;

public class Usuario_Controller {
    @FXML TextField txtNombre,txtAp,txtAm,txtCell,txtEmail,txtContra;
    Conexion conexion=new Conexion();
    public void accion(){
        String nombre=txtNombre.getText().trim(),
                ap=txtAp.getText().trim(),
                am=txtAm.getText().trim(),
                cell=txtCell.getText().trim(),
                email=txtEmail.getText().trim(),
                contra=txtContra.getText().trim();

        if(!nombre.equals("") && !ap.equals("") && !am.equals("") && ! cell.equals("") && !email.equals("") && !contra.equals("")){
            try{
                Statement comando = conexion.conexion.createStatement();
                comando.executeUpdate("INSERT INTO usuarios(nombre,ap,am,cell,email,contrasenia) VALUES ('"+nombre+"','"+ap+"','"+am+"','"+cell+"','"+email+"','"+contra+"')");
                Alert alerta=new Alert(Alert.AlertType.INFORMATION,"Se registro correctamente");
                alerta.show();
            }catch (SQLException e){
                Alert alerta=new Alert(Alert.AlertType.ERROR,"Error: "+e);
                alerta.show();
            }
        }else{
            Alert alerta=new Alert(Alert.AlertType.WARNING,"Porfavor llene todos los datos");
            alerta.show();
        }

    }
    public void login(){
        try{
            Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
            Scene scene=new Scene(root,200,300);
            Main.stage.setScene(scene);
            Main.stage.centerOnScreen();
        }catch (IOException ex){
            ex.printStackTrace();
        }
    }
}
