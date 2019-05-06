public class Money
{
	private int dollars;
	private int cents;
	
	public Money(int dollars, int cents)
	{
		this.dollars = dollars;
		this.cents = cents;
	}
	
	public int getDollars()
	{
		return this.dollars;
	}
	
	public int getCents()
	{
		return this.cents;
	}

	public String toString()
	{
		if (cents == 0)
		{
			return dollars + ".00";
		}
		return this.dollars + "." + this.cents;
	}
	
	public int totalCents()
	{
		return this.dollars*100 + this.cents;
	}
}
