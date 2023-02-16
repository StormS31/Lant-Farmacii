package Model;

import java.util.ArrayList;

public class Client {
    private int idClient;
    private String nume;
    private String adresa;
    private String email;
    private ArrayList<Comanda> comenzi;
    private PermissionLevel permissionLevel;
    private String password;

    public Client(int idClient, String nume, String adresa, String email, ArrayList<Comanda> comenzi, PermissionLevel permissionLevel, String password) {
        this.idClient = idClient;
        this.nume = nume;
        this.adresa = adresa;
        this.email = email;
        this.comenzi = comenzi;
        this.permissionLevel = permissionLevel;
        this.password = password;
    }

    public Client() {

    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPermissionLevel(PermissionLevel permissionLevel) {
        this.permissionLevel = permissionLevel;
    }

    public PermissionLevel getPermissionLevel() {
        return permissionLevel;
    }

    public int getIdClient() {
        return idClient;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public ArrayList<Comanda> getComenzi() {
        return comenzi;
    }

    public void setComenzi(ArrayList<Comanda> comenzi) {
        this.comenzi = comenzi;
    }

}
