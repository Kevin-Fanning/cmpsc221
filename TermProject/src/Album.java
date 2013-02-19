/** * 
Name: Jeff Dreyer 
* Section: 1 
* Program: Project Phase 1 
* Date: 2/18/2013 
* This File contains The Album class which extends Media and contains music productIDs 
*/

import java.util.Vector;

/** 
* @author Jeff Dreyer
* @version 1.0 2/18/2013
* 
* The Album class extends the Media Class and is a container for Music productIDs
* even though it is a container class it does have its own unique data types and 
* inherits data types from the Media super class
*/
public class Album extends Media
{
	private Vector<Object> data; // to hold the music productIds within each album
	
	// default constructor
    public Album()
    {
        super();
        data = new Vector<Object>();    
    }

    // init constructor
    public Album(String titleIn, String authorIn, int rankIn, double costIn, String filename)
    {
        super(titleIn, authorIn, rankIn, costIn, filename);
        data = new Vector<Object>();
    }

    // Accessor for data variable
    public Vector<Object> getMusicIDs()
    {
    	return data;
    }

    // Accessor for size of Album, which will be computed within the method
    public int getAlbumSize()
    {
        return data.size();
    }

    // Modifier method for data, will append a Music productID to the data Vector
    public void addMusic(Music musicIn)
    {
    	data.add(musicIn.getProductID());
    }

}