package View;

import DAO.MedicamentDAO;
import Model.Medicament;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Toolkit;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import Util.StringParserForDescriptionTextArea;
import javax.swing.JTextArea;

public class IndividualProductPage {

    private JFrame view;
    private JTextField txtCantitate;
    public IndividualProductPage(Medicament medicament) {
        initialize(medicament);
    }
    private JButton btnAdaugaInCos;
    private JLabel lblStocBD;
    private JLabel lblNumeProdusBD;
    private JComboBox comboBox;
    private JTextArea descriere;
    private JLabel lblPretBD;

    /**
     * Initialize the contents of the frame.
     */
    private void initialize(Medicament medicament) {
        view = new JFrame();
        view.setResizable(false);
        view.setIconImage(Toolkit.getDefaultToolkit().getImage(IndividualProductPage.class.getResource("/images/pharmacy_80x80.png")));
        view.setTitle("Farmacia Jasmine");
        view.setBounds(100, 100, 1024, 720);
        view.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setBackground(Color.WHITE);
        view.getContentPane().add(panel, BorderLayout.CENTER);
        panel.setLayout(null);

        JPanel panel_1 = new JPanel();
        panel_1.setBounds(0, 0, 1008, 100);
        panel_1.setBackground(new Color(102, 204, 102));
        panel.add(panel_1);
        panel_1.setLayout(null);

        JLabel logo_farmacie = new JLabel("");
        logo_farmacie.setIcon(new ImageIcon(IndividualProductPage.class.getResource("/images/pharmacy_80x80.png")));
        logo_farmacie.setBounds(24, 11, 80, 80);
        panel_1.add(logo_farmacie);


        JLabel lblPaginaProdus = new JLabel("Pagina produs");
        lblPaginaProdus.setForeground(new Color(255, 255, 255));
        lblPaginaProdus.setFont(new Font("Mongolian Baiti", Font.ITALIC, 23));
        lblPaginaProdus.setBounds(180, 25, 326, 48);
        panel_1.add(lblPaginaProdus);

        JPanel panel_2 = new JPanel();
        panel_2.setFont(new Font("Mongolian Baiti", Font.PLAIN, 11));
        panel_2.setBorder(null);
        panel_2.setBackground(new Color(240, 255, 240));
        panel_2.setBounds(0, 99, 1008, 582);
        panel.add(panel_2);
        panel_2.setLayout(null);

        btnAdaugaInCos = new JButton("Adauga in cos");
        btnAdaugaInCos.setFocusTraversalKeysEnabled(false);
        btnAdaugaInCos.setFocusable(false);
        btnAdaugaInCos.setForeground(Color.WHITE);
        btnAdaugaInCos.setFont(new Font("Mongolian Baiti", Font.BOLD, 16));
        btnAdaugaInCos.setBorder(null);
        btnAdaugaInCos.setBackground(new Color(102, 204, 102));
        btnAdaugaInCos.setBounds(10, 512, 988, 59);
        panel_2.add(btnAdaugaInCos);

        JLabel lblCantitate = new JLabel("Introduceti cantitatea dorita");
        lblCantitate.setBackground(new Color(240, 255, 255));
        lblCantitate.setFont(new Font("Mongolian Baiti", Font.PLAIN, 17));
        lblCantitate.setBounds(10, 459, 205, 25);
        panel_2.add(lblCantitate);

        txtCantitate = new JTextField();
        txtCantitate.setFont(new Font("Mongolian Baiti", Font.PLAIN, 19));
        txtCantitate.setText("0");
        txtCantitate.setBorder(null);
        txtCantitate.setBounds(225, 462, 86, 20);
        panel_2.add(txtCantitate);
        txtCantitate.setColumns(10);

        JLabel lblDenumireProdus = new JLabel("Denumire produs: ");
        lblDenumireProdus.setHorizontalAlignment(SwingConstants.RIGHT);
        lblDenumireProdus.setFont(new Font("Mongolian Baiti", Font.PLAIN, 17));
        lblDenumireProdus.setBackground(new Color(240, 255, 255));
        lblDenumireProdus.setBounds(10, 11, 149, 25);
        panel_2.add(lblDenumireProdus);

        JLabel lblImagineProdus = new JLabel(" ");
        lblImagineProdus.setBackground(new Color(255, 255, 255));
        lblImagineProdus.setBounds(748, 83, 250, 250);
        panel_2.add(lblImagineProdus);

        lblNumeProdusBD = new JLabel(medicament.getDenumire());
        lblNumeProdusBD.setFont(new Font("Times New Roman", Font.PLAIN, 17));
        lblNumeProdusBD.setBackground(new Color(240, 255, 255));
        lblNumeProdusBD.setBounds(184, 11, 531, 25);
        panel_2.add(lblNumeProdusBD);

        JLabel lblStoc = new JLabel("Stoc online:");
        lblStoc.setHorizontalAlignment(SwingConstants.RIGHT);
        lblStoc.setFont(new Font("Mongolian Baiti", Font.PLAIN, 17));
        lblStoc.setBackground(new Color(240, 255, 255));
        lblStoc.setBounds(10, 47, 149, 25);
        panel_2.add(lblStoc);

        JLabel lblDescriere = new JLabel("Descriere:");
        lblDescriere.setHorizontalAlignment(SwingConstants.RIGHT);
        lblDescriere.setFont(new Font("Mongolian Baiti", Font.PLAIN, 17));
        lblDescriere.setBackground(new Color(240, 255, 255));
        lblDescriere.setBounds(10, 83, 149, 25);
        panel_2.add(lblDescriere);

        descriere = new JTextArea();
        descriere.setFont(new Font("Times New Roman", Font.BOLD, 19));
        descriere.setBackground(new Color(245, 255, 250));
        descriere.setText(StringParserForDescriptionTextArea.parseString(medicament.getDescriere()));
        descriere.setFocusable(true);
        descriere.setEditable(false);
        descriere.setBounds(184, 84, 480, 250);
        panel_2.add(descriere);

        lblStocBD = new JLabel(String.valueOf(medicament.getStoc()));
        lblStocBD.setHorizontalAlignment(SwingConstants.LEFT);
        lblStocBD.setFont(new Font("Mongolian Baiti", Font.PLAIN, 17));
        lblStocBD.setBackground(new Color(240, 255, 255));
        lblStocBD.setBounds(184, 47, 149, 25);
        panel_2.add(lblStocBD);

        JLabel lblDisponibilitate = new JLabel("Disponibilitate farmacii:");
        lblDisponibilitate.setHorizontalAlignment(SwingConstants.RIGHT);
        lblDisponibilitate.setFont(new Font("Mongolian Baiti", Font.PLAIN, 13));
        lblDisponibilitate.setBackground(new Color(240, 255, 255));
        lblDisponibilitate.setBounds(10, 345, 149, 25);
        panel_2.add(lblDisponibilitate);

        comboBox = new JComboBox();
        comboBox.setRequestFocusEnabled(false);
        comboBox.setBorder(null);
        comboBox.addItem("Online");
        for (String s : MedicamentDAO.getFarmacie(medicament.getIdMedicament())) {
            comboBox.addItem(s);
        }
        comboBox.setFont(new Font("Mongolian Baiti", Font.PLAIN, 15));
        comboBox.setFocusTraversalKeysEnabled(false);
        comboBox.setFocusable(false);
        comboBox.setBackground(new Color(240, 255, 240));
        comboBox.setBounds(184, 346, 351, 36);
        panel_2.add(comboBox);

        JLabel lblPret = new JLabel("Pret:");
        lblPret.setHorizontalAlignment(SwingConstants.RIGHT);
        lblPret.setFont(new Font("Mongolian Baiti", Font.PLAIN, 17));
        lblPret.setBackground(new Color(240, 255, 255));
        lblPret.setBounds(10, 391, 149, 25);
        panel_2.add(lblPret);

        lblPretBD = new JLabel(String.valueOf(medicament.getPret()) + " RON");
        lblPretBD.setHorizontalAlignment(SwingConstants.LEFT);
        lblPretBD.setFont(new Font("Mongolian Baiti", Font.PLAIN, 17));
        lblPretBD.setBackground(new Color(240, 255, 255));
        lblPretBD.setBounds(184, 393, 149, 25);
        panel_2.add(lblPretBD);
    }

