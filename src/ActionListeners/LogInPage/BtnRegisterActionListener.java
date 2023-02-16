package ActionListeners.LogInPage;

import ActionListeners.RegisterPage.BtnRegisterPageActionListener;
import Controller.ControllerRegisterPage;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BtnRegisterActionListener implements ActionListener {

    private ControllerRegisterPage controllerRegisterPage;
    private JFrame callerFrame;
    @Override
    public void actionPerformed(ActionEvent e) {
        this.controllerRegisterPage = new ControllerRegisterPage(callerFrame);
    }
    public BtnRegisterActionListener(JFrame callerFrame)
    {
        this.callerFrame = callerFrame;
    }
}
