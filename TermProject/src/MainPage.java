
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;


class MainPage extends JFrame
{ 
    StoreFrontPanel storeFront;
    
    JMenuBar menuBar_notLoggedIn;
    JMenuBar menuBar_loggedIn;
    
    public MainPage()
    {
        menuBar_notLoggedIn = new JMenuBar();
        JMenu menu_file_loggedIn = new JMenu("File");
        JMenuItem mi_exit = new JMenuItem("Exit");
        menu_file_loggedIn.add(mi_exit);
        menuBar_notLoggedIn.add(menu_file_loggedIn);
        setJMenuBar(menuBar_notLoggedIn);
        
        menuBar_loggedIn = new JMenuBar();
        JMenuItem mi_logout = new JMenuItem("Logout");
        JMenuItem mi_exit2 = new JMenuItem("Exit");
        JMenu menu_file_loggedOut = new JMenu("File");
        menu_file_loggedOut.add(mi_logout);
        menu_file_loggedOut.add(mi_exit2);
        menuBar_loggedIn.add(menu_file_loggedOut);
        
        storeFront = new StoreFrontPanel();
        storeFront.setPreferredSize(new Dimension(600, 100));
        this.add(storeFront);
    }
    
    public static void main(String[] args)
    {
        MainPage app = new MainPage();
        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        app.setSize(600, 500);
        app.setVisible(true);
        
    }
}