    public JFrame getFrame() {
        return view;
    }

    public void setView(JFrame view) {
        this.view = view;
    }

    public JTextField getTxtCantitate() {
        return txtCantitate;
    }

    public void setTxtCantitate(JTextField txtCantitate) {
        this.txtCantitate = txtCantitate;
    }

    public JButton getBtnAdaugaInCos() {
        return btnAdaugaInCos;
    }

    public void setBtnAdaugaInCos(JButton btnAdaugaInCos) {
        this.btnAdaugaInCos = btnAdaugaInCos;
    }

    public JLabel getLblStocBD() {
        return lblStocBD;
    }

    public void setLblStocBD(JLabel lblStocBD) {
        this.lblStocBD = lblStocBD;
    }

    public JLabel getLblNumeProdusBD() {
        return lblNumeProdusBD;
    }

    public void setLblNumeProdusBD(JLabel lblNumeProdusBD) {
        this.lblNumeProdusBD = lblNumeProdusBD;
    }

    public JComboBox getComboBox() {
        return comboBox;
    }

    public void setComboBox(JComboBox comboBox) {
        this.comboBox = comboBox;
    }

    public JTextArea getDescriere() {
        return descriere;
    }

    public void setDescriere(JTextArea descriere) {
        this.descriere = descriere;
    }

    public JLabel getLblPretBD() {
        return lblPretBD;
    }

    public void setLblPretBD(JLabel lblPretBD) {
        this.lblPretBD = lblPretBD;
    }
}
