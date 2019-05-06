import java.util.Calendar;
import java.util.Date;


public class PartialExpense implements Expense 
{
	private Calendar date;
	private int dollarAmount;
	private int centAmount;
	private String paidTo;
	private String category;
	private int remainingDollar;
	private int remainingCent;
	private String type = "partial";
	
	public PartialExpense(Calendar date, int dollarAmount, int centAmount, String paidTo, String category,
							int remainingDollar, int remainingCent)
	{
		this.date = date;
		this.dollarAmount = dollarAmount;
		this.centAmount = centAmount;
		this.paidTo = paidTo;
		this.category = category;
		this.remainingDollar = remainingDollar;
		this.remainingCent = remainingCent;
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
		return remainingDollar;
	}

	
	public int getRemainingCent() 
	{
		return remainingCent;
	}


	
	public String getType() 
	{
		return type;
	}


	
	public String formatString() 
	{
		return String.format("%1$2tm/%<2td/%<tY ", date)
				+ String.format("%-15.15s %10s (%s) [%s]",
				paidTo, paidString(), remainingString(), category);
	}
	
	public String paidString()
	{
		if (centAmount < 10)
		{
			return dollarAmount + "." + "0" + centAmount;
		}
		return "" + dollarAmount + "." + centAmount;
	}
	
	public String remainingString()
	{
		if (remainingCent < 10)
		{
			return remainingDollar + "." + "0" + remainingCent;
		}
		return remainingDollar + "." + remainingCent;
	}

	public String getDateString() 
	{
		return String.format("%1$2tm/%<2td/%<tY ", date);
	}

}
