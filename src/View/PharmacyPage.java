package View;

import Model.Farmacie;

import java.awt.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.border.MatteBorder;

public class PharmacyPage {

    private JFrame PharmacyPage;
    private JTextField oras;
    private JTextField strada;
    private JTextField numar;
    private JTextField program;
    private JPanel panel;
    private JPanel panel_1;
    private JPanel panel_2;
    private JPanel panel_3;
    private JLabel lblNewLabel_1;
    private JLabel lblNewLabel_1_1;
    private JLabel lblNewLabel_1_2;
    private JLabel lblNewLabel_1_3;
    private JLabel logo_farmacie;
    private JLabel lblNewLabel;
    private JComboBox comboBox;

    public PharmacyPage() {
        initializeFrame();
        initializePanels();
        initializeTextFields();
        initializeLabels();
        initializeComboBox();
    }
    private void initializeFrame() {
        PharmacyPage = new JFrame();
        PharmacyPage.setResizable(false);
        PharmacyPage.setIconImage(Toolkit.getDefaultToolkit().getImage(MainPage.class.getResource("/images/pharmacy_80x80.png")));
        PharmacyPage.setTitle("Farmacia Ionas");
        PharmacyPage.setBounds(100, 100, 729, 436);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        PharmacyPage.setLocation(dim.width/2-PharmacyPage.getSize().width/2, dim.height/2-PharmacyPage.getSize().height/2);
    }
    private void initializeLabels(){

        lblNewLabel_1 = new JLabel("Strada:");
        lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
        lblNewLabel_1.setFont(new Font("Mongolian Baiti", Font.PLAIN, 20));
        lblNewLabel_1.setBounds(10, 74, 115, 30);
        panel_3.add(lblNewLabel_1);

        lblNewLabel_1_1 = new JLabel("Program:");
        lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
        lblNewLabel_1_1.setFont(new Font("Mongolian Baiti", Font.PLAIN, 20));
        lblNewLabel_1_1.setBounds(10, 193, 115, 30);
        panel_3.add(lblNewLabel_1_1);

        lblNewLabel_1_2 = new JLabel("Oras:");
        lblNewLabel_1_2.setBackground(new Color(255, 255, 255));
        lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.RIGHT);
        lblNewLabel_1_2.setFont(new Font("Mongolian Baiti", Font.PLAIN, 20));
        lblNewLabel_1_2.setBounds(10, 11, 115, 30);
        panel_3.add(lblNewLabel_1_2);

        lblNewLabel_1_3 = new JLabel("Numar:");
        lblNewLabel_1_3.setHorizontalAlignment(SwingConstants.RIGHT);
        lblNewLabel_1_3.setFont(new Font("Mongolian Baiti", Font.PLAIN, 20));
        lblNewLabel_1_3.setBounds(10, 133, 115, 30);
        panel_3.add(lblNewLabel_1_3);

        logo_farmacie = new JLabel("");
        logo_farmacie.setIcon(new ImageIcon(MainPage.class.getResource("/images/pharmacy_80x80.png")));
        logo_farmacie.setBounds(24, 11, 80, 80);
        panel_1.add(logo_farmacie);

        lblNewLabel = new JLabel("Informatii farmacii");
        lblNewLabel.setForeground(new Color(255, 255, 255));
        lblNewLabel.setFont(new Font("Mongolian Baiti", Font.ITALIC, 28));
        lblNewLabel.setBounds(132, 25, 249, 51);
        panel_1.add(lblNewLabel);
    }
    private void initializeComboBox() {
        comboBox = new JComboBox();
        comboBox.setFocusTraversalKeysEnabled(false);
        comboBox.setFocusable(false);
        comboBox.setFont(new Font("Mongolian Baiti", Font.PLAIN, 16));
        comboBox.setBackground(new Color(240, 255, 240));
        comboBox.setModel(new DefaultComboBoxModel(new String[]{"Selecteaza farmacia"}));
        comboBox.setBounds(10, 16, 178, 35);
        panel_2.add(comboBox);
    }
    private void initializePanels(){
        panel = new JPanel();
        panel.setBackground(Color.WHITE);
        PharmacyPage.getContentPane().add(panel, BorderLayout.CENTER);
        panel.setLayout(null);

        panel_1 = new JPanel();
        panel_1.setBounds(0, 0, 719, 100);
        panel_1.setBackground(new Color(102, 204, 102));
        panel.add(panel_1);
        panel_1.setLayout(null);

        panel_2 = new JPanel();
        panel_2.setBorder(null);
        panel_2.setBackground(new Color(240, 255, 240));
        panel_2.setBounds(0, 99, 719, 298);
        panel.add(panel_2);
        panel_2.setLayout(null);

        panel_3 = new JPanel();
        panel_3.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(107, 142, 35)));
        panel_3.setBackground(new Color(240, 255, 240));
        panel_3.setBounds(198, 15, 500, 270);
        panel_2.add(panel_3);
        panel_3.setLayout(null);


    }
    private void initializeTextFields(){
        oras = new JTextField();
        oras.setEditable(false);
        oras.setBorder(null);
        oras.setBackground(new Color(255, 250, 250));
        oras.setBounds(135, 14, 115, 26);
        panel_3.add(oras);
        oras.setColumns(10);

        strada = new JTextField();
        strada.setEditable(false);
        strada.setBackground(new Color(255, 250, 250));
        strada.setBorder(null);
        strada.setColumns(10);
        strada.setBounds(135, 74, 115, 26);
        panel_3.add(strada);

        numar = new JTextField();
        numar.setEditable(false);
        numar.setBackground(new Color(255, 250, 250));
        numar.setBorder(null);
        numar.setColumns(10);
        numar.setBounds(135, 133, 115, 26);
        panel_3.add(numar);

        program = new JTextField();
        program.setEditable(false);
        program.setBackground(new Color(255, 250, 250));
        program.setBorder(null);
        program.setColumns(10);
        program.setBounds(135, 193, 194, 26);
        panel_3.add(program);
    }

    public JFrame getFrame() {
        return PharmacyPage;
    }

    public JTextField getTextField() {
        return oras;
    }

    public JTextField getstrada() {
        return strada;
    }

    public JTextField getnumar() {
        return numar;
    }

    public JTextField getprogram() {
        return program;
    }

    public JComboBox getComboBox() {
        return comboBox;
    }

    public void update(Farmacie far) {
        this.oras.setText(far.getOras());
        this.program.setText(far.getProgram());
        this.numar.setText(String.valueOf(far.getNumar()));
        this.strada.setText(far.getStrada());
    }
}
