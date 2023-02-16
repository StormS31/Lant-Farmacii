package Model;

import Controller.ControllerPharmacy;
import DAO.MedicamentDAO;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class AngajatPageModel {
    private ArrayList<Medicament> medicamente;
    public TableModel getChosenModel() {
        DefaultTableModel tableModel = new DefaultTableModel();
        getMedicamente();
            Object[][] data = new Object[medicamente.size()][5];
            int i = -1;
            for (Medicament med : this.medicamente) {
                ++i;
                data[i][0] = med.getIdMedicament();
                data[i][1] = med.getDenumire();
                data[i][2] = med.getStoc();
                data[i][3] = med.getFurnizor();
                data[i][4] = med.getPret();
            }
            tableModel = (new DefaultTableModel(data, new String[]{"ID Medicament",
                    "Denumire",
                    "Stoc farmacie",
                    "Furnizor",
                    "Pret"
            }){

                @Override
                public boolean isCellEditable(int row, int column) {
                    if(column == 0)
                        return false;
                    return true;
                }
            });
        return tableModel;
    }
    private void getMedicamente(){this.medicamente = MedicamentDAO.getMedicamenteFarmacieId(ControllerPharmacy.getCurrentAngajat().getIdFarmacie());}
}
