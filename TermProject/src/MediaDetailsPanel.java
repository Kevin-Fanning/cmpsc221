import java.awt.event.ActionListener;
import javax.swing.*;

// compiles no errors

class MediaDetailsPanel extends DetailsPanel
{
    
    JButton purchase;
    public MediaDetailsPanel(ActionListener parent)
    {
        super(parent);
                
        purchase = new JButton("Purchase");
        purchase.addActionListener(parent);
        
        add(purchase);
    }    
    
}