/** * 
Name: Jeff Dreyer 
* Section: 1 
* Program: Project Phase 1 
* Date: 2/18/2013 
* This File contains The Music class which extends Media  
*/

/** 
* @author Jeff Dreyer
* @version 1.0 2/18/2013
* 
* The Music class extends the Media Class and will hold data members inherited from Media 
* as well as its own data member for genre
*/
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

    // Accessor for genre
    public String getGenre()
    {
    	return genre;
    }

    // Modifier Method for genre
    public void setGenre(String genreIn)
    {
    	genre = genreIn;
    }

}