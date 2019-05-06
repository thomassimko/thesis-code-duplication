import java.util.Date;

public class inFullExpense implements expense 
{
	private String type;
	private Date date;
	private String category;
	private String paidTo;
	private int amountPaidDollars;
	private int amountPaidCents;
	
	public inFullExpense(String type, Date date, String category, String paidTo, int amountPaidDollars, int amountPaidCents)
	{
		this.type = type;
		this.date = date;
		this.category = category;
		this.paidTo = paidTo;
		this.amountPaidDollars = amountPaidDollars;
		this.amountPaidCents = amountPaidCents;
	}
	
	@Override
	public String getType() 
	{
		return type;
	}

	@Override
	public Date getDate() 
	{
		return date;
	}

	@Override
	public String getCategory() 
	{
		return category;
	}

	@Override
	public String getPaidTo() 
	{
		return paidTo;
	}

	@Override
	public int getAmountDollars() 
	{
		return amountPaidDollars;
	}
	
	public int getAmountCents()
	{
		return amountPaidCents;
	}

}
