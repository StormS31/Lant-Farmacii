package Controller;

import DAO.ComandaDAO;
import DAO.FarmacieDAO;
import Model.*;
import View.ComenziPage;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ControllerComenziPage {
    private ComenziPage comenziPage;
    public ControllerComenziPage(int mode)
    {
        comenziPage = new ComenziPage();
        comenziPage.getComenziPage().setVisible(true);
        ArrayList<Comanda> comenzi = new ArrayList<>();
        if(mode == 0)
            comenzi = ComandaDAO.getComenziById(ControllerPharmacy.getClient().getIdClient());
        else if (mode == 1)
        {
            comenzi = ComandaDAO.getComenzi();
        }
        for (Comanda comanda : comenzi) {
            String comboBoxInput = new String("ID: " + comanda.getIdComanda() + "; Data: " + comanda.getData() + "; suma: " + comanda.getTotal());
            comenziPage.getComboBox().addItem(comboBoxInput);
        }
        ArrayList<Comanda> finalComenzi = comenzi;
        comenziPage.getComboBox().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int id = 0;
                String input = comenziPage.getComboBox().getSelectedItem().toString();
                if(!input.equals("Selecteaza comanda")) {
                    String[] words = input.split(" ");
                    StringBuilder sb = new StringBuilder(words[1]);
                    sb.deleteCharAt(sb.length() - 1);
                    id = Integer.parseInt(sb.toString());

                    ArrayList<ComenziPageModel> medicamenteFromComanda = ComandaDAO.getMedicamenteFromComanda(id);
                    StringBuilder sb2 = new StringBuilder("");
                    sb2.append(" Id comanda: " + id + "\n");
                    sb2.append(" Id client: " + finalComenzi.get(0).getIdClient() + "\n");
                    sb2.append(" Data efectuarii comenzii: " + words[3] + "\n");
                    sb2.append(" Ora efectuarii comenzii: " + words[4].replaceAll(";", "") + "\n");
                    sb2.append(" Medicamente: " + "\n");
                    for (ComenziPageModel comenziPageModel : medicamenteFromComanda) {
                        sb2.append("        " + comenziPageModel.getDenumireMedicament() + ": " + comenziPageModel.getCantitateMedicament() + "x " +
                                comenziPageModel.getPretMedicament() + " = " + comenziPageModel.getCantitateMedicament()*comenziPageModel.getPretMedicament()+ "\n");
                    }
                    sb2.append("    Pret total: " + medicamenteFromComanda.get(0).getPretTotal() + "\n\n");
                    sb2.append(" Adresa de livrare: " + ControllerPharmacy.getClient().getAdresa());
                    comenziPage.getDetaliiComanda().setText(sb2.toString());
                }
            }
        });
    }
}
