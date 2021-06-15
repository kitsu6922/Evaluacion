package sample;

import javafx.scene.control.Alert;

import java.sql.*;

public class Conexion {
    private String usuario = "root";
    private String password = "";
    private String bd = "covid";
    private String servidor = "localhost";
    public Connection conexion;

    public Conexion() {
        try {
            conexion = DriverManager.getConnection("jdbc:mysql://" + servidor + ":3306/" + bd + "?useUnicode=true&useJDBCCompliantTimeZoneShift=useLegacyDatetimeCode&serverTimeZone=UTC", usuario, password);
            Alert alerta=new Alert(Alert.AlertType.INFORMATION,"Conexion Exitosa");
            alerta.show();

        } catch (Exception e) {
            Alert alerta=new Alert(Alert.AlertType.ERROR,"Conexion Exitosa");
            alerta.show();
        }
    }
}