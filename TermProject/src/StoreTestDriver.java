import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.LinkedList;

public class StoreTestDriver
{
    public static void main(String[] args)
    {
        MediaStore.Login("Kevin","nanana");
        
        MediaStore.addMedia(new Music("music111", "ffff", 3, 9.99, "aGenre", ""));
        MediaStore.addMedia(new Music("music222", "ffff", 5, 11.99,  "Genre2", ""));
        MediaStore.addMedia(new AudioBook("book", "FDFDFD", 6, 8.57,  4, "", ""));

        ArrayList<Media> allMusic = MediaStore.listMusic();
        
        for (Media m : allMusic)
        {
            System.out.println(m.getTitle());
        }
        System.out.println("-----------------All--------------------------");
        for (Media m : MediaStore.getAllMedia())
        {
            System.out.println(m.getTitle());
        }
        System.out.println("----------------Books--------------------------");
        for (Media m : MediaStore.listAudioBooks())
        {
            System.out.println(m.getTitle());
        }
        
        try {
            MediaStore.purchaseProduct(1);
        } catch (Exception e)
        {
            System.err.println("ERROR: could not copy files");
        }
    }
}