import java.util.Calendar;
import java.util.Date;


public class InFullExpense implements Expense 
{
	private Calendar date;
	private int dollarAmount;
	private int centAmount;
	private String paidTo;
	private String category;
	private String type = "in-full";
	
	public InFullExpense(Calendar date, int dollarAmount, int centAmount, String paidTo, String category)
	{
		this.date = date;
		this.dollarAmount = dollarAmount;
		this.centAmount = centAmount;
		this.paidTo = paidTo;
		this.category = category;
	}

	public Calendar getDate() 
	{
		return date;
	}

	
	public int getDollarAmount() 
	{
		return dollarAmount;
	}

	
	public int getCentAmount() 
	{
		return centAmount;
	}

	
	public String getPaidTo() 
	{
		return paidTo;
	}

	
	public String getCategory() 
	{
		return category;
	}

	
	public int getRemainingDollar() 
	{
		throw new UnsupportedOperationException();
	}

	
	public int getRemainingCent() 
	{
		throw new UnsupportedOperationException();
	}

	
	public String getType() 
	{
		return type;
	}

	
	public String formatString() 
	{
		return String.format("%1$2tm/%<2td/%<tY ", date)
				+ String.format("%-15.15s %10s [%s]", paidTo, paidString(),  category);
	}
	
	public String paidString()
	{
		if (centAmount < 10)
		{
			return dollarAmount + "." + "0" + centAmount;
		}
		return "" + dollarAmount + "." + centAmount;
	}

	
	public String getDateString() 
	{
		return String.format("%1$2tm/%<2td/%<tY ", date);
	}

	
	public String remainingString() 
	{
		return "0.00";
	}
}
