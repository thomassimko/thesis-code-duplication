import java.util.Date;

public class partialExpense implements expense 
{
	private String type;
	private Date date;
	private String category;
	private String paidTo;
	private int amountPaidDollars;
	private int amountPaidCents;
	private int amountRemainingDollars;
	private int amountRemainingCents;
	
	public partialExpense(String type, Date date, String category, String paidTo, int amountPaidDollars, int amountPaidCents,
			int amountRemainingDollars, int amountRemainingCents)
	{
		this.type = type;
		this.date = date;
		this.category = category;
		this.paidTo = paidTo;
		this.amountPaidDollars = amountPaidDollars;
		this.amountPaidCents = amountPaidCents;
		this.amountRemainingDollars = amountRemainingDollars;
		this.amountRemainingCents = amountRemainingCents;
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

	public int getRemainingDollars()
	{
		return amountRemainingDollars;
	}
	
	public int getRemainingCents()
	{
		return amountRemainingCents;
	}
}
