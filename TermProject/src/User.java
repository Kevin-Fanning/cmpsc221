
import java.util.ArrayList;

public class User
{
	protected final String username;
	protected String password;
        protected boolean isAdmin;
        protected double balance;
        protected ArrayList<Media> purchasedMedia;
	protected static int newName =1;

    // Default Constructor
	public User()	// default constructor
	{
		username = "User"+newName;
		newName++;
		password = "password";
                purchasedMedia = new ArrayList<>();
	}

	// Init Constructor
	public User(String username, String password, boolean isAdmin, double balance)	// init constructor
	{
		this.username = username;
                this.password = password;
                this.balance = balance;
                this.isAdmin = isAdmin;
                purchasedMedia = new ArrayList<>();
	}

        public String getUsername()
        {
            return username;
        }
        public String getPassword()
        {
            return password;
        }
        public boolean isAdmin()
        {
            return isAdmin;
        }
        public boolean addMediaToLibrary(Media media)
        {
            if (media.getCost() > balance)
            {
                return false;
            }
            for (int i = 0;i < purchasedMedia.size(); i++)
            {
                if (media.productID == purchasedMedia.get(i).productID)
                {
                    return false;
                }
            }
            purchasedMedia.add(media);
            balance -= media.getCost();
            return true;
        }
}