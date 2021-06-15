package sample;

import javafx.beans.property.SimpleStringProperty;

public class TablaLocalizaciones {
    SimpleStringProperty id,nombre,ciudad,estado,direccion;

    public TablaLocalizaciones(String id, String nombre, String ciudad, String estado, String direccion) {
        this.id = new SimpleStringProperty(id);
        this.nombre = new SimpleStringProperty(nombre);
        this.ciudad = new SimpleStringProperty(ciudad);
        this.estado = new SimpleStringProperty(estado);
        this.direccion = new SimpleStringProperty(direccion);
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

    public String getCiudad() {
        return ciudad.get();
    }

    public SimpleStringProperty ciudadProperty() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad.set(ciudad);
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

    public String getDireccion() {
        return direccion.get();
    }

    public SimpleStringProperty direccionProperty() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion.set(direccion);
    }
}
