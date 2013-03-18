
import javax.swing.*;

class SearchOptions extends JPanel
{
    static final String[] mediaTypes = {"All", "Music Albums", "Music Singles",
        "Films", "AudioBooks" };
    
    static final String[] sortOptions = {"Title", "Artist/Author", "Genre" };
    
    JButton button_search;
    JLabel filterBy;
    JLabel sortBy;
    JLabel search;
    JComboBox cb_filterBy;
    JComboBox cb_sortBy;
    JTextField searchField;
    
    public SearchOptions()
    {
        super();
        
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
        add(button_search);
    }
}