import java.awt.event.ActionListener;
import javax.swing.*;

class MediaDetailsPanel extends DetailsPanel
{
    
    JButton purchase;
    public MediaDetailsPanel(ActionListener parent)
    {
        super();
                
        purchase = new JButton("Purchase");
        purchase.addActionListener(parent);
        
        add(purchase);
    }    
    
}