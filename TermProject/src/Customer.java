public class Customer extends User
{
	private Media[] PurchasedMedia;
	private float Balance;
	private final static int SIZE = 10;		// Initial size of PurchasedMedia array
	
	public Customer()
	{
		super();
		Balance = 0;
		PurchasedMedia = new Media[SIZE];
	}

	public Customer(String UserName_IN, String Pass_IN1, String Pass_IN2, float Balance_IN)	
	{
		super(UserName_IN,Pass_IN1,Pass_IN2);
		Balance = Balance_IN;
		PurchasedMedia = new Media[SIZE];
	}

	public void BuyMedia(Media m_IN)
	{
		// will probably use pointer or database location as function argument
		// will add selected media to Customers list of purchased media
		// will subtract cost of media from balance
		return;
	}	
}