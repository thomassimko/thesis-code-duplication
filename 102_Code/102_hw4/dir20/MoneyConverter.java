public class MoneyConverter
{
   private int cents;
	private int dollars;
	
	private String sCents;
	private String sDollars;
	
	public MoneyConverter(String amount)
	{
	  String [] splitting = amount.split("\\.");
     sCents = splitting[1];
	  sDollars = splitting[0];
     cents = Integer.parseInt(sCents);
     dollars = Integer.parseInt(sDollars);
	}
	
	public int getCents()
	{
	   return cents;
	}
	
	public int getDollars()
	{
	   return dollars;
	}
	
	
}