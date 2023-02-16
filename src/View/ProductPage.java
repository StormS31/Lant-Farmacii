package View;

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.LineBorder;

public class ProductPage extends JFrame{

    private JFrame frmProduse;
    private JTextField textField;
    private JTable table;
    private JPanel panel;
    private JPanel panel_1;
    private JLabel whiteCircleBg;
    private JPanel panel_2;
    private JLabel logo_farmacie;
    private JTextArea txtrCautatiProdusul;
    private JComboBox comboBox;
    private JScrollPane scrollPane;
    private JButton logoutBtn;
    private JButton searchButton;
    private JButton btnFinalizeaza;
    private JLabel lblUser;
    /**
     * Initialize the contents of the frame.
     */
    public JFrame getFrame() {
        return this.frmProduse;
    }

    public ProductPage(String nume) {
        initializeFrame();
        initializePanels();
        initializeLogoutBtn();
        initializeTextFields();
        initializeLabels(nume);
        initializeTextArea();
        initializeTable();
        initializeComboBox();
        initializeBtnFinalizeaza();
        initializeSearchButton();
    }
    public ProductPage(Boolean searchOnlyPurposes) {
        initializeFrame();
        initializePanels();
        initializeTextFields();
        initializeLabels("");
        initializeTextArea();
        initializeTable();
        initializeSearchButton();
        lblUser.setText("");
        txtrCautatiProdusul.setText("");
        whiteCircleBg.setIcon(null);
    }
    private void initializeFrame()
    {
        frmProduse = new JFrame();
        frmProduse.setResizable(false);
        frmProduse.setIconImage(Toolkit.getDefaultToolkit().getImage(MainPage.class.getResource("/images/pharmacy_80x80.png")));
        frmProduse.setTitle("Farmacia Ionas");
        frmProduse.setBounds(100, 100, 1024, 720);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        frmProduse.setLocation(dim.width/2-frmProduse.getSize().width/2, dim.height/2-frmProduse.getSize().height/2);
    }
    
    private void initializePanels()
    {
        panel = new JPanel();
        panel.setBackground(Color.WHITE);
        frmProduse.getContentPane().add(panel, BorderLayout.CENTER);
        panel.setLayout(null);

        panel_1 = new JPanel();
        panel_1.setBounds(0, 0, 1008, 100);
        panel_1.setBackground(new Color(102, 204, 102));
        panel.add(panel_1);
        panel_1.setLayout(null);

        panel_2= new JPanel();
        panel_2.setBorder(null);
        panel_2.setBackground(Color.WHITE);
        panel_2.setBounds(0, 99, 1008, 582);
        panel.add(panel_2);
        panel_2.setLayout(null);

        scrollPane = new JScrollPane();
        scrollPane.setBackground(Color.WHITE);
        scrollPane.setBorder(new LineBorder(new Color(130, 135, 144)));
        scrollPane.setBounds(198, 11, 800, 560);
        panel_2.add(scrollPane);
    }
    
    private void initializeTextFields()
    {
        textField = new JTextField();
        textField.setFont(new Font("Mongolian Baiti", Font.PLAIN, 15));
        textField.setBorder(null);
        textField.setBounds(146, 40, 363, 36);
        panel_1.add(textField);
        textField.setColumns(10);
    }
    
    private void initializeLabels(String nume)
    {
        whiteCircleBg = new JLabel("");
        whiteCircleBg.setIcon(new ImageIcon(MainPage.class.getResource("/images/white_circle_92.png")));
        whiteCircleBg.setBounds(924, 9, 82, 82);
        panel_1.add(whiteCircleBg);

        logo_farmacie = new JLabel("");
        logo_farmacie.setIcon(new ImageIcon(MainPage.class.getResource("/images/pharmacy_80x80.png")));
        logo_farmacie.setBounds(24, 11, 80, 80);
        panel_1.add(logo_farmacie);

        lblUser = new JLabel("Nelogat: vizitator");
        if(nume != null)
            lblUser.setText("Utilizator: " + nume);
        lblUser.setForeground(Color.WHITE);
        lblUser.setFont(new Font("Mongolian Baiti", Font.ITALIC, 18));
        lblUser.setHorizontalAlignment(SwingConstants.RIGHT);
        lblUser.setBounds(553, 38, 361, 36);
        panel_1.add(lblUser);
    }
    
