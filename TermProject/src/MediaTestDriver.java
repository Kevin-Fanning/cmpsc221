/** * 
Name: Jeff Dreyer 
* Section: 1 
* Program: Project Phase 1 
* Date: 2/18/2013 
* This File contains a test driver for the Media class and its subclasses
*/

import java.util.Vector;
/** 
* @author Jeff Dreyer
* @version 1.0 2/18/2013
* 
* The MediaTestDriver class contains a main method to test the subclasses of the Media Superclass 
* as well as the inherited functions from the media super class
*/
public class MediaTestDriver
{
    public static void main(String[] args)
    {
    	// Local Variables for testing constructors and functions
    	String titleIn = "Hello"; 
    	String authorIn = "Test McAuthor"; 
    	int rankIn = 1;
    	double costIn = 0.99;
    	String filename = "1.mp3"; 
    	int chaptersIn = 10;
    	String genreInMovie = "Thriller";
    	String genreInMusic = "Electronica";
    	Vector<Object> testVector = new Vector<Object>();

    	// Default and init constructor testing for each subclass of Media
    	Music test3 		= new Music();
    	Music test4 		= new Music(titleIn, authorIn, rankIn, costIn, genreInMusic, "3:10");
    	Film test5 			= new Film();
    	//Film test6 			= new Film(titleIn, authorIn, rankIn, costIn, 1900, "1:30:00");
    	//AudioBook test7 	= new AudioBook();
    	//AudioBook test8 	= new AudioBook(titleIn, authorIn, rankIn, costIn, chaptersIn, "45:00");
    	//Album test9 		= new Album();
    	//Album test0 		= new Album(titleIn, authorIn, rankIn, costIn);
	    

        // Media Methods 
        System.out.printf("\n"+test4.getTitle());		

		System.out.printf("\n"+test4.getAuthor());	

		System.out.printf("\n%d",test4.getRank());
		
		System.out.printf("\n%.2f",test4.getCost());
		
	    System.out.printf("\n%d",test4.getProductID());
	      
	    
	    test3.setTitle(titleIn);		

		test3.setAuthor(authorIn);
		
		test3.setRank(rankIn);
		
		test3.setCost(costIn);

		System.out.printf("\n"+test3.getTitle());		

		System.out.printf("\n"+test3.getAuthor());	

		System.out.printf("\n%d",test3.getRank());
		
		System.out.printf("\n%.2f",test3.getCost());

		// Music Specific Methods
		System.out.printf("\n"+test3.getGenre());
		test3.setGenre("Metal");

		// Film Specific Methods
		//System.out.printf("\n"+test6.getGenre());
		//test5.setGenre("Action");

		// AudioBook Specific Methods
		//System.out.printf("\n%d",test8.getChapters());
		//test7.setChapters(19);

		// Album Specific Methods
		//test0.addMusic(test3);
		//test0.addMusic(test4);

		//System.out.printf("\n%d\n",test0.getAlbumSize());

		//testVector = test0.getMusicIDs();

  	}

}