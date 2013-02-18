// Media Super Class

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

	public Media()	// default constructor
	{
		title = " ";
		author = " ";
		rank = -1;
		cost = 0.00;
                productID = ++numOfProducts;
	}

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

	public String getTitle()
	{
		return title;
	}

	public String getAuthor()
	{
		return author;
	}

	public int getRank()
	{
		return rank;
	}

	public double getCost()
	{
		return cost;
	}

    public int getProductID()
    {
        return productID;
    }
        
    public String getFilename()
    {
        return filename;
    }
	// Set Methods --------------------------------------------

	public void setTitle(String titleIn)
	{
		title = titleIn;
	}

	public void setAuthor(String authorIn)
	{
		title = authorIn;
	}

	public void setRank(int rankIn)
	{
		rank = rankIn;
	}

	public void setCost(double costIn)
	{
		cost = costIn;
	}

}