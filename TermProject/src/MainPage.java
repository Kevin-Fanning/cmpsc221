
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;


class MainPage extends JFrame implements ActionListener
{ 
    JPanel currentPanel;
    StoreFrontPanel storeFront;
    ManagerFrontPanel managerPage;
    LoginPanel loginPanel;
    
    JMenuBar menuBar_notLoggedIn;
    JMenuItem mi_exit;
    JMenuBar menuBar_loggedIn;
    JMenuItem mi_exit2;
    JMenuItem mi_logout;
    
    public MainPage()
    {
        menuBar_notLoggedIn = new JMenuBar();
        JMenu menu_file_loggedIn = new JMenu("File");
        mi_exit = new JMenuItem("Exit");
        mi_exit.addActionListener(this);
        menu_file_loggedIn.add(mi_exit);
        menuBar_notLoggedIn.add(menu_file_loggedIn);
        setJMenuBar(menuBar_notLoggedIn);
        
        menuBar_loggedIn = new JMenuBar();
        mi_logout = new JMenuItem("Logout");
        mi_logout.addActionListener(this);
        mi_exit2 = new JMenuItem("Exit");
        mi_exit2.addActionListener(this);
        JMenu menu_file_loggedOut = new JMenu("File");
        menu_file_loggedOut.add(mi_logout);
        menu_file_loggedOut.add(mi_exit2);
        menuBar_loggedIn.add(menu_file_loggedOut);
        
        storeFront = new StoreFrontPanel();
        managerPage = new ManagerFrontPanel();
        loginPanel = new LoginPanel(this);
        
        currentPanel = loginPanel;
        
        storeFront.setPreferredSize(new Dimension(600, 500));
        this.add(loginPanel);
    }
    
    @Override
    public void actionPerformed(ActionEvent e)
    {
        //User clicked logout
        if (e.getSource() == mi_logout)
        {
            if (MediaStore.isAdmin)
            {
                remove(managerPage);
            }
            else
            {
                remove(storeFront);
            }
            MediaStore.Logout();
            setJMenuBar(menuBar_notLoggedIn);
            add(loginPanel);
            setVisible(true);
            repaint();
        }
        //user clicked exit
        else if (e.getSource() == mi_exit || e.getSource() == mi_exit2)
        {
            this.dispose();
        }
        //user clicked login
        else
        {
            if (MediaStore.Login(loginPanel.getUsername(), loginPanel.getPassword()))
            {
                this.setJMenuBar(menuBar_loggedIn);
                this.remove(loginPanel);
                if (MediaStore.isAdmin)
                {
                    this.add(managerPage);
                }
                else
                {
                    this.add(storeFront);
                }
                setVisible(true);
                repaint();
            }
        }
    }
    
    public static void main(String[] args)
    {
        MainPage app = new MainPage();
        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        app.setSize(620, 520);
        app.setVisible(true);
        
    }
}