package Model;

import DAO.AngajatDAO;
import DAO.FarmacieDAO;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.util.ArrayList;

public class AdministratorPageModel {
    private ArrayList<Farmacie> farmacii;
    private ArrayList<Angajat> angajati;
    public AdministratorPageModel(){}

    public TableModel getChosenModel(Object selectedItem) {
        DefaultTableModel tableModel = new DefaultTableModel();
        getFarmacii();
        if(selectedItem.toString().toLowerCase().contains("farmacie"))
        {
            Object[][] data = new Object[farmacii.size()][5];
            int i = -1;
            for (Farmacie farmacie : this.farmacii) {
                ++i;
                data[i][0] = farmacie.getIdFarmacie();
                data[i][1] = farmacie.getOras();
                data[i][2] = farmacie.getNumar();
                data[i][3] = farmacie.getStrada();
                data[i][4] = farmacie.getProgram();
            }
            tableModel = (new DefaultTableModel(data, new String[]{"ID Farmacie",
                    "Oras",
                    "Numar",
                    "Strada",
                    "Program"
            }){

                @Override
                public boolean isCellEditable(int row, int column) {
                    if(column == 0)
                        return false;
                    return true;
                }
            });
        }
        else if(selectedItem.toString().toLowerCase().contains("angajat"))
        {
            getAngajati();
            Object[][] data = new Object[angajati.size()][5];
            int i = -1;
            for (Angajat angajat : this.angajati) {
                ++i;
                data[i][0] = angajat.getIdAngajat();
                data[i][1] = angajat.getNume();
                data[i][2] = angajat.getCnp();
                data[i][3] = angajat.getEmail();
                data[i][4] = angajat.getIdFarmacie();
            }
            tableModel = (new DefaultTableModel(data, new String[]{"ID Angajat",
                    "Nume",
                    "CNP",
                    "Email",
                    "idFarmacie"
            }){

                @Override
                public boolean isCellEditable(int row, int column) {
                    if(column == 0)
                     return false;
                    return true;
                }
            });
        }
        return tableModel;
    }
    private void getFarmacii()
    {
        this.farmacii = FarmacieDAO.getFarmacii();
    }
    private void getAngajati()
    {
        this.angajati = AngajatDAO.getAngajati();
    }
}
