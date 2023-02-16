package ActionListeners.MainPage;

import Controller.ControllerComenziPage;
import Controller.ControllerFormMedicament;
import Controller.ControllerPharmacy;
import DAO.ComandaDAO;
import Model.Comanda;
import Model.PermissionLevel;
import View.ComenziPage;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class BtnComenziActionListener implements ActionListener {
    private JFrame callerFrame;
    private ControllerComenziPage controllerComenziPage;
    public BtnComenziActionListener(JFrame frame){
        this.callerFrame = frame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(ControllerPharmacy.getClient().getPermissionLevel() == PermissionLevel.GUEST && ControllerPharmacy.getCurrentAngajat().getPermissionLevel() != PermissionLevel.GUEST)
        {
            this.controllerComenziPage = new ControllerComenziPage(1);
        }
        else if(ControllerPharmacy.getClient().getPermissionLevel() == PermissionLevel.CLIENT)
        {
            this.controllerComenziPage = new ControllerComenziPage(0);
        }
        else JOptionPane.showMessageDialog(callerFrame,
                "Logati-va pentru a efectua aceasta operatiune!");
    }
}
