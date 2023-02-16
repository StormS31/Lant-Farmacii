package ActionListeners.MainPage;


import Controller.ControllerAdministrator;
import Controller.ControllerAngajatPage;
import Controller.ControllerPharmacy;
import Model.PermissionLevel;

import javax.naming.ldap.Control;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class AdministrareActionListener implements ActionListener {
    private JFrame viewMainPage;
    @Override
    public void actionPerformed(ActionEvent e) {
        if(ControllerPharmacy.getCurrentAngajat().getPermissionLevel() == PermissionLevel.ADMINISTRATOR)
        {
            new ControllerAdministrator(this.viewMainPage);
            viewMainPage.setVisible(false);
        }
        else if(ControllerPharmacy.getCurrentAngajat().getPermissionLevel() == PermissionLevel.ANGAJAT)
        {
            new ControllerAngajatPage(this.viewMainPage);
            viewMainPage.setVisible(false);
        }
        else JOptionPane.showMessageDialog(viewMainPage, "Nu sunteti administrator!");
    }
    public AdministrareActionListener(JFrame viewMainPage) {
        this.viewMainPage = viewMainPage;
    }
}
