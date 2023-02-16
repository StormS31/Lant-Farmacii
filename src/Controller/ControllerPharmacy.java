package Controller;

import ActionListeners.MainPage.*;
import Model.Angajat;
import Model.Client;
import Model.PermissionLevel;
import View.MainPage;


public class ControllerPharmacy {

    private static Angajat currentAngajat;
    private static MainPage view;

    private static Client currentUser;
    public static Client getClient(){
        if(currentUser == null)
            currentUser = new Client(-1,null, null, null,null, PermissionLevel.GUEST,null);
        return currentUser;
    }
    public static void updateUserLabel()
    {
        view.getLblUser().setText("Utilizator: " + currentUser.getNume());
    }
    public static void updateAdminLabel(){view.getLblUser().setText("Admin: " + currentAngajat.getNume());}
    public static void setClient(Client client)
    {
        currentUser = client;
    }
    public static String  getLabel(){return view.getLblUser().getText();}

    public ControllerPharmacy() {
        view = new MainPage();
        getClient();
        currentAngajat = new Angajat(-1,null,null,-1,PermissionLevel.GUEST,null);
        view.getBtnAdministrare().addActionListener(new AdministrareActionListener(view.getFrame()));
        view.getBtnProduse().addActionListener(new BtnProduseActionListener(currentUser, view.getFrame()));
        view.getBtnFarmacie().addActionListener(new BtnFarmacieActionListener(view.getFrame()));
        view.getLoginBtn().addActionListener(new LogInActionListener(currentUser, view.getFrame(), view.getLblUser()));
        view.getBtnComenzi().addActionListener(new BtnComenziActionListener(view.getFrame()));
    }

    public static void setAngajat(Angajat angajat) {
        currentAngajat = angajat;
    }

    public void showView() {
        view.getFrame().setVisible(true);
    }

    public static void main(String[] args) {
            ControllerPharmacy controller = new ControllerPharmacy();
            controller.showView();
    }
    public static Angajat getCurrentAngajat()
    {
        return currentAngajat;
    }

}
