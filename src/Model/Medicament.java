package Model;

public class Medicament {
    private int idMedicament;
    private String denumire;
    private int stoc;
    private String descriere;
    private String categorie;
    private String furnizor;
    private float pret;

    public int getIdMedicament() {
        return idMedicament;
    }

    public void setIdMedicament(int idMedicament) {
        this.idMedicament = idMedicament;
    }

    public String getDenumire() {
        return denumire;
    }

    public void setDenumire(String denumire) {
        this.denumire = denumire;
    }

    public int getStoc() {
        return stoc;
    }

    public void setStoc(int stoc) {
        this.stoc = stoc;
    }

    public String getDescriere() {
        return descriere;
    }

    public void setDescriere(String descriere) {
        this.descriere = descriere;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public String getFurnizor() {
        return furnizor;
    }

    public void setFurnizor(String furnizor) {
        this.furnizor = furnizor;
    }

    public float getPret() {
        return pret;
    }

    public void setPret(float pret) {
        this.pret = pret;
    }

    public Medicament(int idMedicament, String denumire, String descriere, String categorie, String furnizor, float pret, int stoc) {
        this.idMedicament = idMedicament;
        this.denumire = denumire;
        this.descriere = descriere;
        this.categorie = categorie;
        this.furnizor = furnizor;
        this.stoc = stoc;
        this.pret = pret;
    }
}
