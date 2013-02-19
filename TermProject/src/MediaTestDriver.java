// MediaTestDriver
import java.util.Vector;
public class MediaTestDriver
{
    public static void main(String[] args)
    {
    	String titleIn = "Hello"; 
    	String authorIn = "Test McAuthor"; 
    	int rankIn = 1;
    	double costIn = 0.99;
    	String filename = "1.mp3"; 
    	int chaptersIn = 10;
    	String genreInMovie = "Thriller";
    	String genreInMusic = "Electronica";
    	Vector<Object> testVector = new Vector<Object>();

    	Music test3 		= new Music();
    	Music test4 		= new Music(titleIn, authorIn, rankIn, costIn, filename, genreInMusic);
    	Film test5 			= new Film();
    	Film test6 			= new Film(titleIn, authorIn, rankIn, costIn, filename, genreInMovie);
    	AudioBook test7 	= new AudioBook();
    	AudioBook test8 	= new AudioBook(titleIn, authorIn, rankIn, costIn, filename, chaptersIn);
    	Album test9 		= new Album();
    	Album test0 		= new Album(titleIn, authorIn, rankIn, costIn, filename);
	    

        // Media Methods 
        System.out.printf("\n"+test4.getTitle());		

		System.out.printf(test4.getAuthor());	

		System.out.printf("%d\n",test4.getRank());
		
		System.out.printf("%.2f\n",test4.getCost());
		
	    System.out.printf("%d\n",test4.getProductID());
	      
	    System.out.printf("\n"+test4.getFilename());
	    
	    test3.setTitle(titleIn);		

		test3.setAuthor(authorIn);
		
		test3.setRank(rankIn);
		
		test3.setCost(costIn);

		// Music Methods
		System.out.printf("\n"+test4.getGenre());
		test3.setGenre("Metal");

		// Film Methods
		System.out.printf("\n"+test6.getGenre());
		test5.setGenre("Action");

		// AudioBook Methods
		System.out.printf("%d\n",test8.getChapters());
		test7.setChapters(19);

		// Album Methods
		test0.addMusic(test3);
		test0.addMusic(test4);

		System.out.printf("%d\n",test0.getAlbumSize());

		testVector = test0.getMusicIDs();

  	}

}