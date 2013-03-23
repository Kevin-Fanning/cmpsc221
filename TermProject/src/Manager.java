// @author Jeff Dreyer
// @version 1.0 2/18/2013

public class Manager extends User
{
    public void AddMedia(Media m_IN)
    {
    	// add media to media database
    }
    public void RemoveMedia(Media m_IN)
    {
    	// will probably take in a pointer or database location
    	// remove specified from database
    }
    public int CheckMedia(Media m_IN)
    {
    	int sales = 0;
    	// checks the total sales of a specific piece of media
    	// will probably take in a pointer or database location
    	return sales;
    } 
    public int CheckTotal()
    {
    	int total = 0;
    	// checks total sales made by the store
    	return total;
    }	
}