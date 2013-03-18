import java.awt.Dimension;
import javax.swing.*;

class SearchResults extends JPanel
{
    DefaultListModel productListModel;
    JList productList;
    
    public SearchResults()
    {
        super();
        productListModel = new DefaultListModel();
        productList = new JList(productListModel);
        productList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        productList.setPreferredSize(new Dimension(300, 400));
        add(productList);
    }
}