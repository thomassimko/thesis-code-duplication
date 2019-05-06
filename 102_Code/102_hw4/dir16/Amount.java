import java.util.regex.PatternSyntaxException;

public class Amount
{
	private int dollars;
	private int cents;

	public Amount(int dollars, int cents)
	{
		this.dollars = dollars;
		this.cents = cents;
	}

	public static Amount parseAmount(String str)
		throws InvalidFormatException
	{
		int dollars, cents;

		try
		{
			String [] val = str.split("\\.");

			dollars = Integer.parseInt(val[0]);
			cents = Integer.parseInt(val[1]);
		}
		catch(Exception e)
		{
			throw new InvalidFormatException("Invalid Amount");
		}

		return new Amount(dollars, cents);
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
		return dollars + "." + String.format("%02d", cents);
	}
}