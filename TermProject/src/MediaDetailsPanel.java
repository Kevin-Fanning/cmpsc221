import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import javax.swing.*;

// compiles no errors

class MediaDetailsPanel extends DetailsPanel
{
    JPanel purchaseDetails;
    
    JButton purchase;
    JTextField currentCredits;
    JLabel l_currentCredits;
    public MediaDetailsPanel(ActionListener parent)
    {
        super(parent);
             
        purchaseDetails = new JPanel(new FlowLayout());
        purchaseDetails.setPreferredSize(new Dimension(200, 200));
        
        purchase = new JButton("Purchase");
        purchase.addActionListener(parent);
        
        currentCredits = new JTextField(6);
        l_currentCredits = new JLabel("Current Credits: $");
        currentCredits.setEditable(false);
        purchaseDetails.add(l_currentCredits, BorderLayout.NORTH);
        purchaseDetails.add(currentCredits, BorderLayout.CENTER);
        
        purchaseDetails.add(purchase, BorderLayout.SOUTH);
        
        add(purchaseDetails);
    }    
}