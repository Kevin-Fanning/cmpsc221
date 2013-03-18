import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import javax.swing.*;

class StoreFrontPanel extends JPanel
{
    static final String[] mediaTypes = {"All", "Music Albums", "Music Singles",
        "Films", "AudioBooks" };
    
    static final String[] sortOptions = {"Title", "Artist/Author", "Genre" };
    
    JPanel panel_searchOptions;
    JPanel panel_results;
    JPanel panel_details;
    
    public StoreFrontPanel()
    {
        super();
        
        BorderLayout layout = new BorderLayout();
        setLayout(layout);
        
        //Search Options ---------------------------------------------------
        panel_searchOptions = new SearchOptions();
        panel_searchOptions.setPreferredSize(new Dimension(600, 50));
        add(panel_searchOptions, BorderLayout.NORTH);
        
        //Results -------------------------------------------------------------
        panel_results = new SearchResults();
        panel_results.setPreferredSize(new Dimension(300, 400));
        add(panel_results, BorderLayout.WEST);
        
        //Details ------------------------------------------------------------
        panel_details = new MediaDetailsPanel();
        panel_details.setPreferredSize(new Dimension(300, 400));
        add(panel_details, BorderLayout.EAST);
    }
    @Override
    public void update(Graphics g)
    {
        super.update(g);
    }
}