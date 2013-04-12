/**
 * name: Kevin Fanning
 * program: Term Project
 * date: 2/18/2013
 * section: 1
 */

import java.awt.event.ActionListener;
import javax.swing.*;

class LoginPanel extends JPanel
{
    ActionListener parent;
    
    JTextField usernameField;
    JPasswordField passwordField;
    JLabel username;
    JLabel password;
    JButton submit;
    
    public LoginPanel(ActionListener parent)
    {
        super();
        username = new JLabel("Username");
        password = new JLabel("Password");
        
        usernameField = new JTextField(10);
        passwordField = new JPasswordField(10);
        
        submit = new JButton("Submit");
        submit.addActionListener(parent);
        
        add(username);
        add(usernameField);
        add(password);
        add(passwordField);
        add(submit);
    }
    
    public String getUsername()
    {
        return usernameField.getText();
    }
    public String getPassword()
    {
        return new String(passwordField.getPassword());
    }
}