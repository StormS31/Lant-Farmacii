package ActionListeners.ProdusePage;

import Model.ProductPageModel;
import View.ProductPage;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ComboBoxActionListener implements ActionListener {
        private ProductPageModel productPageModel;
        private ProductPage view;
        public ComboBoxActionListener(ProductPageModel productPageModel, ProductPage view) {
                this.productPageModel = productPageModel;
                this.view = view;
        }

        public void actionPerformed(ActionEvent e) {
                this.productPageModel.setTableByCategorie(view.getTable(),this.view.getComboBox().getSelectedItem().toString());
        }
}
