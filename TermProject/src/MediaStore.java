import java.util.LinkedList;

public class MediaStore {
    private static String username = "";
    private static String password = "";
    private static boolean isLoggedIn = false;
    
    //TODO: linkedList is temporary replacement for a database
    private static LinkedList<Media> media = new LinkedList<>();
    
    
    public static void Login(String username, String password)
    {
        //TODO: Look up username in database and check it against password
        MediaStore.username = username;
        MediaStore.password = password;
        isLoggedIn = true;
    }
    
    public static void Logout()
    {
        username = "";
        password = "";
        isLoggedIn = false;
    }
    
    //TODO: Replace with database entry
    public static void addMedia(Media newMedia)
    {
        media.add(newMedia);
    }
    
    //Getters --------------------------------------------------------------
    public static String getUsername()
    {
        return username;
    }
    public static LinkedList<Media> getAllMedia()
    {
        return media;
    }
    //These next three iterate over the list and pulls the ones with matching type
    //I tried to use generics, but I couldn't get it to work
    public static LinkedList<Music> listMusic()
    {
        LinkedList<Music> result = new LinkedList<>();
        for (Media m : media)
        {
            if (m instanceof Music)
            {
                result.add((Music)m);
            }
        }
        return result;
    }
    public static LinkedList<Film> listFilms()
    {
        LinkedList<Film> result = new LinkedList<>();
        for (Media m : media)
        {
            if (m instanceof Film)
            {
                result.add((Film)m);
            }
        }
        return result;
    }
    public static LinkedList<AudioBook> listAudioBooks()
    {
        LinkedList<AudioBook> result = new LinkedList<>();
        for (Media m : media)
        {
            if (m instanceof AudioBook)
            {
                result.add((AudioBook)m);
            }
        }
        return result;
    }
}