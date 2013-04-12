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
	// default constructor
	public Music()
	{
		super();
	}

	// init constructor
    public Music(String titleIn, String authorIn, int rankIn, double costIn, String genreIn, String duration)
    {
        super(titleIn, authorIn, rankIn, costIn, duration, genreIn);
    }
}