import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class InFull
implements Expenses
{
	private Calendar date;
	private String payee;
	private String cat;
	private int dollars, cents, dollars2, cents2;
	
	public InFull(Calendar d, int dol, int cent, String p, String category, int dol2, int cent2)
	{
		date = d;
		payee = p;
		dollars= dol;
		cents = cent;
		cat = category;
		dollars2 = dol2;
		cents2 = cent2;
	}
	public Calendar getDate()
	{
		return date;
	}
	public int getDollars()
	{
		return dollars;
	}
	public int getCents()
	{
		return cents;
	}
	public String getType()
	{
		return "in-full";
	}
	public String getPayee()
	{
		return payee;
	}
	public String getAmountPaid()
	{
		return dollars + "." + cents;
	}
	public String getCategory()
	{
		return cat;
	}
	public String getBalance()
	{
		return "0";
	}
	public void print()
	{
		System.out.println(String.format("%1$2tm/%<2td/%<tY ", date)
				+ String.format("%-15.15s %s [%s]", payee, getAmountPaid(), cat));
	}

}
