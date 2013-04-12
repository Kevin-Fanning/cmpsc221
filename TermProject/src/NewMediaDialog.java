
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.*;



class NewMediaDialog extends JDialog implements ActionListener, ItemListener
{
    JPanel pane;
    
    static String[] types = {"Music", "Film", "AudioBook"};
    
    JComboBox type;
    
    JLabel l_title;
    JTextField title;
    
    JLabel l_author;
    JTextField author;
    
    JLabel l_genre;
    JTextField genre;
    
    JLabel l_price;
    JTextField price;
    
    JLabel l_length;
    JTextField length;
    
    JLabel l_releaseYear;
    JTextField releaseYear;
    
    JButton submit;
    JButton cancel;
    
    Media editing;
    public NewMediaDialog(JFrame parent)
    {
        super(parent, "Add new Media");
        
        pane = new JPanel(new FlowLayout());
        
        type = new JComboBox(types);
        type.setPreferredSize(new Dimension(300, 20));
        type.addItemListener(this);
        
        l_title = new JLabel("Title:");
        l_author = new JLabel("Author:");
        l_genre = new JLabel("Genre:");
        l_price = new JLabel("Price:");
        l_length = new JLabel("Duration:");
        l_releaseYear = new JLabel("Release Year:");
        
        title = new JTextField(6);
        author = new JTextField(6);
        genre = new JTextField(6);
        price = new JTextField(6);
        length = new JTextField(6);
        releaseYear = new JTextField(6);
        
        submit = new JButton("Submit");
        submit.addActionListener(this);
        
        cancel = new JButton("Cancel");
        cancel.addActionListener(this);
        
        l_title.setPreferredSize(new Dimension(250, 20));
        l_author.setPreferredSize(new Dimension(250, 20));
        l_genre.setPreferredSize(new Dimension(250, 20));
        l_price.setPreferredSize(new Dimension(250, 20));
        l_length.setPreferredSize(new Dimension(250, 20));
        l_releaseYear.setPreferredSize(new Dimension(250, 20));
        
        pane.add(type);
        pane.add(l_title);
        pane.add(title);
        pane.add(l_author);
        pane.add(author);
        pane.add(l_genre);
        pane.add(genre);
        pane.add(l_price);
        pane.add(price);
        pane.add(l_length);
        pane.add(length);
        pane.add(l_releaseYear);
        pane.add(releaseYear);
        pane.add(submit);
        pane.add(cancel);
        add(pane);
        
        releaseYear.setEnabled(false);
        l_releaseYear.setEnabled(false);
    }
    
    @Override
    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == submit)
        {
            if (type.getItemAt(type.getSelectedIndex()) == "Music")
            {
                editing = new Music();
            }
            else if (type.getItemAt(type.getSelectedIndex()) == "Film")
            {
                editing = new Film();
                editing.setReleaseYear(Integer.valueOf(releaseYear.getText()));
            }
            else if (type.getItemAt(type.getSelectedIndex()) == "AudioBook")
            {
                editing = new AudioBook();
            }
            editing.setAuthor(author.getText());
            editing.setTitle(title.getText());
            editing.setGenre(genre.getText());
            editing.setDuration(length.getText());
            editing.setCost(Double.valueOf(price.getText()));
            editing.setRank(0);
            
            author.setText("");
            title.setText("");
            genre.setText("");
            length.setText("");
            price.setText("");
            
            MediaStore.addMedia(editing);
            
            setVisible(false);
        }
        else if (e.getSource() == cancel)
        {
            author.setText("");
            title.setText("");
            genre.setText("");
            length.setText("");
            price.setText("");
            
            setVisible(false);
        }
    }
    
    @Override
    public void itemStateChanged(ItemEvent e)
    {
        if (e.getSource() == type)
        {
            if (type.getItemAt(type.getSelectedIndex()) == "Film")
            {
                releaseYear.setEnabled(true);
                l_releaseYear.setEnabled(true);
                repaint();
            }
            else
            {
                releaseYear.setEnabled(false);
                l_releaseYear.setEnabled(false);
                repaint();
            }
        }
    }
}