import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

 public class infullExpense 
	implements Expense
{
	private String date;
	private String category;
	private String paidTo;
	private String amount;
	private String remainingAmt;
	private int dollars;
	private int cents;
	
	public infullExpense(String date, String cat, 
						 String paidTo, String amount, String remaingAmt)
	{
		this.date = date;
		this.category = cat;
		this.paidTo = paidTo;
		this.amount = amount;
		this.remainingAmt = null;
		
		String[] splitAmt;
		
		splitAmt = amount.split("\\.");
		dollars = Integer.parseInt(splitAmt[0]);
		cents = Integer.parseInt(splitAmt[1]);
		
	}
	
	public Calendar makeDate()
	{
		String s = this.date;
		DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
		Date d = null; 
		try 
		{
			d = df.parse(s);
		} 
		catch (ParseException e) 
		{
			System.err.println("Parse error, yo.");
		}
		Calendar c = Calendar.getInstance();
		c.setTime(d);
		return c;
	}

	public String getDate() 
	{
		return this.date;
	}

	public String getCat() 
	{
		return this.category;
	}

	public String getPaidTo() 
	{
		return this.paidTo;
	}

	public String getAmount() 
	{
		return this.amount;
	}

	public String getBalance() 
	{
		return this.remainingAmt;
	}

	public int getDollars() 
	{
		return this.dollars;
	}

	public int getCents() 
	{
		return this.cents;
	}

	public String getType() 
	{
		return "in-full";
	}

}
