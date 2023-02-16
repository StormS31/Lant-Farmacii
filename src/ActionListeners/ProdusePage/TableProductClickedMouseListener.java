package ActionListeners.ProdusePage;

import Controller.ControllerIndividualProductPage;
import Model.Medicament;
import Model.ProductPageModel;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

public class TableProductClickedMouseListener implements MouseListener {
        private JTable table;
        private List<Medicament> medicamente;
        private Medicament medicamentToSend;
        public TableProductClickedMouseListener(JTable table){this.table = table;}

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
        public void mousePressed(MouseEvent e) {
            int row,column;
            if(e.getClickCount() == 2)
            {
                this.medicamente = ProductPageModel.getMedicamente();
                row = table.getSelectedRow();
                column = table.getSelectedColumn();
                //System.out.println(table.getValueAt(row,column));
                medicamente.forEach((medicament1) -> {
                    if (medicament1.getIdMedicament() == Integer.parseInt(table.getModel().getValueAt(row, 0).toString()))
                        this.medicamentToSend = medicament1;
                });
                new ControllerIndividualProductPage(medicamentToSend);
            }
        }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
};
