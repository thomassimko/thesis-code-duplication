import java.io.PrintWriter;
import java.util.Calendar;


public class PartialExpense
		implements Expenses
{
	private String type;
	private Calendar date;
	private String category;
	private String paidTo;
	private int dollarAmnt;
	private int centAmnt;
	private int dollarRemaining;
	private int centRemaining;
	
	public PartialExpense(Calendar date, String category, String paidTo, String amount, String remaining)
	{
		this.date = date;
		this.category = category;
		this.paidTo = paidTo;
		this.type = "partial";
		for(int i = 0; i < amount.length(); i++)
		{
			if(amount.charAt(i) == '.')
			{
				 dollarAmnt = Integer.parseInt(amount.substring(0, i));
				 centAmnt = Integer.parseInt(amount.substring(i+1, amount.length()));
			}
		}
		for(int i = 0; i < remaining.length(); i++)
		{
			if(remaining.charAt(i) == '.')
			{
				 dollarRemaining = Integer.parseInt(remaining.substring(0, i));
				 centRemaining = Integer.parseInt(remaining.substring(i+1, remaining.length()));
			}
		}
		
	}
	
	public Calendar getDate() 
	{
		return date;
	}
	public String getCategory() 
	{
		return category;
	}
	public String getPaidTo() 
	{
		return paidTo;
	}
	public String getAmount() 
	{
		if(centAmnt <= 9)
			return dollarAmnt + "." + centAmnt+"0";
		else
			return dollarAmnt + "." + centAmnt;
	}
	public String getRemaining() 
	{
		if(centRemaining <= 9)
			return dollarRemaining + "." + centRemaining+ "0";
		else
			return dollarRemaining + "." + centRemaining+ "0";
	}
	public String getType() 
	{
		return type;
	}


	public void display() {
	
		System.out.println(String.format("%1$2tm/%<2td/%<tY ", this.date)
				+ String.format("%-15.15s %s (%s) [%s]",
				this.paidTo, getAmount(), getRemaining(), this.category));		
	}

	public int getdDollarAmnt() 
	{
		return dollarAmnt;
	}

	public int getCentAmnt() 
	{
		return centAmnt;
	}

	public int getDollarRemaining() 
	{
		return dollarRemaining;
	}

	public int getCentRemaining() 
	{
		return centRemaining;
	}

	public void save(PrintWriter writer) 
	{
		writer.println(this.type);
		writer.println(String.format("%1$2tm/%<2td/%<tY ", this.date));
		writer.println(this.category);
		writer.println(this.paidTo);
		writer.println(getAmount());
		writer.println(getRemaining());
	}

}
