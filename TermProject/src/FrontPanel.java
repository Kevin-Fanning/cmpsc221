/**
 * name: Kevin Fanning  Jeff Dreyer 
 * program: Term Project
 * date: 3/21/2013
 * section: 1
 */

// compiles no errors

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputMethodEvent;
import java.awt.event.InputMethodListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;


class FrontPanel extends JPanel implements ActionListener, ListSelectionListener
{

    SearchOptions panel_searchOptions;  //Panel containing options to filter the media
    SearchResults panel_results;        //Panel containing a selector for filtered media
    
    public FrontPanel()
    {
        super();
        
        BorderLayout layout = new BorderLayout();
        setLayout(layout);
        
        //Search Options ---------------------------------------------------
        panel_searchOptions = new SearchOptions(this);
        panel_searchOptions.setPreferredSize(new Dimension(800, 50));
        add(panel_searchOptions, BorderLayout.NORTH);
        
        //Results -------------------------------------------------------------
        panel_results = new SearchResults(this);
        panel_results.setPreferredSize(new Dimension(500, 400));
        add(panel_results, BorderLayout.WEST);
        
                
        
        

    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource().equals(panel_searchOptions.button_search))
        {
            sortFilterAndAddToList();
        }
        
    }
          
    
    /**
     * Reads and filters the master media list according to filters. This will 
     * be replaced by sql queries when databases are implemented.
     */
    private void sortFilterAndAddToList()
    {
        panel_results.clearList();
        ArrayList<Media> media = new ArrayList<>();
        switch (panel_searchOptions.getSelectedFilter()) {
            case "All":
                media = MediaStore.getAllMedia();
                break;
            case "Films":
                media = MediaStore.listFilms();
                break;
            case "Music":
                media = MediaStore.listMusic();
                break;
            case "AudioBooks":
                media = MediaStore.listAudioBooks();
                break;
        }
        
        //I know we aren't supposed to know anonymous functions yet, but
        //it made this much simpler.
        Collections.sort(media, new Comparator<Media>() {
            @Override
            public int compare(Media left, Media right)
            {
                switch (panel_searchOptions.getSelectedSort())
                {
                    case "Artist/Author" :
                        return left.getAuthor().compareTo(right.getAuthor());
                    case "Title":
                        return left.getTitle().compareTo(right.getTitle());
                    case "Genre":
                        return left.getGenre().compareTo(right.getGenre());
                    case "Rank":
                        return Integer.valueOf(right.getRank()).compareTo(Integer.valueOf(left.getRank()));
                }
                return 0;
            }
        });
        
        for (Media m : media)
        {
            String searchField = panel_searchOptions.getSearchField();
            if (!("".equals(searchField)))
            {
                if (searchField.equalsIgnoreCase(m.author) || searchField.equalsIgnoreCase(m.title))
                {
                    panel_results.addMediaToList(m);
                }
            }
            else
            {
                panel_results.addMediaToList(m);
            }
        }
    }

    public void setCredits(double credits)
    {
       
    }
    
    public void setTotalSold(int sold)
    {
        
    }
    
    
    public void valueChanged(ListSelectionEvent e)
    {    }
}