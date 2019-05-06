public class Paid
{
	private int dollars;
	private int cents;
	public Paid(int dollars, int cents)
	{
		this.dollars = dollars;
		this.cents = cents;
	}
	public int getDollars()
	{
		return dollars;
	}
	public int getCents()
	{
		return cents;
	}
	public String toString()
	{
		if (cents==0)
		{
			return dollars+"."+cents+"0";
		}
		return dollars+"."+cents;
	}
}