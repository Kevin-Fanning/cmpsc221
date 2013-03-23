public abstract class User
{
	protected final String UserName;
	protected String Password;
	protected static int newName =1;

    // Default Constructor
	public User()	// default constructor
	{
		UserName = "User"+newName;
		newName++;
		Password = "password";
	}

	// Init Constructor
	public User(String UserName_IN, String Pass_IN1, String Pass_IN2)	// init constructor
	{
		UserName = UserName_IN;
		if(Pass_IN1==Pass_IN2)
			Password = Pass_IN1;
		//else
			//error
	}

	public void ChangePassWord(String Password_IN)
	{
		if(Password_IN == Password)
			Password = Password_IN;
		return;
	}	
}