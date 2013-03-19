
import java.awt.event.ActionListener;
import javax.swing.*;

class SearchOptions extends JPanel
{
    static final String[] mediaTypes = {"All", "Music Albums", "Music Singles",
        "Films", "AudioBooks" };
    
    static final String[] sortOptions = {"Title", "Artist/Author", "Genre", "Rank" };
    
    private ActionListener parent;
    
    private JButton button_search;
    private JLabel filterBy;
    private JLabel sortBy;
    private JLabel search;
    private JComboBox cb_filterBy;
    private JComboBox cb_sortBy;
    private JTextField searchField;
    
    public SearchOptions(ActionListener parent)
    {
        super();
        
        this.parent = parent;
        
        filterBy = new JLabel("Filter by: ");
        add(filterBy);
        
        cb_filterBy = new JComboBox(mediaTypes);
        add(cb_filterBy);
        
        sortBy = new JLabel("Sort by: ");
        add(sortBy);
        
        cb_sortBy = new JComboBox(sortOptions);
        add(cb_sortBy);
        
        search = new JLabel("Search: ");
        add(search);
        searchField = new JTextField(8);
        add(searchField);
        
        button_search = new JButton("Search");
        button_search.addActionListener(parent);
        add(button_search);
    }
    
    public String getSelectedFilter()
    {
        return cb_filterBy.getItemAt(cb_filterBy.getSelectedIndex()).toString();
    }
    public String getSelectedSort()
    {
        return cb_sortBy.getItemAt(cb_sortBy.getSelectedIndex()).toString();
    }
}