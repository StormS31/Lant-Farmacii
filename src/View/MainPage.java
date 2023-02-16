package View;

import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.Font;
import java.awt.Dimension;

public class MainPage {

    private JFrame frmFarmaciaIonas;

    private JPanel panel;
    private JPanel panel_1;
    private JPanel panel_2;

    private JButton loginBtn;
    private JButton btnProduse;
    private JButton btnComenzi;
    private JButton btnFarmacie;
    private JButton btnAdministrare;

    private JTextField txtProduse;
    private JTextField txtFarmacii;
    private JTextField txtGestiuneAdministrator;
    private JTextField txtComenzi;
    private JTextField txtFarmaciaIonas;

    private JLabel lblUser;

    public JButton getLoginBtn() {
        return loginBtn;
    }

    public JButton getBtnProduse() {
        return btnProduse;
    }

    public JButton getBtnComenzi() {
        return btnComenzi;
    }

    public JButton getBtnAdministrare() {
        return btnAdministrare;
    }

    public JFrame getFrame() {
        return this.frmFarmaciaIonas;
    }

    public JButton getBtnFarmacie(){return this.btnFarmacie;}

    public JLabel getLblUser() {
        return lblUser;
    }

    /**
     * Create the application.
     */
    public MainPage() {
        initializePanelsAndFrame();
        initializeLogInButton();
        initializeLabelsAndTextFields();
        initializeBtnProduse();
        initializeBtnFarmacie();
        initializeBtnComenzi();
        initiazileBtnAdministrare();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initializeLogInButton()
    {
        loginBtn = new JButton("");
        loginBtn.setFocusPainted(false);
        loginBtn.setFocusTraversalKeysEnabled(false);
        loginBtn.setFocusable(false);
        loginBtn.setIcon(new ImageIcon(MainPage.class.getResource("/images/log-in.png")));
        loginBtn.setActionCommand("");
        loginBtn.setBorder(null);
        loginBtn.setFont(new Font("Mongolian Baiti", Font.BOLD, 17));
        loginBtn.setForeground(new Color(255, 255, 255));
        loginBtn.setBackground(new Color(255, 255, 255));
        loginBtn.setBounds(945, 25, 51, 51);
        panel_1.add(loginBtn);
    }

    private void initializeBtnProduse()
    {
        btnProduse = new JButton("");
        btnProduse.setFocusTraversalKeysEnabled(false);
        btnProduse.setFocusPainted(false);
        btnProduse.setBackground(new Color(102, 204, 102));
        btnProduse.setIcon(new ImageIcon(MainPage.class.getResource("/images/first-aid-kit_250x250.png")));
        btnProduse.setBorder(null);
        btnProduse.setBounds(20, 13, 260, 250);
        panel_2.add(btnProduse);
    }

    private void initiazileBtnAdministrare()
    {
        btnAdministrare = new JButton("");
        btnAdministrare.setIcon(new ImageIcon(MainPage.class.getResource("/images/management_250x250.png")));
        btnAdministrare.setFocusTraversalKeysEnabled(false);
        btnAdministrare.setFocusPainted(false);
        btnAdministrare.setBorder(null);
        btnAdministrare.setBackground(new Color(102, 204, 102));
        btnAdministrare.setBounds(372, 298, 260, 250);
        panel_2.add(btnAdministrare);
    }

    private void initializeBtnFarmacie()
    {

        btnFarmacie = new JButton("");
        btnFarmacie.setIcon(new ImageIcon(MainPage.class.getResource("/images/pharmacy_1_250x250.png")));
        btnFarmacie.setFocusTraversalKeysEnabled(false);
        btnFarmacie.setFocusPainted(false);
        btnFarmacie.setBorder(null);
        btnFarmacie.setBackground(new Color(102, 204, 102));
        btnFarmacie.setBounds(372, 13, 260, 250);
        panel_2.add(btnFarmacie);
    }

    private void initializeBtnComenzi()
    {
        btnComenzi = new JButton("");
        btnComenzi.setIcon(new ImageIcon(MainPage.class.getResource("/images/shopping-list_250x250.png")));
        btnComenzi.setFocusTraversalKeysEnabled(false);
        btnComenzi.setFocusPainted(false);
        btnComenzi.setBorder(null);
        btnComenzi.setBackground(new Color(102, 204, 102));
        btnComenzi.setBounds(725, 13, 260, 250);
        panel_2.add(btnComenzi);
    }

    private void initializePanelsAndFrame()
    {
        frmFarmaciaIonas = new JFrame();
        frmFarmaciaIonas.setResizable(false);
        frmFarmaciaIonas.setIconImage(Toolkit.getDefaultToolkit().getImage(MainPage.class.getResource("/images/pharmacy_80x80.png")));
        frmFarmaciaIonas.setTitle("Farmacia Jasmine");
        frmFarmaciaIonas.setBounds(100, 100, 1024, 720);
        frmFarmaciaIonas.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        frmFarmaciaIonas.setLocation(dim.width/2-frmFarmaciaIonas.getSize().width/2, dim.height/2-frmFarmaciaIonas.getSize().height/2);

        panel = new JPanel();
        panel.setBackground(Color.WHITE);
        frmFarmaciaIonas.getContentPane().add(panel, BorderLayout.CENTER);
        panel.setLayout(null);

        panel_1 = new JPanel();
        panel_1.setBounds(0, 0, 1008, 100);
        panel_1.setBackground(new Color(102, 204, 102));
        panel.add(panel_1);
        panel_1.setLayout(null);

        panel_2 = new JPanel();
        panel_2.setBackground(Color.WHITE);
        panel_2.setBounds(0, 99, 1008, 582);
        panel.add(panel_2);
        panel_2.setLayout(null);
    }

    private void initializeLabelsAndTextFields() {



        JLabel logo_farmacie = new JLabel("");
        logo_farmacie.setIcon(new ImageIcon(MainPage.class.getResource("/images/pharmacy_80x80.png")));
        logo_farmacie.setBounds(24, 11, 80, 80);
        panel_1.add(logo_farmacie);

        JLabel whiteCircleBg = new JLabel("");
        whiteCircleBg.setIcon(new ImageIcon(MainPage.class.getResource("/images/white_circle_92.png")));
        whiteCircleBg.setBounds(924, 9, 82, 82);
        panel_1.add(whiteCircleBg);

        txtFarmaciaIonas = new JTextField();
        txtFarmaciaIonas.setEditable(false);
        txtFarmaciaIonas.setFocusable(false);
        txtFarmaciaIonas.setForeground(Color.WHITE);
        txtFarmaciaIonas.setBackground(new Color(102, 204, 102));
        txtFarmaciaIonas.setBorder(null);
        txtFarmaciaIonas.setFont(new Font("Mongolian Baiti", Font.ITALIC, 32));
        txtFarmaciaIonas.setText("Farmacia Jasmine");
        txtFarmaciaIonas.setBounds(131, 25, 368, 56);
        panel_1.add(txtFarmaciaIonas);
        txtFarmaciaIonas.setColumns(10);

        txtProduse = new JTextField();
        txtProduse.setFocusable(false);
        txtProduse.setEditable(false);
        txtProduse.setBorder(null);
        txtProduse.setFont(new Font("Mongolian Baiti", Font.BOLD, 17));
        txtProduse.setHorizontalAlignment(SwingConstants.CENTER);
        txtProduse.setBackground(new Color(102, 204, 102));
        txtProduse.setText("Produse");
        txtProduse.setForeground(Color.WHITE);
        txtProduse.setBounds(20, 262, 260, 20);
        panel_2.add(txtProduse);
        txtProduse.setColumns(10);

        txtFarmacii = new JTextField();
        txtFarmacii.setFocusable(false);
        txtFarmacii.setEditable(false);
        txtFarmacii.setText("Farmacii");
        txtFarmacii.setHorizontalAlignment(SwingConstants.CENTER);
        txtFarmacii.setForeground(Color.WHITE);
        txtFarmacii.setFont(new Font("Mongolian Baiti", Font.BOLD, 17));
        txtFarmacii.setColumns(10);
        txtFarmacii.setBorder(null);
        txtFarmacii.setBackground(new Color(102, 204, 102));
        txtFarmacii.setBounds(372, 262, 260, 20);
        panel_2.add(txtFarmacii);

        txtGestiuneAdministrator = new JTextField();
        txtGestiuneAdministrator.setFocusable(false);
        txtGestiuneAdministrator.setEditable(false);
        txtGestiuneAdministrator.setText("Administrare");
        txtGestiuneAdministrator.setHorizontalAlignment(SwingConstants.CENTER);
        txtGestiuneAdministrator.setForeground(Color.WHITE);
        txtGestiuneAdministrator.setFont(new Font("Mongolian Baiti", Font.BOLD, 17));
        txtGestiuneAdministrator.setColumns(10);
        txtGestiuneAdministrator.setBorder(null);
        txtGestiuneAdministrator.setBackground(new Color(102, 204, 102));
        txtGestiuneAdministrator.setBounds(372, 547, 260, 20);
        panel_2.add(txtGestiuneAdministrator);

        txtComenzi = new JTextField();
        txtComenzi.setFocusable(false);
        txtComenzi.setText("Comenzi");
        txtComenzi.setHorizontalAlignment(SwingConstants.CENTER);
        txtComenzi.setForeground(Color.WHITE);
        txtComenzi.setFont(new Font("Mongolian Baiti", Font.BOLD, 17));
        txtComenzi.setEditable(false);
        txtComenzi.setColumns(10);
        txtComenzi.setBorder(null);
        txtComenzi.setBackground(new Color(102, 204, 102));
        txtComenzi.setBounds(725, 262, 260, 20);
        panel_2.add(txtComenzi);

        lblUser = new JLabel("Nelogat: vizitator");
        lblUser.setForeground(Color.WHITE);
        lblUser.setFont(new Font("Mongolian Baiti", Font.ITALIC, 18));
        lblUser.setHorizontalAlignment(SwingConstants.RIGHT);
        lblUser.setBounds(553, 38, 361, 36);
        panel_1.add(lblUser);
    }
}
