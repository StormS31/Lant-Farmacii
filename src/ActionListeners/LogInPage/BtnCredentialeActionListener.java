package ActionListeners.LogInPage;

import Controller.ControllerPharmacy;
import Controller.ControllerProductPage;
import DAO.AngajatDAO;
import DAO.ClientDAO;
import Model.Angajat;
import Model.Client;
import Util.PassEncryption;
import View.LogInPage;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BtnCredentialeActionListener implements ActionListener {
    private LogInPage logInPage;
    private JFrame viewMainPage;
    private JLabel lbluser;
    @Override
    public void actionPerformed(ActionEvent e) {
        String username = this.logInPage.getTxtUsername().getText();
        String password = PassEncryption.computePassword(logInPage.getPasswordField().getText());
        Client client = ClientDAO.getLogIn(username, password);
        Angajat angajat = AngajatDAO.getLogIn(username, password);
        if(client != null){
            ControllerPharmacy.setClient(client);
            JOptionPane.showMessageDialog(logInPage.getFrame(),
                    "[CLIENT] Conectare efectuată cu succes.");
            this.logInPage.getFrame().dispose();
            this.lbluser.setText("Utilizator: " + client.getNume());
            this.viewMainPage.setVisible(true);
            ControllerPharmacy.updateUserLabel();

        }
        else if(angajat != null)
        {
            ControllerPharmacy.setAngajat(angajat);
            JOptionPane.showMessageDialog(logInPage.getFrame(),
                    "[ANGAJAT] Conectare efectuată cu succes.");
            this.logInPage.getFrame().dispose();
            this.viewMainPage.setVisible(true);
            this.lbluser.setText("Admin: " + angajat.getNume());
            ControllerPharmacy.updateAdminLabel();
        }
        else JOptionPane.showMessageDialog(logInPage.getFrame(),
                "Email sau parolă invalide.");
        // System.out.println(username + " " + password);
    }
    public BtnCredentialeActionListener(LogInPage logInPage, JFrame viewMainPage, JLabel lblUser){
        this.logInPage = logInPage;
        this.viewMainPage = viewMainPage;
        this.lbluser = lblUser;
    }
}
