package sample;

import javafx.beans.property.SimpleStringProperty;

public class TablaVacunas {
    SimpleStringProperty id,idp,idl1,f1,idl2,f2;

    public TablaVacunas(String id, String idp, String idl1, String f1, String idl2, String f2) {
        this.id = new SimpleStringProperty(id);
        this.idp = new SimpleStringProperty(idp);
        this.idl1 = new SimpleStringProperty(idl1);
        this.f1 = new SimpleStringProperty(f1);
        this.idl2 = new SimpleStringProperty(idl2);
        this.f2 = new SimpleStringProperty(f2);
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

    public String getIdp() {
        return idp.get();
    }

    public SimpleStringProperty idpProperty() {
        return idp;
    }

    public void setIdp(String idp) {
        this.idp.set(idp);
    }

    public String getIdl1() {
        return idl1.get();
    }

    public SimpleStringProperty idl1Property() {
        return idl1;
    }

    public void setIdl1(String idl1) {
        this.idl1.set(idl1);
    }

    public String getF1() {
        return f1.get();
    }

    public SimpleStringProperty f1Property() {
        return f1;
    }

    public void setF1(String f1) {
        this.f1.set(f1);
    }

    public String getIdl2() {
        return idl2.get();
    }

    public SimpleStringProperty idl2Property() {
        return idl2;
    }

    public void setIdl2(String idl2) {
        this.idl2.set(idl2);
    }

    public String getF2() {
        return f2.get();
    }

    public SimpleStringProperty f2Property() {
        return f2;
    }

    public void setF2(String f2) {
        this.f2.set(f2);
    }
}
