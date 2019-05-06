import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Partial
implements Expenses
{
	private Calendar date;
	private String payee, cat;
	private int dollars, cents, dollars2, cents2;
	
	public Partial(Calendar d, int dol, int cent, String p, String category, int dol2, int cent2)
	{
		date = d;
		payee = p;
		cat = category;
		dollars = dol;
		cents = cent;
		dollars2 = dol2;
		cents2 = cent2;
	}
	public String getType()
	{
		return "partial";
	}
	public int getDollars()
	{
		return dollars;
	}
	public int getCents()
	{
		return cents;
	}
	public Calendar getDate()
	{
		return date;
	}
	public String getPayee()
	{
		return payee;
	}
	public String getAmountPaid()
	{
		return dollars + "." + cents ;
	}
	public String getCategory()
	{
		return cat;
	}
	public String getBalance()
	{
		return dollars2 + "." + cents2;
	}

	public void print()
	{
		System.out.println(String.format("%1$2tm/%<2td/%<tY ", date)
				+ String.format("%-15.15s %s (%s) [%s]", payee, getAmountPaid(), getBalance(), cat));
	}
}
