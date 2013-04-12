/**
 * name: Kevin Fanning
 * program: Term Project
 * date: 3/18/2013
 * section: 1
 */

// compiles no errors

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputMethodEvent;
import java.awt.event.InputMethodListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.text.DecimalFormat;

/**
 * This class is the GUI for the store front that the customer sees
 * @author Kevin
 */

class StoreFrontPanel extends FrontPanel
{
    MediaDetailsPanel panel_details;    //Panel containing details of the selected media
    
    public StoreFrontPanel()
    {
        super();
        
        //Details ------------------------------------------------------------
        panel_details = new MediaDetailsPanel(this);
        panel_details.setPreferredSize(new Dimension(300, 400));
        add(panel_details, BorderLayout.EAST);             
        
    }
    @Override
    public void actionPerformed(ActionEvent e)
    {
        super.actionPerformed(e);

        if(e.getSource() == panel_details.purchase)
        {
            if (MediaStore.purchaseProduct(panel_details.currentMedia.getProductID()))
            {
                DecimalFormat df = new DecimalFormat("####.##");
                panel_details.currentCredits.setText(df.format(MediaStore.getUser().balance));
                JOptionPane.showMessageDialog(this, panel_details.currentMedia.getTitle() + " was successfully purchased.");
            }
            else
            {
                JOptionPane.showMessageDialog(this, "You either don't have enough money, or you already own this.");
            }
        }
    }

    @Override
    public void valueChanged(ListSelectionEvent e)
    {
        if (e.getValueIsAdjusting())
        {
            if (panel_results.productList.getSelectedIndex() != -1)
            {
                panel_details.setMedia((Media)panel_results.productList.getSelectedValue());
            }
        }
    }
    
}