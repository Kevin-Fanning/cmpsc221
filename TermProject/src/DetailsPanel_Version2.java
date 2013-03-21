// DetailsPanel superclass
// 
//Author @ Jeff Dreyer

// compiles, no errors

import java.awt.event.ActionListener;
import javax.swing.*;

class DetailsPanel extends JPanel
{
    ActionListener parent;
    
    Media currentMedia;
    
    JLabel title;
    JLabel type;
    JLabel author;
    JLabel genre;
    JLabel price;
    
    public DetailsPanel(ActionListener parent)
    {
        super();
        
        this.parent = parent;
        
        title = new JLabel();
        type = new JLabel();
        author = new JLabel();
        genre = new JLabel();
        price = new JLabel();

        add(title);
        add(author);
        add(genre);
        add(price);
    }
    
    public void setMedia(Media m)
    {
        currentMedia = m;
        if (m instanceof Music)
        {
            type.setText("Music");
        }
        else if (m instanceof Film)
        {
            type.setText("Film");
            genre.setText(((Film)m).getGenre());
        }
        else if (m instanceof AudioBook)
        {
            type.setText("Audio Book");
        }
        else if (m instanceof Album)
        {
            type.setText("Album");
        }
        title.setText(m.getTitle());
        author.setText(m.getAuthor());
        price.setText(Double.valueOf(m.getCost()).toString());
    }
}