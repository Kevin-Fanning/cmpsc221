// Media Super Class

public abstract class Media
{
	protected String title;		// title of media
	protected String author;	// author of media (same as artist for music)
	protected int rank;			// rank of media (for top 20 chart)
	protected double cost;		// cost of specific media type

	// Constructors------------------------------------------

	public Media()	// default constructor
	{
		title = " ";
		author = " ";
		rank = -1;
		cost = 0.00;
	}

	public Media(String titleIn, String authorIn, int rankIn, double costIn)	// init constructor
	{
		title = titleIn;
		author = authorIn;
		rank = rankIn;
		cost = costIn;
	}

	// Accessors----------------------------------------------

	public String GetTitle()
	{
		return title;
	}

	public String GetAuthor()
	{
		return author;
	}

	public int GetRank()
	{
		return rank;
	}

	public double GetCost()
	{
		return cost;
	}

	// Set Methods --------------------------------------------

	public void SetTitle(String titleIn)
	{
		title = titleIn;
	}

	public void SetAuthor(String authorIn)
	{
		title = authorIn;
	}

	public void SetRank(int rankIn)
	{
		rank = rankIn;
	}

	public void SetCost(double costIn)
	{
		cost = costIn;
	}

}