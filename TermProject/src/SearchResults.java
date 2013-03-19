import java.awt.Dimension;
import javax.swing.*;
import javax.swing.event.ListSelectionListener;

class SearchResults extends JPanel
{
    ListSelectionListener parent;
    
    DefaultListModel productListModel;
    JList productList;
    
    public SearchResults(ListSelectionListener parent)
    {
        super();
        productListModel = new DefaultListModel();
        productList = new JList(productListModel);
        productList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        productList.setPreferredSize(new Dimension(300, 400));
        productList.addListSelectionListener(parent);
        add(productList);
    }
    
    public void addMediaToList(Media media)
    {
        productListModel.addElement(media);
    }
    public void clearList()
    {
        productListModel.clear();
    }
}