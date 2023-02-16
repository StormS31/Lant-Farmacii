package Model;

public class ComenziPageModel {
    private float pretTotal;
    private int idMedicament;
    private String denumireMedicament;
    private int cantitateMedicament;
    private float pretMedicament;

    public ComenziPageModel(float pretTotal, int idMedicament, String denumireMedicament, int cantitateMedicament, float pretMedicament) {
        this.pretTotal = pretTotal;
        this.idMedicament = idMedicament;
        this.denumireMedicament = denumireMedicament;
        this.cantitateMedicament = cantitateMedicament;
        this.pretMedicament = pretMedicament;
    }

    public float getPretTotal() {
        return pretTotal;
    }

    public void setPretTotal(float pretTotal) {
        this.pretTotal = pretTotal;
    }

    public int getIdMedicament() {
        return idMedicament;
    }

    public void setIdMedicament(int idMedicament) {
        this.idMedicament = idMedicament;
    }

    public String getDenumireMedicament() {
        return denumireMedicament;
    }

    public void setDenumireMedicament(String denumireMedicament) {
        this.denumireMedicament = denumireMedicament;
    }

    public int getCantitateMedicament() {
        return cantitateMedicament;
    }

    public void setCantitateMedicament(int cantitateMedicament) {
        this.cantitateMedicament = cantitateMedicament;
    }

    public float getPretMedicament() {
        return pretMedicament;
    }

    public void setPretMedicament(int pretMedicament) {
        this.pretMedicament = pretMedicament;
    }
}
