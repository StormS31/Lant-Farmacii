package ActionListeners.MainPage;

import Controller.ControllerLogInPage;
import Controller.ControllerPharmacy;
import Model.Client;
import Model.PermissionLevel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LogInActionListener implements ActionListener {
    private Client currentUser;
    private ControllerLogInPage controllerLogInPage;
    private JFrame calledFrame;
    private JLabel lblUser;
    public LogInActionListener(Client currentUser, JFrame calledFrame, JLabel lblUser)
    {
        this.currentUser = currentUser;
        this.calledFrame = calledFrame;
        this.lblUser = lblUser;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        currentUser = ControllerPharmacy.getClient();
        if(currentUser.getPermissionLevel() == PermissionLevel.GUEST && ControllerPharmacy.getCurrentAngajat().getPermissionLevel()==PermissionLevel.GUEST)
        {
            this.controllerLogInPage = new ControllerLogInPage(currentUser,calledFrame,lblUser);
            System.out.println("Avem: " + currentUser.getPermissionLevel().toString());
        }
        else System.exit(0);
    }
}
