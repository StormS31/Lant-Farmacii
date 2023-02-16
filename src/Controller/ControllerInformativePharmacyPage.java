package Controller;

import DAO.FarmacieDAO;
import Model.Farmacie;
import View.PharmacyPage;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ControllerInformativePharmacyPage {
    private PharmacyPage view;
    public void showView() {
        this.view.getFrame().setVisible(true);
    }
    public ControllerInformativePharmacyPage(JFrame viewMainPage)
    {
        this.view = new PharmacyPage();
        viewMainPage.setVisible(false);
        showView();
        view.getFrame().addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                viewMainPage.setVisible(true);
            }
        });
        for (Farmacie farmacie : FarmacieDAO.getFarmacii()) {
            view.getComboBox().addItem("ID: " + farmacie.getIdFarmacie() + "; oras: " + farmacie.getOras());
        }
        view.getComboBox().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input = view.getComboBox().getSelectedItem().toString();
                if(!input.equals("Selecteaza farmacia")){
                    String[] words = input.split(" ");
                    StringBuilder sb = new StringBuilder(words[1]);
                    sb.deleteCharAt(sb.length()-1);
                    input = sb.toString();
                    Farmacie far = FarmacieDAO.getFarmacieById(Integer.parseInt(input));
                    view.update(far);
                }
            }
        });
    }
}