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

/**
 * This class is the GUI for the store front that the customer sees
 * @author Kevin
 */

class StoreFrontPanel_Version2 extends FrontPanel_Version2
{
    MediaDetailsPanel_Version2 panel_details;    //Panel containing details of the selected media
    
    public StoreFrontPanel_Version2()
    {
        super();
        
        //Details ------------------------------------------------------------
        panel_details = new MediaDetailsPanel_Version2(this);
        panel_details.setPreferredSize(new Dimension(300, 400));
        add(panel_details, BorderLayout.EAST);             
        
    }
    @Override
    public void actionPerformed(ActionEvent e)
    {
        super.actionPerformed(e);

        if(e.getSource() == panel_details.purchase)
        {
            MediaStore.purchaseProduct(panel_details.currentMedia.getProductID(),
                    "Downloads/" + panel_details.currentMedia.getFilename());
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