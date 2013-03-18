import javax.swing.*;

class MediaDetailsPanel extends JPanel
{
    JButton purchase;
    public MediaDetailsPanel()
    {
        super();
        purchase = new JButton("Purchase");
        add(purchase);
    }
}