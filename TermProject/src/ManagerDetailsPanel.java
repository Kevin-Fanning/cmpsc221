// Author @Jeff

// compiles no errors

import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.GridLayout;

class ManagerDetailsPanel extends DetailsPanel
{
    JPanel buttonPanel = new JPanel(new GridLayout(2,2,5,5));
    JButton RemoveMedia;
    JButton CheckStats;
    JButton AddMedia;
    JButton CheckTotal;

    public ManagerDetailsPanel(ActionListener parent)
    {
        super(parent);
        
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
        
        add(buttonPanel);
    }
    
        
}