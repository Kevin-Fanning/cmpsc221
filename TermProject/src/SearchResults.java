import java.awt.Dimension;
import javax.swing.*;
import javax.swing.event.ListSelectionListener;

class SearchResults extends JPanel
{
    JLabel key;
    ListSelectionListener parent;
    DefaultListModel productListModel;
    JList productList;
    
    public SearchResults(ListSelectionListener parent)
    {
        super();
       
        key = new JLabel("Title | Author/Artist/Director | Genre | Duration | Rank | Price");
        add(key);
        productListModel = new DefaultListModel();
        productList = new JList(productListModel);
        productList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        productList.setPreferredSize(new Dimension(500, 400));
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