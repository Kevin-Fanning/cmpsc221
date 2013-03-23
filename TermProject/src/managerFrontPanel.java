/**
 * name: Jeff Dreyer
 * program: Term Project
 * date: 3/21/2013
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


class ManagerFrontPanel extends FrontPanel
{

	ManagerDetailsPanel panel_details;    //Panel containing details of the selected media
    
    public ManagerFrontPanel()
    {
        super();
        
        //Details ------------------------------------------------------------
        panel_details = new ManagerDetailsPanel(this);
        panel_details.setPreferredSize(new Dimension(300, 400));
        add(panel_details, BorderLayout.EAST);
        
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        super.actionPerformed(e);

        if(e.getSource() == panel_details.RemoveMedia)
        {
            // remove current song
        }

        else if(e.getSource() == panel_details.CheckStats)
        {
            // check stats of current song
        }

        else if(e.getSource() == panel_details.AddMedia)
        {
            // add new media 
        }

        else if(e.getSource() == panel_details.CheckTotal)
        {
            // check total sales for current store
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