/** * 
Name: Jeff Dreyer 
* Section: 1 
* Program: Project Phase 1 
* Date: 2/18/2013 
* This File contains the Media Abstract class which will be used by its subclasses 
* (Music, Album, Film, and AudioBook)
*/

/** 
* @author Jeff Dreyer
* @version 1.0 2/18/2013
* 
* The Media class is an abstract class that will be the auper class for the Music, Album, Film, and AudioBook subclasses
*/
public abstract class Media
{
    protected static int numOfProducts = 0; // how many products exist. used for productID allocation
	protected String title;			// title of media
	protected String author;		// author of media (same as artist for music)
	protected int rank;				// rank of media (for top 20 chart)
	protected double cost;			// cost of specific media type
    protected int productID;        // unique identifier for media
    protected String filename;      // the location of the media file

	// Constructors------------------------------------------

    // Default Constructor
	public Media()	// default constructor
	{
		title = " ";
		author = " ";
		rank = -1;
		cost = 0.00;
                productID = ++numOfProducts;
	}

	// Init Constructor
	public Media(String titleIn, String authorIn, int rankIn, double costIn, String filename)	// init constructor
	{
		title = titleIn;
		author = authorIn;
		rank = rankIn;
		cost = costIn;
        this.filename = filename;
        productID = ++numOfProducts;
	}

	// Accessors----------------------------------------------

	// method that will return title data member
	public String getTitle()
	{
		return title;
	}

	// method that will return author data member
	public String getAuthor()
	{
		return author;
	}

	// method that will return rank data member
	public int getRank()
	{
		return rank;
	}

	// method that will return cost data member
	public double getCost()
	{
		return cost;
	}

	// method that will return productID data member
    public int getProductID()
    {
        return productID;
    }
    
    // method that will return filename data member    
    public String getFilename()
    {
        return filename;
    }
	// Set Methods --------------------------------------------

    // method that will set title data member
	public void setTitle(String titleIn)
	{
		title = titleIn;
	}

	// method that will set author data member
	public void setAuthor(String authorIn)
	{
		author = authorIn;
	}

	// method that will set rank data member
	public void setRank(int rankIn)
	{
		rank = rankIn;
	}

	// method that will set cost data member
	public void setCost(double costIn)
	{
		cost = costIn;
	}

        @Override
        public String toString()
        {
            return productID +"    " +  title + "    |    " + author;
        }
}