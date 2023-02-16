package ActionListeners.ProdusePage;

import ActionListeners.LogInPage.BtnRegisterActionListener;
import Model.ProductPageModel;
import View.ProductPage;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BtnCautaActionListener implements ActionListener {
    private ProductPageModel productPageModel;
    private ProductPage view;
    @Override
    public void actionPerformed(ActionEvent e) {
        this.productPageModel.setTableBySearch(view.getTable(), view.getCauta().getText());
    }
    public BtnCautaActionListener(ProductPage view, ProductPageModel productPageModel){
        this.view = view;
        this.productPageModel = productPageModel;
    }

}
