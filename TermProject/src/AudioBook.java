public class AudioBook extends Media
{
	private int chapters;

	public AudioBook()
	{
		super();
		chapters = 1;
	}

    public AudioBook(String titleIn, String authorIn, int rankIn, double costIn, String filename, int chaptersIn)
    {
        super(titleIn, authorIn, rankIn, costIn, filename);
        chapters = chaptersIn;
    }

    int getChapters()
    {
    	return chapters;
    }

    void setChapters(int chaptersIn)
    {
    	chapters = chaptersIn;
    }
}