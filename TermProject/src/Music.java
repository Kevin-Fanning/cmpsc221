public class Music extends Media
{
	private String genre; // to hold genre of each song

	// default constructor
	public Music()
	{
		super();
		genre = " ";
	}

	// init constructor
    public Music(String titleIn, String authorIn, int rankIn, double costIn, String filename, String genreIn)
    {
        super(titleIn, authorIn, rankIn, costIn, filename);
    	genre = genreIn;
    }

    // Accessor
    String getGenre()
    {
    	return genre;
    }

    // Set Method
    void setGenre(String genreIn)
    {
    	genre = genreIn;
    }

}