package sample;

import javafx.beans.property.SimpleStringProperty;

import java.nio.file.SecureDirectoryStream;

public class TablaPoblacion {
    SimpleStringProperty id,nombre,sexo,estado,ciudad,direccion,curp;

    public TablaPoblacion(String id, String nombre, String sexo, String estado, String ciudad, String direccion, String curp) {
        this.id = new SimpleStringProperty(id);
        this.nombre = new SimpleStringProperty(nombre);
        this.sexo = new SimpleStringProperty(sexo);
        this.estado = new SimpleStringProperty(estado);
        this.ciudad = new SimpleStringProperty(ciudad);
        this.direccion = new SimpleStringProperty(direccion);
        this.curp = new SimpleStringProperty(curp);
    }

    public String getId() {
        return id.get();
    }

    public SimpleStringProperty idProperty() {
        return id;
    }

    public void setId(String id) {
        this.id.set(id);
    }

    public String getNombre() {
        return nombre.get();
    }

    public SimpleStringProperty nombreProperty() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre.set(nombre);
    }

    public String getSexo() {
        return sexo.get();
    }

    public SimpleStringProperty sexoProperty() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo.set(sexo);
    }

    public String getEstado() {
        return estado.get();
    }

    public SimpleStringProperty estadoProperty() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado.set(estado);
    }

    public String getCiudad() {
        return ciudad.get();
    }

    public SimpleStringProperty ciudadProperty() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad.set(ciudad);
    }

    public String getDireccion() {
        return direccion.get();
    }

    public SimpleStringProperty direccionProperty() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion.set(direccion);
    }

    public String getCurp() {
        return curp.get();
    }

    public SimpleStringProperty curpProperty() {
        return curp;
    }

    public void setCurp(String curp) {
        this.curp.set(curp);
    }
}
