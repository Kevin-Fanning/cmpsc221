import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import javax.swing.*;

class StoreFrontPanel extends JPanel implements ActionListener
{
    static final String[] mediaTypes = {"All", "Music Albums", "Music Singles",
        "Films", "AudioBooks" };
    
    static final String[] sortOptions = {"Title", "Artist/Author", "Genre" };
    
    SearchOptions panel_searchOptions;
    SearchResults panel_results;
    MediaDetailsPanel panel_details;
    
    public StoreFrontPanel()
    {
        super();
        
        BorderLayout layout = new BorderLayout();
        setLayout(layout);
        
        //Search Options ---------------------------------------------------
        panel_searchOptions = new SearchOptions(this);
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
        
        
        //TEST STUFF
        try {
            MediaStore.addMedia(new Film("Star Wars", "George Lucas", 1, 10.99, "1.mp3", "Action"));
            MediaStore.addMedia(new Film("Lion King", "ZDisney", 2, 15.99, "1.mp3", "Family"));
            MediaStore.addMedia(new Music("Take Me Out", "Franz Ferdinand", 4, 0.99, "1.mp3", "Alt Rock"));
        }
        catch (Exception e)
        {

        }
    }
    @Override
    public void actionPerformed(ActionEvent e)
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
            panel_results.addMediaToList(m);
        }
    }
}