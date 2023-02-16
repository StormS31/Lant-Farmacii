package Model;

import DAO.MedicamentDAO;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.util.ArrayList;
import java.util.List;

public class ProductPageModel {

    private static List<Medicament> medicamente;
    private static List<Integer> stoc;
    private void createTableModel(JTable table, List<Medicament> medicamente)
    {

        Object[][] data = new Object[medicamente.size()][4];
        int i = -1;
        for (Medicament medicament : this.medicamente) {
            ++i;
            data[i][0] = medicament.getIdMedicament();
            data[i][1] = medicament.getDenumire();
            data[i][2] = medicament.getCategorie();
        }
        table.setModel(new DefaultTableModel(data, new String[]{"ID",
                "Denumire produs",
                "Categorie"
        }){

            @Override
            public boolean isCellEditable(int row, int column) {
                //all cells false
                return false;
            }
        });
    }

    public ProductPageModel(JTable table){
        if (this.medicamente != null) {
            this.medicamente.clear();
        }
        this.medicamente = MedicamentDAO.getMedicamente();
        createTableModel(table,medicamente);
        comanda = new ArrayList<Medicament>();
        stoc = new ArrayList<Integer>();
    }

    public static List<Medicament> getMedicamente() {
        return medicamente;
    }

    public void setTableByCategorie(JTable table, String categorie)
    {
        if (this.medicamente != null) {
            this.medicamente.clear();
        }
        if(!categorie.equals("Selecteaza categoria"))
            this.medicamente = MedicamentDAO.getMedicamentByCategorie(categorie);
        else
        {
            this.medicamente = MedicamentDAO.getMedicamente();
        }
        createTableModel(table, medicamente);
    }

    public void setTableBySearch(JTable table, String search)
    {
        this.medicamente = MedicamentDAO.getMedicamente();
        if(!search.equals("")) {
            ArrayList<Medicament> tempMedicamente = new ArrayList<>();
            for (Medicament medicament : medicamente) {
                if (medicament.getDenumire().toLowerCase().contains(search.toLowerCase()))
                    tempMedicamente.add(medicament);
            }
            medicamente = tempMedicamente;
        }
        createTableModel(table, medicamente);
    }
    private static ArrayList<Medicament> comanda;
    public static ArrayList<Medicament> getComanda()
    {
        return comanda;
    }
    public static ArrayList<Integer> getStoc()
    {
        return (ArrayList<Integer>) stoc;
    }
    public static float computeTotalPrice()
    {
        float cost=0.0f;
        int i = -1;
        for (Medicament medicament : ProductPageModel.getComanda()) {
            ++i;
            cost+=medicament.getPret() * ProductPageModel.getStoc().get(i);
        }
        return cost;
    }
}
