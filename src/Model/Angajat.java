package Model;

public class Angajat {
    private int idAngajat;
    private String nume;
    private String cnp;
    private int idFarmacie;
    private PermissionLevel permissionLevel;
    private String email;

    public Angajat(int idAngajat, String nume, String cnp, int idFarmacie, PermissionLevel permissionLevel, String email) {
        this.idAngajat = idAngajat;
        this.nume = nume;
        this.cnp = cnp;
        this.idFarmacie = idFarmacie;
        this.permissionLevel = permissionLevel;
        this.email = email;
    }

    public int getIdAngajat() {
        return idAngajat;
    }

    public void setIdAngajat(int idAngajat) {
        this.idAngajat = idAngajat;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getCnp() {
        return cnp;
    }

    public void setCnp(String cnp) {
        this.cnp = cnp;
    }

    public int getIdFarmacie() {
        return idFarmacie;
    }

    public void setIdFarmacie(int idFarmacie) {
        this.idFarmacie = idFarmacie;
    }

    public PermissionLevel getPermissionLevel() {
        return permissionLevel;
    }

    public void setPermissionLevel(PermissionLevel permissionLevel) {
        this.permissionLevel = permissionLevel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
