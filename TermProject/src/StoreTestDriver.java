import java.util.LinkedList;

public class StoreTestDriver
{
    public static void main(String[] args)
    {
        MediaStore.Login("Kevin","nanana");
        MediaStore.addMedia(new Music("music111", "ffff", 3, 9.99));
        MediaStore.addMedia(new Music("music222", "ffff", 5, 11.99));
        MediaStore.addMedia(new AudioBook("book", "FDFDFD", 6, 8.57));
        LinkedList<Music> allMusic = MediaStore.listMusic();
        
        for (Music m : allMusic)
        {
            System.out.println(m.GetTitle());
        }
        System.out.println("-----------------All--------------------------");
        for (Media m : MediaStore.getAllMedia())
        {
            System.out.println(m.GetTitle());
        }
        System.out.println("----------------Books--------------------------");
        for (Media m : MediaStore.listAudioBooks())
        {
            System.out.println(m.GetTitle());
        }
    }
}