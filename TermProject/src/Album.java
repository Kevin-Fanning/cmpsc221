import java.util.Vector;

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

    // Accessor
    Vector<Object> getMusicIDs()
    {
    	return data;
    }

    int getAlbumSize()
    {
        return data.size();
    }

    // Set Method
    void addMusic(Music musicIn)
    {
    	data.add(musicIn.getProductID());
    }

}