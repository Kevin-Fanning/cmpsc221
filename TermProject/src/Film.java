/** * 
Name: Jeff Dreyer 
* Section: 1 
* Program: Project Phase 1 
* Date: 2/18/2013 
* This File contains The Film class which extends Media 
*/

/** 
* @author Jeff Dreyer
* @version 1.0 2/18/2013
* 
* The Film class extends the Media Class and will hold data members inherited from Media 
* as well as its own data member for genre
*/
public class Film extends Media 
{
	private int releaseYear; 	// to hold genre of each film

	// default constructor
	public Film()
	{
		super();
		releaseYear = 1900;
	}

	// init constructor
    public Film(String titleIn, String authorIn, int rankIn, double costIn, int releaseYear, String duration, String genre)
    {
        super(titleIn, authorIn, rankIn, costIn, duration, genre);
    	this.releaseYear = releaseYear;
    }

    // Accessor for genre
    public int getReleaseYear()
    {
    	return releaseYear;
    }

    // Modifier Method for genre
    @Override
    public void setReleaseYear(int releaseYear)
    {
    	this.releaseYear = releaseYear;
    }

}