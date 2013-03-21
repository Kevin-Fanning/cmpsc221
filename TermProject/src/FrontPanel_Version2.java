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


class FrontPanel_Version2 extends JPanel implements ActionListener, ListSelectionListener
{

	SearchOptions panel_searchOptions;  //Panel containing options to filter the media
    SearchResults panel_results;        //Panel containing a selector for filtered media
    
    public FrontPanel_Version2()
    {
        super();
        
        BorderLayout layout = new BorderLayout();
        setLayout(layout);
        
        //Search Options ---------------------------------------------------
        panel_searchOptions = new SearchOptions(this);
        panel_searchOptions.setPreferredSize(new Dimension(600, 50));
        add(panel_searchOptions, BorderLayout.NORTH);
        
        //Results -------------------------------------------------------------
        panel_results = new SearchResults(this);
        panel_results.setPreferredSize(new Dimension(300, 400));
        add(panel_results, BorderLayout.WEST);
        
                
        
        //TEST STUFF
        try {
            MediaStore.addMedia(new Film("Star Wars", "George Lucas", 1, 10.99, "starwars.mp4", "Action"));
            MediaStore.addMedia(new Film("Lion King", "ZDisney", 2, 15.99, "The Lion King.mp4", "Family"));
            MediaStore.addMedia(new Music("Take Me Out", "Franz Ferdinand", 4, 0.99, "Take Me Out.mp3", "Alt Rock"));
        }
        catch (Exception e)
        {
            System.err.println("Test file to upload not found");
        }
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
            case "Music Singles":
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
                        return left.getFilename().compareTo(right.getFilename());
                    case "Rank":
                        return Integer.valueOf(left.getRank()).compareTo(Integer.valueOf(right.getRank()));
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

    public void valueChanged(ListSelectionEvent e)
    {    }
}