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
import javax.swing.JDialog;

/**
 * This class 
 * @author Kevin
 */
public class MediaStore {
    private static boolean isLoggedIn = false;//if someone is logged in
    private static User currentUser;
    public static boolean isAdmin = false; //is the logged in user an admin?
    
    //TODO: linkedList is temporary replacement for a database
    //private static LinkedList<Media> media = new LinkedList<>();
    private static ArrayList<Media> media = new ArrayList<>();
    
    //TODO: Replace with database of users
    private static ArrayList<User> users = new ArrayList<>();
    
    
    /**
     * Initializes the store with some test stuff
     */
    public static void Init()
    {
        User tom = new User("Tom", "password", true, 1000.0);
        User bill = new User("Bill", "password", false, 1000.0);
        User broke = new User("Broke", "password", false, 0.0);
        
        users.add(tom);
        users.add(bill);
        users.add(broke);
        
        MediaStore.addMedia(new Film("Star Wars", "George Lucas", 1, 10.99, 1974, "2:45:00", "Action"));
        MediaStore.addMedia(new Film("Lion King", "ZDisney", 2, 15.99, 1994,  "1:30:00", "Family"));
        MediaStore.addMedia(new Music("Take Me Out", "Franz Ferdinand", 4, 0.99, "Alt Rock", "3:00"));
        MediaStore.addMedia(new AudioBook("The Eye of the World", "Robert Jordan", 30, 4.99, 52, "45:00", "Adventure"));
    }
    
    /**
     * Logs in a user
     * @param username  the username of the user
     * @param password  the password of the user
     */
    public static boolean Login(String username, String password)
    {
        //TODO: Look up username in database and check it against password
        
        for (int i = 0; i < users.size(); i++)
        {
            if (username.equals(users.get(i).getUsername()))
            {
                if (users.get(i).getPassword().equals(password))
                {
                    isLoggedIn = true;
                    currentUser = users.get(i);
                    if (users.get(i).isAdmin()) 
                    { 
                        isAdmin = true; 
                    }
                    else
                    {
                        isAdmin = false;
                    }
                    return true;
                }
                else
                {
                    return false;
                }
            }
        }
        return false;
        
    }
    /**
     * logs out the user
     */
    public static void Logout()
    {
        currentUser = null;
        isLoggedIn = false;
    }
    public static User getUser()
    {
        return currentUser;
    }
    //TODO: Replace with database entry
    /**
     * adds media to the media library
     * @param newMedia  An object that extends the Media class to add to the library
     * @throws FileNotFoundException if the media file does not exist
     */
    public static void addMedia(Media newMedia)
    {
       media.add(newMedia);
    }
    
    public static void removeMedia(Media dMedia)
    {
        media.remove(dMedia);
    }
    
    //Getters --------------------------------------------------------------
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
    public static boolean purchaseProduct(int productID)
    {
        if (isLoggedIn && !isAdmin)
        {
            for (Media m : media)
            {
                if (m.getProductID() == productID)
                {
                    //Check user's credit and deduct if possible
                    //Show dialog if not
                    if (currentUser.addMediaToLibrary(m))
                    {
                        //Success!
                        m.setRank(m.getRank() + 1);
                        return true;
                    }
                    else
                    {
                        return false;
                    }
                }
            }
        }
        else
        {
            System.err.println("NOT LOGGED IN");
        }
        return false;
    }
}