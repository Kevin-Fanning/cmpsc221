import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.GridLayout;

class ManagerDetailsPanel_Version2 extends JPanel
{
    Jpanel buttonPanel = new Jpanel();
    buttonPanel.setLayout(new GridLayout(2,2,5,5));
    JButton RemoveMedia;
    Jbutton CheckStats;
    Jbutton AddMedia;
    Jbutton CheckTotal;

    public ManagerDetailsPanel_Version2(ActionListener parent)
    {
        super();
        
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
        
    }
        
}