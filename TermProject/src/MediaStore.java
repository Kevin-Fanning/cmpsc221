/**
 * name: Kevin Fanning
 * program: Term Project
 * date: 3/18/2013
 * section: 1
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.LinkedList;

/**
 * This class 
 * @author Kevin
 */
public class MediaStore {
    private static String username = "";    //currently logged in user
    private static String password = "";    //currently logged in user's pass
    private static boolean isLoggedIn = false;//if someone is logged in
    private static boolean isAdmin = false; //is the logged in user an admin?
    
    //TODO: linkedList is temporary replacement for a database
    //private static LinkedList<Media> media = new LinkedList<>();
    private static ArrayList<Media> media = new ArrayList<>();
    
    /**
     * Logs in a user
     * @param username  the username of the user
     * @param password  the password of the user
     */
    public static void Login(String username, String password)
    {
        //TODO: Look up username in database and check it against password
        MediaStore.username = username;
        MediaStore.password = password;
        isLoggedIn = true;
        if (username == "admin") { isAdmin = true; }
    }
    /**
     * logs out the user
     */
    public static void Logout()
    {
        username = "";
        password = "";
        isLoggedIn = false;
    }
    
    //TODO: Replace with database entry
    /**
     * adds media to the media library
     * @param newMedia  An object that extends the Media class to add to the library
     * @throws FileNotFoundException if the media file does not exist
     */
    public static void addMedia(Media newMedia) throws FileNotFoundException
    {
        if (new File(newMedia.getFilename()).isFile())
        {
            media.add(newMedia);
        }
        else
        {
            throw new FileNotFoundException(newMedia.getFilename() + ": file does not exist");
        }
    }
    
    //Getters --------------------------------------------------------------
    public static String getUsername()
    {
        return username;
    }
    public static ArrayList<Media> getAllMedia()
    {
        return media;
    }
    //These next three iterate over the list and pulls the ones with matching type
    //I tried to use generics, but I couldn't get it to work
    
    /**
     * Returns all media that is of type music in a list
     */
    public static ArrayList<Media> listMusic()
    {
        ArrayList<Media> result = new ArrayList<>();
        for (Media m : media)
        {
            if (m instanceof Music)
            {
                result.add(m);
            }
        }
        return result;
    }
    
    /**
     * Returns all media that is of type film in a list
     */
    public static ArrayList<Media> listFilms()
    {
        ArrayList<Media> result = new ArrayList<>();
        for (Media m : media)
        {
            if (m instanceof Film)
            {
                result.add(m);
            }
        }
        return result;
    }
    /**
     * Returns all media that is of type audiobook in a list
     */
    public static ArrayList<Media> listAudioBooks()
    {
        ArrayList<Media> result = new ArrayList<>();
        for (Media m : media)
        {
            if (m instanceof AudioBook)
            {
                result.add((AudioBook)m);
            }
        }
        return result;
    }
    
    /**
     * Finds a product in the library and transfers it to the user's computer at
     * the savePath
     * @param productID the ID of the product that will be purchased
     * @param savePath  the path where the purchased product will be saved
     * @throws IOException if the files could not be opened
     */
    public static void purchaseProduct(int productID, String savePath) throws IOException
    {
        if (isLoggedIn && !isAdmin)
        {
            for (Media m : media)
            {
                if (m.getProductID() == productID)
                {
                    File mediaFile = new File(m.getFilename());
                    File targetFile = new File(savePath);
                    Files.copy(mediaFile.toPath(), targetFile.toPath());
                    return;
                }
            }
        }
        else
        {
            System.err.println("NOT LOGGED IN");
        }
    }
}