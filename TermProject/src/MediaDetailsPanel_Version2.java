import java.awt.event.ActionListener;
import javax.swing.*;

// compiles no errors

class MediaDetailsPanel_Version2 extends DetailsPanel
{
    
    JButton purchase;
    public MediaDetailsPanel_Version2(ActionListener parent)
    {
        super(parent);
                
        purchase = new JButton("Purchase");
        purchase.addActionListener(parent);
        
        add(purchase);
    }    
    
}