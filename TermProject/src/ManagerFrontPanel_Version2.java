/**
 * name: Jeff Dreyer
 * program: Term Project
 * date: 3/21/2013
 * section: 1
 */

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


class ManagerFrontPanel extends FrontPanel_Version2
{

	ManagerDetailsPanel panel_details;    //Panel containing details of the selected media
    
    public managerFrontPanel()
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
        super();

        if(e.getSource == RemoveMedia)
        {
            // remove current song
        }

        else if(e.getSource == CheckStats)
        {
            // check stats of current song
        }

        else if(e.getSource == AddMedia)
        {
            // add new media 
        }

        else if(e.getSource == CheckTotal)
        {
            // check total sales for current store
        }
    }   
    
}