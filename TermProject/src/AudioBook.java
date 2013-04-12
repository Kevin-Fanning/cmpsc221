/** * 
Name: Jeff Dreyer 
* Kevin Fanning
* Section: 1 
* Program: Project Phase 1 
* Date: 2/18/2013 
* This File contains The AudioBook class which extends Media 
*/

/** 
* @author Jeff Dreyer
* Kevin Fanning
* @version 1.0 2/18/2013
* 
* The AudioBook class extends the Media Class and will hold data members inherited from Media 
* as well as its own data member for number of chapters within the book
*/
public class AudioBook extends Media
{
    public AudioBook()
    {
        super("", "", 0, 0, "", "");
    }
	// init constructor
    public AudioBook(String titleIn, String authorIn, int rankIn, double costIn, int chaptersIn, String duration, String genre)
    {
        super(titleIn, authorIn, rankIn, costIn, duration, genre);
    }
}