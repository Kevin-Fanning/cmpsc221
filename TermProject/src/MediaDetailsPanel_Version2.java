import java.awt.event.ActionListener;
import javax.swing.*;

class MediaDetailsPanel_Version2 extends DetailsPanel
{
    
    JButton purchase;
    public MediaDetailsPanel_Version2(ActionListener parent)
    {
        super();
                
        purchase = new JButton("Purchase");
        purchase.addActionListener(parent);
        
        add(purchase);
    }    
    
}