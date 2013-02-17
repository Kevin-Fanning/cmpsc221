// Media Super Class

public abstract class Media
{
	protected String title;		// title of media
	protected String author;	// author of media (same as artist for music)
	protected int rank;			// rank of media (for top 20 chart)
	protected double cost;		// cost of specific media type

	// Constructors------------------------------------------

	Media()	// default constructor
	{
		title = " ";
		author = " ";
		rank = -1;
		cost = 0.00;
	}

	Media(String titleIn, String authorIn, int rankIn, double costIn)	// init constructor
	{
		title = titleIn;
		author = authorIn;
		rank = rankIn;
		cost = costIn;
	}

	// Accessors----------------------------------------------

	String GetTitle()
	{
		return title;
	}

	String GetAuthor()
	{
		return author;
	}

	int GetRank()
	{
		return rank;
	}

	double GetCost()
	{
		return cost;
	}

	// Set Methods --------------------------------------------

	void SetTitle(String titleIn)
	{
		title = titleIn;
	}

	void SetAuthor(String authorIn)
	{
		title = authorIn;
	}

	void SetRank(int rankIn)
	{
		rank = rankIn;
	}

	void SetCost(double costIn)
	{
		cost = costIn;
	}

}