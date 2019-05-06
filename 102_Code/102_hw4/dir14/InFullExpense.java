import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class InFullExpense 
   implements Expense 
{
	private String category;
	private String paidTo;
	private Date currentDate;
	private String date;
	private int dollars;
	private int cents;
	
	public InFullExpense(String category, String paidTo, String date, Date currentDate, int dollars, int cents)
	{
		this.category = category;
		this.paidTo = paidTo;
		this.date = date;
		this.currentDate = currentDate;
		this.dollars = dollars;
		this.cents = cents;
	}
	
	public String getType()
	{
		return "in-full";
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
	
	public String getRemainingAmount()
	{
		return "0.00";
	}
	
	public String toString()
	{
		return String.format("%1$2tm/%<2td/%<tY ", currentDate) + String.format("%-15.15s %10s [%s]", paidTo, getAmount(), category);
	}
}
