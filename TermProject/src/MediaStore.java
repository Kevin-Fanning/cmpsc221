/**
 * name: Kevin Fanning
 * program: Term Project
 * date: 3/18/2013
 * section: 1
 */
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.sql.*;

/**
 * This class 
 * @author Kevin
 */
public class MediaStore {
    private static boolean isLoggedIn = false;//if someone is logged in
    private static User currentUser;
    public static boolean isAdmin = false; //is the logged in user an admin?
    
    private static Connection dbConnection;
    
    //TODO: linkedList is temporary replacement for a database
    //private static LinkedList<Media> media = new LinkedList<>();
    private static ArrayList<Media> media = new ArrayList<>();
    
    /**
     * Initializes the store with some test stuff
     */
    public static void Init()
    {
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance(); 
            dbConnection = DriverManager.getConnection("jdbc:derby://localhost:1527/cmpsc221", "Tom", "password");
            
            Statement statement = dbConnection.createStatement();
            ResultSet rs = statement.executeQuery("select count(*) number from MEDIA");
            rs.next();
            Media.numOfProducts = rs.getInt("number") + 1;
        }
        catch (ClassNotFoundException | InstantiationException | IllegalAccessException | SQLException e)
        {
            System.out.println("Error connecting to database");
        }
    }
    
    /**
     * Logs in a user
     * @param username  the username of the user
     * @param password  the password of the user
     */
    public static boolean Login(String username, String password)
    {
        //TODO: Look up username in database and check it against password
        try 
        {
            Statement statement = dbConnection.createStatement();
            ResultSet results = statement.executeQuery("select * from USERS where USERNAME = \'" + username + "\'");
            
            if (results.next())
            {
                String pass = results.getString("PASSWORD");
            
                if (pass.equals(password))
                {
                    isLoggedIn = true;
                    currentUser = new User(username, password, results.getBoolean("ISADMIN"), results.getDouble("BALANCE"));
                    if (currentUser.isAdmin()) 
                    { 
                        isAdmin = true; 
                    }
                    else
                    {
                        isAdmin = false;
                    }
                    statement.close();
                    results.close();
                    return true;
                }

                statement.close();
                results.close();
            }
        }
        catch (SQLException e)
        {
            System.out.println(e.getMessage());
            return false;
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
       try
       {
            Statement statement = dbConnection.createStatement();
            
            String type = "";
            if (newMedia instanceof Film)
            {
                type = "FILM";
            }
            else if (newMedia instanceof Music)
            {
                type = "MUSIC";
            }
            else if (newMedia instanceof AudioBook)
            {
                type = "AUDIOBOO";
            }
            String sql = String.format("insert into MEDIA (ID, TYPE, TITLE, AUTHOR, DURATION, RANK, COST, GENRE, RELEASEYEAR) values" + 
                    "(%d, \'%s\', \'%s\', \'%s\', \'%s\', %d, %f, \'%s\', %d)",
                    newMedia.productID,type,newMedia.getTitle(),newMedia.getAuthor(),newMedia.getDuration(),newMedia.getRank(),
                    newMedia.getCost(),newMedia.getGenre(),newMedia.getReleaseYear());
            
            System.out.println(sql);
            statement.execute(sql);
            Media.numOfProducts++;
            statement.close();
       }
       catch (SQLException e)
       {
           System.out.println(e.getMessage());
       }
    }
    
    public static void removeMedia(Media dMedia)
    {
        //media.remove(dMedia);
        
        try 
        {
            Statement statement = dbConnection.createStatement();
            
            statement.execute("delete from MEDIA where ID = " + dMedia.productID);
        
            statement.close();
        }
        catch (SQLException e)
        {
            System.out.println("Delete Failed");
        }
        
    }
    
    //Getters --------------------------------------------------------------
    public static ArrayList<Media> getAllMedia()
    {
        //return media;
        media.clear();
        try
        {
            Statement statement = dbConnection.createStatement();
            ResultSet rs = statement.executeQuery("select * from MEDIA");
            
            while (rs.next())
            {
                Media newMedia = new Music();
                String type = rs.getString("TYPE");
                switch (type) {
                    case "FILM":
                        newMedia = new Film();
                        break;
                    case "MUSIC":
                        newMedia = new Music();
                        break;
                    case "AUDIOBOO":
                        newMedia = new AudioBook();
                        break;
                }
                
                newMedia.setTitle(rs.getString("TITLE"));
                newMedia.setAuthor(rs.getString("AUTHOR"));
                newMedia.setDuration(rs.getString("DURATION"));
                newMedia.setCost(rs.getDouble("COST"));
                newMedia.setGenre(rs.getString("GENRE"));
                newMedia.setRank(rs.getInt("RANK"));
                newMedia.setReleaseYear(rs.getInt("RELEASEYEAR"));
                newMedia.productID = rs.getInt("ID");
                
                media.add(newMedia);
            }
        }
        catch (SQLException e)
        {
            System.out.println(e.getMessage());
        }
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
        media = getAllMedia();
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
        media = getAllMedia();
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
        media = getAllMedia();
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
            try 
            {
                Statement statement = dbConnection.createStatement();
                ResultSet rs = statement.executeQuery("select * from MEDIA where ID = " + productID);
                
                if (rs.next())
                {
                    double cost = rs.getDouble("COST");
                    if (cost < currentUser.balance)
                    {
                        ResultSet isowned = statement.executeQuery("select MEDIA_ID from OWNERS where MEDIA_ID = " + productID);
                        if (isowned.next())
                        {
                            isowned.close();
                            rs.close();
                            statement.close();
                            return false;
                        }
                        statement.execute("insert into OWNERS (OWNER, MEDIA_ID) values (\'" +
                                currentUser.username + "\', " + productID + ")");
                        statement.execute("update MEDIA set RANK = RANK + 1 where ID = " + productID);
                        
                        currentUser.balance -= cost;
                        statement.execute("update USERS set BALANCE = BALANCE - " + cost + "where USERNAME = \'" +
                                currentUser.getUsername() + "\'");
                        
                        statement.close();
                        rs.close();
                        return true;
                    }
                    else
                    {
                        statement.close();
                        rs.close();
                        return false;
                    }
                }
                else
                {
                    statement.close();
                    rs.close();
                    return false;
                }
            }
            catch (SQLException e)
            {
                System.out.println(e.getMessage());
            }
        }
        else
        {
            System.err.println("NOT LOGGED IN");
        }
        return false;
    }
    
    public static ArrayList<Media> getUsersMedia()
    {
        ArrayList<Media> result = new ArrayList<>();
        
        try 
        {
            Statement statement = dbConnection.createStatement();
            ResultSet rs = statement.executeQuery("select MEDIA_ID from OWNERS where OWNER = \'" + currentUser.getUsername() + "\'");
            
            while(rs.next())
            {
                Statement mediaStatement = dbConnection.createStatement();
                ResultSet mediaResult = mediaStatement.executeQuery("select * from MEDIA where ID = " + rs.getInt("MEDIA_ID"));
                Media newMedia = new Music();
                mediaResult.next();
                String type = mediaResult.getString("TYPE");
                switch (type) {
                    case "FILM":
                        newMedia = new Film();
                        break;
                    case "MUSIC":
                        newMedia = new Music();
                        break;
                    case "AUDIOBOO":
                        newMedia = new AudioBook();
                        break;
                }
                
                newMedia.setTitle(mediaResult.getString("TITLE"));
                newMedia.setAuthor(mediaResult.getString("AUTHOR"));
                newMedia.setDuration(mediaResult.getString("DURATION"));
                newMedia.setCost(mediaResult.getDouble("COST"));
                newMedia.setGenre(mediaResult.getString("GENRE"));
                newMedia.setRank(mediaResult.getInt("RANK"));
                newMedia.setReleaseYear(mediaResult.getInt("RELEASEYEAR"));
                newMedia.productID = mediaResult.getInt("ID");
                
                result.add(newMedia);
                
                mediaStatement.close();
                mediaResult.close();
            }
        }
        catch (SQLException e)
        {
            System.out.println(e.getMessage());
        }
        return result;
    }
}