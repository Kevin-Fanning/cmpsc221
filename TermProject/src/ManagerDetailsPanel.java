// Author @Jeff

// compiles no errors

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.GridLayout;

class ManagerDetailsPanel extends DetailsPanel
{
    JPanel buttonPanel = new JPanel(new FlowLayout());
    JButton RemoveMedia;
    JButton AddMedia;
    
    JLabel totalSold;
    JLabel itemSold;
    JTextField tf_totalSold;
    JTextField tf_itemSold;

    public ManagerDetailsPanel(ActionListener parent)
    {
        super(parent);
        
        RemoveMedia = new JButton("Remove");
        RemoveMedia.addActionListener(parent);
        buttonPanel.add(RemoveMedia);
        AddMedia = new JButton("Add New Media");
        AddMedia.addActionListener(parent);
        buttonPanel.add(AddMedia);    
        add(buttonPanel);
        
        totalSold = new JLabel("Total Items Sold:");
        totalSold.setPreferredSize(new Dimension(200, 50));
        tf_totalSold = new JTextField(6);
        itemSold = new JLabel("# of this item Sold:");
        itemSold.setPreferredSize(new Dimension(200, 50));
        tf_itemSold = new JTextField(6);
        
        tf_totalSold.setEditable(false);
        tf_itemSold.setEditable(false);
        
        add(itemSold);
        add(tf_itemSold);
        add(totalSold);
        add(tf_totalSold);
    }
    
    @Override
    public void setMedia(Media media)
    {
        super.setMedia(media);
        
        tf_itemSold.setText(new Integer(media.getRank()).toString());
    }
        
}