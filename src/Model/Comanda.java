package Model;

import java.sql.Timestamp;
import java.util.ArrayList;

public class Comanda {
    private int idComanda;
    private int idClient;
    private Timestamp timestamp;
    private float pretTotal;
    private ArrayList<Medicament> medicamente;

    public int getIdComanda() {
        return idComanda;
    }

    public void setIdComanda(int idComanda) {
        this.idComanda = idComanda;
    }

    public int getIdClient() {
        return idClient;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    public Timestamp getData() {
        return timestamp;
    }
    public float getTotal()
    {
        return pretTotal;
    }

    public Comanda(int idComanda, int idClient, Timestamp timestamp, float pretTotal) {
        this.idComanda = idComanda;
        this.idClient = idClient;
        this.pretTotal = pretTotal;
        this.timestamp = timestamp;
    }
}
