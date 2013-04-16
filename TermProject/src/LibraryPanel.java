import java.awt.Dimension;
import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.*;

class LibraryPanel extends JPanel
{
    JList library;
    DefaultListModel model;
    
    public LibraryPanel()
    {
        super();
        model = new DefaultListModel();
        library = new JList(model);
        
        library.setPreferredSize(new Dimension(600, 600));
        
        add(library);
    }
    @Override
    public void paint(Graphics g)
    {
        super.paint(g);
        refresh();
    }
    public void refresh()
    {
        ArrayList<Media> media = MediaStore.getUsersMedia();
        model.clear();
        for (int i = 0; i < media.size(); i++)
        {
            model.addElement(media.get(i));
        }
    }
}