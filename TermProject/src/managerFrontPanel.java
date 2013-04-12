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
        NewMediaDialog nw;
        Media editing;
    public ManagerFrontPanel()
    {
        super();
        nw = new NewMediaDialog((JFrame)SwingUtilities.getRoot(this));
        nw.setSize(400,400);
        nw.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
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
            MediaStore.removeMedia(panel_details.currentMedia);
            int total = 0;
                    for (int i = 0; i < MediaStore.getAllMedia().size(); i++)
                    {
                        total += MediaStore.getAllMedia().get(i).getRank();
                    }
                    panel_details.tf_totalSold.setText(new Integer(total).toString());
        }
        else if(e.getSource() == panel_details.AddMedia)
        {
            // add new media 
            
            nw.setVisible(true);
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