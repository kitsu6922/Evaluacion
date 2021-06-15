package sample;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Controller {
    @FXML AnchorPane vacunasAp,localizacionesAp,poblacionAp;
    Conexion conexion= new Conexion();
    Date fecha=new Date();
    ////////////////////////////////////////////////
    @FXML TextField txtNombreVP,txtNombreVL,txtCiudadV,txtSexoV;
    @FXML ComboBox cbPersona,cbLocalizacion;
    @FXML TableView tablaVacunas;
    @FXML TableColumn tcvId,tcvIDP,tcvIDL1,tcvIDL2,tcvF1,tcvF2;
    ObservableList<TablaVacunas> registrosVacunas=FXCollections.observableArrayList();
    ////////////////////////////////////////////////
    @FXML TextField txtId,txtNombre,txtCiudad,txtDireccion,txtCurp;
    @FXML RadioButton rbMasculino,rbFemenino;
    @FXML ComboBox cbEstado;
    @FXML TableView tablaPersonas;
    @FXML TableColumn tcId,tcNombre,tcEstado,tcCiudad,tcSexo,tcDireccion,tcCurp;
    ObservableList<TablaPoblacion> registrosPoblacion= FXCollections.observableArrayList();
    ////////////////////////////////////////////////
    @FXML TextField txtIdL,txtNombreL,txtCiudadL,txtDireccionL;
    @FXML ComboBox cbEstadoL;
    @FXML TableView tablaLocalizaciones;
    @FXML TableColumn tclId,tclNombre,tclEstado,tclCiudad,tclDireccion;
    ObservableList<TablaLocalizaciones> registrosLocalizaciones = FXCollections.observableArrayList();




    @FXML public void initialize(){

        vacunasAp.setVisible(true);
        poblacionAp.setVisible(false);
        localizacionesAp.setVisible(false);
        ////////////////////////////////////////////////
        tcvId.setCellValueFactory(new PropertyValueFactory<TablaVacunas,String>("id"));
        tcvIDP.setCellValueFactory(new PropertyValueFactory<TablaVacunas,String>("idp"));
        tcvIDL1.setCellValueFactory(new PropertyValueFactory<TablaVacunas,String>("idl1"));
        tcvF1.setCellValueFactory(new PropertyValueFactory<TablaVacunas,String>("f1"));
        tcvIDL2.setCellValueFactory(new PropertyValueFactory<TablaVacunas,String>("idl2"));
        tcvF2.setCellValueFactory(new PropertyValueFactory<TablaVacunas,String>("f2"));
        tablaVacunas.setItems(registrosVacunas);
        actualizarVacunas();

        cbPersona.valueProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue observable, Object oldValue, Object newValue) {
                try{
                    Statement comando=conexion.conexion.createStatement();
                    ResultSet registro=comando.executeQuery("SELECT * FROM poblacion WHERE id="+newValue.toString());
                    if(registro.next()){
                        txtNombreVP.setText(registro.getString("nombre"));
                        txtSexoV.setText(registro.getString("sexo"));
                    }
                }catch (SQLException e){
                    Alert alerta=new Alert(Alert.AlertType.ERROR,"Error: "+e);
                    alerta.show();
                }
            }
        });
        cbLocalizacion.valueProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue observable, Object oldValue, Object newValue) {
                try{
                    Statement comando=conexion.conexion.createStatement();
                    ResultSet registro=comando.executeQuery("SELECT * FROM localizaciones WHERE id="+newValue.toString());
                    if(registro.next()){
                        txtNombreVL.setText(registro.getString("nombre"));
                        txtCiudadV.setText(registro.getString("ciudad"));
                    }
                }catch (SQLException e){
                    Alert alerta=new Alert(Alert.AlertType.ERROR,"Error: "+e);
                    alerta.show();
                }
            }
        });
        ////////////////////////////////////////////////
        cbEstadoL.getItems().addAll("Aguascalientes","Baja California","Baja California Sur","Campeche","Chiapas","Chihuahua","Ciudad de México","Coahuila de Zaragoza","Colima","Durango","Guanajuato","Guerrero","Hidalgo","Jalisco","Estado de México","Michoacán de Ocampo","Morelos","Nayarit","Nuevo León","Oaxaca","Puebla","Querétaro","Quintana Roo","San Luis Potosí","Sinaloa","Sonora","Tabasco","Tamaulipas","Tlaxcala","Veracruz","Yucatán","Zacatecas");
        cbEstadoL.setValue("Aguascalientes");
        tclId.setCellValueFactory(new PropertyValueFactory<TablaLocalizaciones,String>("id"));
        tclNombre.setCellValueFactory(new PropertyValueFactory<TablaLocalizaciones,String>("nombre"));
        tclEstado.setCellValueFactory(new PropertyValueFactory<TablaLocalizaciones,String>("estado"));
        tclCiudad.setCellValueFactory(new PropertyValueFactory<TablaLocalizaciones,String>("ciudad"));
        tclDireccion.setCellValueFactory(new PropertyValueFactory<TablaLocalizaciones,String>("direccion"));
        tablaLocalizaciones.setItems(registrosLocalizaciones);
        ///////////////////////////////////////////////////
        cbEstado.getItems().addAll("Aguascalientes","Baja California","Baja California Sur","Campeche","Chiapas","Chihuahua","Ciudad de México","Coahuila de Zaragoza","Colima","Durango","Guanajuato","Guerrero","Hidalgo","Jalisco","Estado de México","Michoacán de Ocampo","Morelos","Nayarit","Nuevo León","Oaxaca","Puebla","Querétaro","Quintana Roo","San Luis Potosí","Sinaloa","Sonora","Tabasco","Tamaulipas","Tlaxcala","Veracruz","Yucatán","Zacatecas");
        cbEstado.setValue("Aguascalientes");
        tcId.setCellValueFactory(new PropertyValueFactory<TablaPoblacion,String>("id"));
        tcNombre.setCellValueFactory(new PropertyValueFactory<TablaPoblacion,String>("nombre"));
        tcSexo.setCellValueFactory(new PropertyValueFactory<TablaPoblacion,String>("sexo"));
        tcEstado.setCellValueFactory(new PropertyValueFactory<TablaPoblacion,String>("estado"));
        tcCiudad.setCellValueFactory(new PropertyValueFactory<TablaPoblacion,String>("ciudad"));
        tcDireccion.setCellValueFactory(new PropertyValueFactory<TablaPoblacion,String>("direccion"));
        tcCurp.setCellValueFactory(new PropertyValueFactory<TablaPoblacion,String>("curp"));
        tablaPersonas.setItems(registrosPoblacion);
    }
    public void vap(){
        vacunasAp.setVisible(true);
        poblacionAp.setVisible(false);
        localizacionesAp.setVisible(false);
        actualizarVacunas();
    }
    public void agregarVacunas(){
        String id_persona=cbPersona.getSelectionModel().getSelectedItem().toString();
        String id_localizacion=cbLocalizacion.getSelectionModel().getSelectedItem().toString();

        try{
            Statement comando=conexion.conexion.createStatement();
            ResultSet registro=comando.executeQuery("SELECT * FROM vacunas WHERE id_persona="+id_persona);
            if (registro.next()){
                if(registro.getObject("id_localizacion2")==null && registro.getObject("fecha2")==null){
                    SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yyyy");
                    comando.executeUpdate("UPDATE vacunas SET id_localizacion2=" + id_localizacion + ",  fecha2='" + sdf.format(fecha) + "' WHERE id_persona=" + id_persona);
                }else{
                    Alert alerta=new Alert(Alert.AlertType.INFORMATION,"Ya cumplio con las dos vacunas contra COVID-19");
                    alerta.show();
                }
            }else{
                SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yyyy");
                comando.executeUpdate("INSERT INTO vacunas(id_persona,id_localizacion1,fecha1) VALUES ("+id_persona+","+id_localizacion+",'"+sdf.format(fecha)+"')");
            }
        }catch (SQLException e){
            Alert alerta=new Alert(Alert.AlertType.ERROR,"Error: "+e);
            alerta.show();
        }
        actualizarVacunas();

    }
    public void actualizarVacunas(){
        registrosVacunas.clear();
        cbPersona.getItems().clear();
        cbLocalizacion.getItems().clear();
        try {
            Statement comando=conexion.conexion.createStatement();
            ResultSet registro=comando.executeQuery("SELECT * FROM vacunas");
            while(registro.next()){
                registrosVacunas.add(new TablaVacunas(
                        registro.getString("id"),
                        registro.getString("id_persona"),
                        registro.getString("id_localizacion1"),
                        registro.getString("fecha1"),
                        registro.getString("id_localizacion2"),
                        registro.getString("fecha2")));
            }
            registro=comando.executeQuery("SELECT * FROM localizaciones");
            while(registro.next()){
                cbLocalizacion.getItems().add(registro.getString("id"));
            }
            registro=comando.executeQuery("SELECT * FROM poblacion");
            while(registro.next()){
                cbPersona.getItems().add(registro.getString("id"));
            }
        } catch (SQLException e) {
            Alert alerta=new Alert(Alert.AlertType.ERROR,"Error: "+e);
            alerta.show();
        }
    }
    public void clickTablaVacunas(){

    }
    public void lap(){
        vacunasAp.setVisible(false);
        poblacionAp.setVisible(false);
        localizacionesAp.setVisible(true);
        actualizarLocalizaciones();
    }
    public void agregarLocalizaciones(){
        Statement comando= null;
        String nombre=txtNombreL.getText().trim(),
                estado=cbEstadoL.getSelectionModel().getSelectedItem().toString(),
                ciudad=txtCiudadL.getText().trim(),
                direccion=txtDireccionL.getText().trim();
        if(!nombre.equals("") && !ciudad.equals("") && !direccion.equals("") ){
            try {
                comando = conexion.conexion.createStatement();
                comando.executeUpdate("INSERT INTO localizaciones(nombre,estado,ciudad,direccion) VALUES ('"+nombre+"','"+estado+"','"+ciudad+"','"+direccion+"')");
                Alert alerta=new Alert(Alert.AlertType.INFORMATION,"Se registro correctamente");
                alerta.show();
            } catch (SQLException e) {
                Alert alerta=new Alert(Alert.AlertType.ERROR,"Error: "+e);
                alerta.show();
            }
            vaciarLocalizaciones();
        }else{
            Alert alerta=new Alert(Alert.AlertType.WARNING,"Porfavor llene todos los datos");
            alerta.show();
        }
    }
    public void guardarLocalizaciones(){
        String  id=txtIdL.getText().trim(),
                nombre=txtNombreL.getText().trim(),
                estado=cbEstadoL.getSelectionModel().getSelectedItem().toString(),
                ciudad=txtCiudadL.getText().trim(),
                direccion=txtDireccionL.getText().trim();
        if(!nombre.equals("") && !ciudad.equals("") && !direccion.equals("") && !id.equals("")) {
            try {
                Statement comando = conexion.conexion.createStatement();
                int cant = comando.executeUpdate("UPDATE localizaciones SET nombre='" + nombre + "',  estado='" + estado + "', ciudad='" + ciudad + "', direccion='" + direccion + "' WHERE id=" + id);
                if (cant == 1) {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION, "Se modifico correctamente el registro " + id);
                    alert.show();
                } else {
                    Alert alert = new Alert(Alert.AlertType.WARNING, "No se encontro ningun registro con el id: " + id);
                    alert.show();
                }
                vaciarLocalizaciones();
            } catch (SQLException e) {
                Alert alert = new Alert(Alert.AlertType.ERROR, "Error: " + e);
                alert.show();
            }
        }

    }
    public void borrarLocalizaciones(){
        String id=txtIdL.getText().trim();
        if(!id.equals("")){
            try{
                Statement comando=conexion.conexion.createStatement();
                int cant= comando.executeUpdate("DELETE FROM localizaciones WHERE id="+id);
                if(cant==1){
                    Alert alerta=new Alert(Alert.AlertType.INFORMATION,"Se elimino el registro con el id: "+id);
                    alerta.show();
                }else if(cant==0){
                    Alert alerta=new Alert(Alert.AlertType.WARNING,"No se ecnontro ningun registro con el id: "+id);
                    alerta.show();
                }
                actualizarPoblacion();
            }catch (SQLException e){
                Alert alerta= new Alert(Alert.AlertType.ERROR,"Error: "+e);
                alerta.show();
            }
        }else{
            Alert alerta=new Alert(Alert.AlertType.WARNING,"Porfavor Ingrese el ID que desea eliminar");
            alerta.show();
        }
        vaciarLocalizaciones();
    }
    public void actualizarLocalizaciones(){
        registrosLocalizaciones.clear();
        try {
            Statement comando=conexion.conexion.createStatement();
            ResultSet registro=comando.executeQuery("SELECT * FROM localizaciones");
            while(registro.next()){
                registrosLocalizaciones.add(new TablaLocalizaciones(
                        registro.getString("id"),
                        registro.getString("nombre"),
                        registro.getString("ciudad"),
                        registro.getString("estado"),
                        registro.getString("direccion")));
            }
        } catch (SQLException e) {
            Alert alerta=new Alert(Alert.AlertType.ERROR,"Error: "+e);
            alerta.show();
        }

    }
    public void vaciarLocalizaciones(){
        txtNombreL.setText("");
        txtDireccionL.setText("");
        txtCiudadL.setText("");
        txtIdL.setText("");
        cbEstadoL.setValue("Aguascalientes");
        actualizarLocalizaciones();
    }
    public void clickTablaLocalizaciones(){
        try {
            int indice = tablaLocalizaciones.getSelectionModel().getSelectedIndex();
            txtNombreL.setText(registrosLocalizaciones.get(indice).getNombre());
            txtDireccionL.setText(registrosLocalizaciones.get(indice).getDireccion());
            txtCiudadL.setText(registrosLocalizaciones.get(indice).getCiudad());
            txtIdL.setText(registrosLocalizaciones.get(indice).getId());
            cbEstadoL.setValue(registrosLocalizaciones.get(indice).getEstado());
        }catch (IndexOutOfBoundsException ex){
            Alert alerta=new Alert(Alert.AlertType.ERROR,"No se selecciono ningun registro");
            alerta.show();
        }

    }
    public void pap(){
        vacunasAp.setVisible(false);
        poblacionAp.setVisible(true);
        localizacionesAp.setVisible(false);
        actualizarPoblacion();
    }
    public void agregarPoblacion(){
        Statement comando= null;
        String nombre=txtNombre.getText().trim(),
                sexo="",
                estado=cbEstado.getSelectionModel().getSelectedItem().toString(),
                ciudad=txtCiudad.getText().trim(),
                direccion=txtDireccion.getText().trim(),
                curp=txtCurp.getText().trim();
        if(rbFemenino.isSelected()){
            sexo="Femenino";
        }else if(rbMasculino.isSelected()){
            sexo="Masculino";
        }
        if(!nombre.equals("") && !ciudad.equals("") && !direccion.equals("") && !curp.equals("")){
            try {
                comando = conexion.conexion.createStatement();
                comando.executeUpdate("INSERT INTO poblacion(nombre,sexo,estado,ciudad,direccion,curp) VALUES ('"+nombre+"','"+sexo+"','"+estado+"','"+ciudad+"','"+direccion+"','"+curp+"')");
                Alert alerta=new Alert(Alert.AlertType.INFORMATION,"Se registro correctamente");
                alerta.show();
            } catch (SQLException e) {
                Alert alerta=new Alert(Alert.AlertType.ERROR,"Error: "+e);
                alerta.show();
            }
            actualizarPoblacion();
            txtNombre.setText("");
            txtCiudad.setText("");
            txtCurp.setText("");
            txtDireccion.setText("");
            txtId.setText("");
        }else{
            Alert alerta=new Alert(Alert.AlertType.WARNING,"Porfavor llene todos los datos");
            alerta.show();
        }
    }
    public void guardarPoblacion(){
        String  id=txtId.getText().trim(),
                nombre=txtNombre.getText().trim(),
                sexo="",
                estado=cbEstado.getSelectionModel().getSelectedItem().toString(),
                ciudad=txtCiudad.getText().trim(),
                direccion=txtDireccion.getText().trim(),
                curp=txtCurp.getText().trim();
        if(rbFemenino.isSelected()){
            sexo="Femenino";
        }else if(rbMasculino.isSelected()){
            sexo="Masculino";
        }
        if(!nombre.equals("") && !ciudad.equals("") && !direccion.equals("") && !curp.equals("") && !id.equals("")) {
            try {
                Statement comando = conexion.conexion.createStatement();
                int cant = comando.executeUpdate("UPDATE poblacion SET nombre='" + nombre + "', sexo='" + sexo + "', estado='" + estado + "', ciudad='" + ciudad + "', direccion='" + direccion + "', curp='" + curp + "' WHERE id=" + id);
                if (cant == 1) {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION, "Se modifico correctamente el registro " + id);
                    alert.show();
                } else {
                    Alert alert = new Alert(Alert.AlertType.WARNING, "No se encontro ningun registro con el id: " + id);
                    alert.show();
                }
                actualizarPoblacion();
            } catch (SQLException e) {
                Alert alert = new Alert(Alert.AlertType.ERROR, "Error: " + e);
                alert.show();
            }
            txtNombre.setText("");
            txtCiudad.setText("");
            txtCurp.setText("");
            txtDireccion.setText("");
            txtId.setText("");
        }else{
            Alert alerta=new Alert(Alert.AlertType.WARNING,"Porfavor llene todos los datos");
            alerta.show();
        }
    }
    public void borrarPoblacion(){
        String id=txtId.getText().trim();
        if(!id.equals("")){
            try{
                Statement comando=conexion.conexion.createStatement();
                int cant= comando.executeUpdate("DELETE FROM poblacion WHERE id="+id);
                if(cant==1){
                    Alert alerta=new Alert(Alert.AlertType.INFORMATION,"Se elimino el registro con el id: "+id);
                    alerta.show();
                }else if(cant==0){
                    Alert alerta=new Alert(Alert.AlertType.WARNING,"No se ecnontro ningun registro con el id: "+id);
                    alerta.show();
                }
                actualizarPoblacion();
            }catch (SQLException e){
                Alert alerta= new Alert(Alert.AlertType.ERROR,"Error: "+e);
                alerta.show();
            }
        }else{
            Alert alerta=new Alert(Alert.AlertType.WARNING,"Porfavor Ingrese el ID que desea eliminar");
            alerta.show();
        }

    }
    public void actualizarPoblacion(){
        registrosPoblacion.clear();
        try {
            Statement comando=conexion.conexion.createStatement();
            ResultSet registro=comando.executeQuery("SELECT * FROM poblacion");
            while(registro.next()){
                registrosPoblacion.add(new TablaPoblacion(
                        registro.getString("id"),
                        registro.getString("nombre"),
                        registro.getString("sexo"),
                        registro.getString("estado"),
                        registro.getString("ciudad"),
                        registro.getString("direccion"),
                        registro.getString("curp")));
            }
        } catch (SQLException e) {
            Alert alerta=new Alert(Alert.AlertType.ERROR,"Error: "+e);
            alerta.show();
        }
    }
    public void masculino(){
        rbMasculino.setSelected(true);
        rbFemenino.setSelected(false);
    }
    public void femenino(){
        rbMasculino.setSelected(false);
        rbFemenino.setSelected(true);
    }

    public void clickTablaPoblacion(){
        try{
            int indice=tablaPersonas.getSelectionModel().getSelectedIndex();
            txtNombre.setText(registrosPoblacion.get(indice).getNombre());
            txtDireccion.setText(registrosPoblacion.get(indice).getDireccion());
            txtCurp.setText(registrosPoblacion.get(indice).getCurp());
            txtCiudad.setText(registrosPoblacion.get(indice).getCiudad());
            txtId.setText(registrosPoblacion.get(indice).getId());
            cbEstado.setValue(registrosPoblacion.get(indice).getEstado());

            String sexo=registrosPoblacion.get(indice).getSexo();
            if (sexo.equals("Masculino")){
                masculino();
            }else if(sexo.equals("Femenino")){
                femenino();
            }
        }catch (IndexOutOfBoundsException ex){
            Alert alerta=new Alert(Alert.AlertType.ERROR,"No se selecciono ningun registro");
            alerta.show();
        }

    }
    public void vaciarPoblacion(){
        txtNombre.setText("");
        txtCiudad.setText("");
        txtCurp.setText("");
        txtDireccion.setText("");
        txtId.setText("");
        cbEstado.setValue("Aguascalientes");
        masculino();
    }

}
