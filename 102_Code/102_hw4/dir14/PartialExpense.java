import java.util.*;
import java.text.*;

public class PartialExpense 
   implements Expense 
{
	private String category;
	private String paidTo;
	private Date currentDate;
	private String date;
	private int dollars;
	private int cents;
	private int remainingDollars;
	private int remainingCents;
	
	public PartialExpense(String category, String paidTo, String date, Date currentDate, int dollars, int cents, int remainingDollars, int remainingCents)
	{
		this.category = category;
		this.paidTo = paidTo;
		this.date = date;
		this.currentDate = currentDate;
		this.dollars = dollars;
		this.cents = cents;
		this.remainingDollars = remainingDollars;
		this.remainingCents = remainingCents;
	}
	
	public String getType()
	{
		return "partial";
	}
	
	public String getCategory()
	{
		return category;
	}
	
	public String getPaidTo()
	{
		return paidTo;
	}
	
	public Date getDate()
	{
		return currentDate;
	}
	
	public String stringDate()
	{
		String s = null;
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		try 
		{
			currentDate = dateFormat.parse(date);
		} 
		catch (ParseException e) 
		{
			
		}
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(currentDate);
		s = String.format("%1$2tm/%<2td/%<tY", currentDate);
		return s;
	}
	
	public int getDollars()
	{
		return dollars;
	}
	
	public int getCents()
	{
		return cents;
	}
	
	public String getAmount()
	{
		if(cents < 10)
		{
			return dollars + "." + cents + "0";
		}
		else
		{
			return dollars + "." + cents;
		}
	}
	
	public int getRemainingDollars()
	{
		return remainingDollars;
	}
	
	public int getRemainingCents()
	{
		return remainingCents;
	}
	
	public String getRemainingAmount()
	{
		if(remainingCents < 10)
		{
			return remainingDollars + "." + remainingCents + "0";
		}
		else
		{
			return remainingDollars + "." + remainingCents;
		}
	}
	
	public String toString()
	{
		return String.format("%1$2tm/%<2td/%<tY ", currentDate) + String.format("%-15.15s %10s (%s) [%s]", paidTo, getAmount(), getRemainingAmount(), category);
	}
}
