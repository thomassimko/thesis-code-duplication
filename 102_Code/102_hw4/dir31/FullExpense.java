import java.io.PrintWriter;
import java.util.Calendar;


public class FullExpense
		implements Expenses
{
	private String type;
	private Calendar date;
	private String category;
	private String paidTo;
	private int dollarAmnt;
	private int centAmnt;
	
	public FullExpense(Calendar date, String category, String paidTo, String amount)
	{
		this.date = date;
		this.category = category;
		this.paidTo = paidTo;
		this.type = "in-full";
		for(int i = 0; i < amount.length(); i++)
		{
			if(amount.charAt(i) == '.')
			{
				 dollarAmnt = Integer.parseInt(amount.substring(0, i));
				 centAmnt = Integer.parseInt(amount.substring(i+1, amount.length()));
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
		return "0.00";
	}
	public String getType() 
	{
		return type;
	}


	public void display() 
	{
		System.out.println(String.format("%1$2tm/%<2td/%<tY ", this.date)
				+ String.format("%-15.15s %s [%s]",
				this.paidTo, getAmount(), this.category));
	}


	public int getdDollarAmnt() 
	{
		return dollarAmnt;
	}

	public int getCentAmnt() {

		return centAmnt;
	}

	public int getDollarRemaining() 
	{	
		return 0;
	}


	public int getCentRemaining() 
	{
		return 0;
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