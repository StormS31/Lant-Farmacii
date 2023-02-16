package Controller;

import DAO.AngajatDAO;
import DAO.FarmacieDAO;
import Model.AdministratorPageModel;
import Model.Angajat;
import View.AdministratorPage;
import View.FormAngajat;

import javax.swing.*;
import java.awt.event.*;

public class ControllerAdministrator {
    private AdministratorPage view;
    private static int lastPositionClicked = 0;
    private AdministratorPageModel model;
    public ControllerAdministrator(JFrame viewMainPage)
    {
        this.view = new AdministratorPage();
        this.model = new AdministratorPageModel();
        this.view.getFrame().setVisible(true);
        view.getFrame().addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                viewMainPage.setVisible(true);
            }
        });
        this.view.getOperatiune().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                view.getTable().setModel(model.getChosenModel(view.getOperatiune().getSelectedItem()));
            }
        });
        view.getLogOff().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        view.getTable().addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                lastPositionClicked = view.getTable().getSelectedRow();
            }
        });
        view.getBtnExecuta().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(view.getOperatiune().getSelectedItem().toString().contains("Adauga angajat"))
                {
                    new ControllerFormAngajat(0, view.getTable());
                }
                else if(view.getOperatiune().getSelectedItem().toString().contains("Modifica angajat"))
                {
                    String temp = view.getTable().getValueAt(lastPositionClicked, 4).toString();
                    int idFarmacie = Integer.parseInt(temp);
                    AngajatDAO.modificaAngajat(
                            (String) view.getTable().getValueAt(lastPositionClicked, 1),                     //nume
                            idFarmacie,                      //idFarmacie
                            (String) view.getTable().getValueAt(lastPositionClicked, 2),                     //cnp
                            (String) view.getTable().getValueAt(lastPositionClicked,3),                      //email
                            (Integer)view.getTable().getValueAt(lastPositionClicked,0));                     //id
                }
                else if(view.getOperatiune().getSelectedItem().toString().contains("Sterge angajat"))
                {
                    int idAngajat = Integer.parseInt(JOptionPane.showInputDialog(view.getFrame(), "Introdu id-ul angajatului pe care doriti sa il sterdeti: "));
                    AngajatDAO.stergeAngajat(idAngajat);
                }
                else if(view.getOperatiune().getSelectedItem().toString().contains("Adauga farmacie"))
                {
                    new ControllerFormFarmacie();
                }
                else if(view.getOperatiune().getSelectedItem().toString().contains("Modifica farmacie"))
                {
                    String temp = view.getTable().getValueAt(lastPositionClicked, 0).toString();
                    int idFarmacie = Integer.parseInt(temp);
                    temp = view.getTable().getValueAt(lastPositionClicked, 2).toString();
                    int numar = Integer.parseInt(temp);
                    FarmacieDAO.modificaFarmacie(
                            idFarmacie,                                                                             //idFarmacie
                            (String) view.getTable().getValueAt(lastPositionClicked, 1),                     //oras
                            numar,                                                                                   //numar
                            (String) view.getTable().getValueAt(lastPositionClicked,3),                      //strada
                            (String) view.getTable().getValueAt(lastPositionClicked,4));                     //program
                    JOptionPane.showMessageDialog(view.getFrame(), "Farmacie modificata cu succes!");
                }
                else if (view.getOperatiune().getSelectedItem().toString().contains("Adauga medicament"))
                {
                    new ControllerFormMedicament(view.getFrame());
                }
            }
        });
    }

    public static int getLastPositionClicked() {
        return lastPositionClicked;
    }
}
