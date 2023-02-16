package ActionListeners.RegisterPage;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import DAO.ClientDAO;
import Model.PermissionLevel;
import Util.PassEncryption;
import View.RegisterPage;


import javax.swing.*;

public class BtnRegisterPageActionListener implements ActionListener {

    private RegisterPage view;
    private JFrame callerFrame;
    public BtnRegisterPageActionListener(RegisterPage view, JFrame callerFrame)
    {
        this.view = view;
        this.callerFrame = callerFrame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String password = PassEncryption.computePassword(view.getPwdParola().getText());
        String nume = view.getTxtNume().getText();
        String email = view.getTxtEmail().getText();
        String adresa = view.getTxtAdresa().getText();
        boolean success = ClientDAO.registerNewClient(nume, password, email, adresa, PermissionLevel.CLIENT);
        if(success)
        {
            JOptionPane.showMessageDialog(view.getFrame(),
                    "Înregistrare efectuată cu succes.");
            this.view.getFrame().dispose();
            this.callerFrame.setVisible(true);
        }
        else JOptionPane.showMessageDialog(view.getFrame(),
                "Eroare la înregistrare, email deja existent!");

    }
}