    private void initializeTextArea()
    {
        txtrCautatiProdusul = new JTextArea();
        txtrCautatiProdusul.setText("1. Cautati produsul folosind\r\nbara de cautare sau selectati\r\no categorie de produse.\r\n\r\n2. Apasati pe produsul dorit pentru\r\na afla detalii despre acesta.\r\n\r\n3. Adaugati produsul in cos!\r\n\r\n4. Finalizati comanda!");
        txtrCautatiProdusul.setBorder(null);
        txtrCautatiProdusul.setBackground(new Color(240, 255, 240));
        txtrCautatiProdusul.setFont(new Font("Mongolian Baiti", Font.PLAIN, 16));
        txtrCautatiProdusul.setRequestFocusEnabled(false);
        txtrCautatiProdusul.setEditable(false);
        txtrCautatiProdusul.setBounds(10, 57, 178, 444);
        panel_2.add(txtrCautatiProdusul);
    }

    private void initializeTable() {
        table = new JTable();
        table.setBackground(new Color(240, 255, 240));
        table.setRowHeight(60);
        table.setRowMargin(3);
        table.setSize(new Dimension(2, 2));
        table.setFont(new Font("Times New Roman", Font.PLAIN, 17));
        table.setModel(new DefaultTableModel(
                new Object[][]{

                },
                new String[]{
                        "ID", "Denumire produs", "Pret", "Categorie"
                }
        ));
        scrollPane.setViewportView(table);
    }

    private void initializeComboBox()
    {
        comboBox = new JComboBox();
        comboBox.setFocusTraversalKeysEnabled(false);
        comboBox.setFocusable(false);
        comboBox.setFont(new Font("Mongolian Baiti", Font.PLAIN, 16));
        comboBox.setBackground(new Color(240, 255, 240));
        comboBox.setModel(new DefaultComboBoxModel(new String[] {"Selecteaza categoria", "Alinare a durerii", "Antibiotice", "Anxietate", "Inflamatie", "Diabet", "Hipertensiune", "Disfunctie erectila"}));
        comboBox.setBounds(10, 11, 178, 35);
        panel_2.add(comboBox);
    }

    public JLabel getLblUser() {
        return lblUser;
    }

    private void initializeLogoutBtn() {
        logoutBtn = new JButton("");
        logoutBtn.setFocusPainted(false);
        logoutBtn.setFocusTraversalKeysEnabled(false);
        logoutBtn.setFocusable(false);
        logoutBtn.setIcon(new ImageIcon(MainPage.class.getResource("/images/log-in.png")));
        logoutBtn.setActionCommand("");
        logoutBtn.setBorder(null);
        logoutBtn.setFont(new Font("Mongolian Baiti", Font.BOLD, 17));
        logoutBtn.setForeground(new Color(255, 255, 255));
        logoutBtn.setBackground(new Color(255, 255, 255));
        logoutBtn.setBounds(945, 25, 51, 51);
        panel_1.add(logoutBtn);
    }
        
    private void initializeSearchButton() {
        searchButton = new JButton("Cauta");
        searchButton.setFocusable(false);
        searchButton.setFocusTraversalKeysEnabled(false);
        searchButton.setFocusPainted(false);
        searchButton.setBorder(null);
        searchButton.setFont(new Font("Mongolian Baiti", Font.PLAIN, 15));
        searchButton.setBackground(SystemColor.menu);
        searchButton.setBounds(509, 40, 95, 36);
        panel_1.add(searchButton);
    }

    private void initializeBtnFinalizeaza(){

        btnFinalizeaza = new JButton("Finalizeaza comanda");
        btnFinalizeaza.setFocusTraversalKeysEnabled(false);
        btnFinalizeaza.setFocusable(false);
        btnFinalizeaza.setForeground(Color.WHITE);
        btnFinalizeaza.setFont(new Font("Mongolian Baiti", Font.BOLD, 16));
        btnFinalizeaza.setBorder(null);
        btnFinalizeaza.setBackground(new Color(102, 204, 102));
        btnFinalizeaza.setBounds(10, 512, 178, 59);
        panel_2.add(btnFinalizeaza);
    }

    public JTable getTable() {
        return table;
    }

    public void setTable(JTable table){this.table = table;}

    public JTextArea getTxtrCautatiProdusul() {
        return txtrCautatiProdusul;
    }

    public JButton getLogoutBtn() {
        return logoutBtn;
    }

    public JButton getSearchButton() {
        return searchButton;
    }

    public JButton getBtnFinalizeaza() {
        return btnFinalizeaza;
    }

    public JComboBox getComboBox() {
        return comboBox;
    }

    public JTextField getCauta()
    {
        return textField;
    }
}
