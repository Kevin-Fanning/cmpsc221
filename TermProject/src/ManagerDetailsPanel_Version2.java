import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.GridLayout;

class ManagerDetailsPanel extends JPanel
{
    ActionListener parent;
    
    Media currentMedia;
    
    JLabel title;
    JLabel type;
    JLabel author;
    JLabel genre;
    JLabel price;
    Jpanel buttonPanel = new Jpanel();
    buttonPanel.setLayout(new GridLayout(2,2,5,5));
    JButton RemoveMedia;
    Jbutton CheckStats;
    Jbutton AddMedia;
    Jbutton CheckTotal;

    public MediaDetailsPanel(ActionListener parent)
    {
        super();
        
        this.parent = parent;
        
        title = new JLabel();
        type = new JLabel();
        author = new JLabel();
        genre = new JLabel();
        price = new JLabel();
        RemoveMedia = new JButton("Remove");
        RemoveMedia.addActionListener(parent);
        buttonPanel.add(RemoveMedia);
        CheckStats = new JButton("Check Media Sales");
        CheckStats.addActionListener(parent);
        buttonPanel.add(CheckStats);
        AddMedia = new JButton("Add New Media");
        AddMedia.addActionListener(parent);
        buttonPanel.add(AddMedia);
        CheckTotal = new JButton("Check Total Store Sales");
        CheckTotal.addActionListener(parent);
        buttonPanel.add(CheckTotal);
        
        add(title);
        add(author);
        add(genre);
        add(price);
        add(buttonPanel);
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