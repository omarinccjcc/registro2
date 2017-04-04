package pe.edu.upeu.registro.bean;

/**
 * Created by Alumnos on 04/04/2017.
 */

public class Person {

    private int id;
    private String name;
    private String lastNameF;
    private String lastNameM;
    private String site;
    private String address;

    public Person(){}

    public Person(int id, String name, String lastNameF, String lastNameM, String site, String address) {
        this.id = id;
        this.name = name;
        this.lastNameF = lastNameF;
        this.lastNameM = lastNameM;
        this.site = site;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastNameF() {
        return lastNameF;
    }

    public void setLastNameF(String lastNameF) {
        this.lastNameF = lastNameF;
    }

    public String getLastNameM() {
        return lastNameM;
    }

    public void setLastNameM(String lastNameM) {
        this.lastNameM = lastNameM;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return name + " " + lastNameF +" " + lastNameM ;
    }
}
