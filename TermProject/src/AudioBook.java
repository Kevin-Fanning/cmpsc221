/** * 
Name: Jeff Dreyer 
* Section: 1 
* Program: Project Phase 1 
* Date: 2/18/2013 
* This File contains The AudioBook class which extends Media 
*/

/** 
* @author Jeff Dreyer
* @version 1.0 2/18/2013
* 
* The AudioBook class extends the Media Class and will hold data members inherited from Media 
* as well as its own data member for number of chapters within the book
*/
public class AudioBook extends Media
{
	private int chapters; // will hold the number of chapters in an instance of the audio book

	// default constructor
	public AudioBook()
	{
		super();
		chapters = 1;
	}

	// init constructor
    public AudioBook(String titleIn, String authorIn, int rankIn, double costIn, String filename, int chaptersIn)
    {
        super(titleIn, authorIn, rankIn, costIn, filename);
        chapters = chaptersIn;
    }

    // accessor method for chapter
    public int getChapters()
    {
    	return chapters;
    }

    // modifier method for chapters
    public void setChapters(int chaptersIn)
    {
    	chapters = chaptersIn;
    }
}