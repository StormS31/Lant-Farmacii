package Model;

import java.util.ArrayList;

public class Farmacie {
    private int idFarmacie;
    private String oras;
    private String strada;
    private int numar;
    private ArrayList<Angajat> angajati;
    private String program;
    private ArrayList<Medicament> medicamente;

    public int getIdFarmacie() {
        return idFarmacie;
    }

    public void setIdFarmacie(int idFarmacie) {
        this.idFarmacie = idFarmacie;
    }

    public String getOras() {
        return oras;
    }

    public void setOras(String oras) {
        this.oras = oras;
    }

    public String getStrada() {
        return strada;
    }

    public void setStrada(String strada) {
        this.strada = strada;
    }

    public int getNumar() {
        return numar;
    }

    public void setNumar(int numar) {
        this.numar = numar;
    }

    public ArrayList<Angajat> getAngajati() {
        return angajati;
    }

    public void setAngajati(ArrayList<Angajat> angajati) {
        this.angajati = angajati;
    }

    public String getProgram() {
        return program;
    }

    public void setProgram(String program) {
        this.program = program;
    }

    public ArrayList<Medicament> getMedicamente() {
        return medicamente;
    }

    public void setMedicamente(ArrayList<Medicament> medicamente) {
        this.medicamente = medicamente;
    }

    public Farmacie(int idFarmacie, String oras, String strada, int numar, ArrayList<Angajat> angajati, String program, ArrayList<Medicament> medicamente) {
        this.idFarmacie = idFarmacie;
        this.oras = oras;
        this.strada = strada;
        this.numar = numar;
        this.angajati = angajati;
        this.program = program;
        this.medicamente = medicamente;
    }
}
