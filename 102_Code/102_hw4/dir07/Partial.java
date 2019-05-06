import java.util.Date;

public class Partial 
	implements Expense
{
	private Date date;
	private String payee;
	private String category;
	private int paidDollars;
	private int paidCents;
	private int remainingDollars;
	private int remainingCents;
	
	public Partial(Date date, String category, String payee, String paid, String remaining)
	{
		this.date = date;
		this.payee = payee;
		this.category = category;
		
		int amountIndex = paid.indexOf(".");		
		this.paidDollars = Integer.parseInt(paid.substring(0, amountIndex));
		this.paidCents = Integer.parseInt(paid.substring(amountIndex+1));
		
		int amountRemainIndex = remaining.indexOf(".");
		this.remainingDollars = Integer.parseInt(remaining.substring(0, amountRemainIndex));
		this.remainingCents = Integer.parseInt(remaining.substring(amountRemainIndex+1));
	}

	@Override
	public Date getDate()
	{
		return date;
	}

	@Override
	public String getPayee()
	{
		return payee;
	}

	@Override
	public String getCategory()
	{
		return category;
	}

	@Override
	public int getPaidDollars()
	{
		return paidDollars;
	}
	
	@Override
	public int getPaidCents()
	{
		return paidCents;
	}
	
	public String paidToString()
	{
		return paidDollars + "." + paidCents;
	}
	
	@Override
	public int getRemainingDollars()
	{
		return remainingDollars;
	}

	@Override
	public int getRemainingCents()
	{
		return remainingCents;
	}
	
	public String remainingToString()
	{
		return remainingDollars + "." + remainingCents;
	}

	@Override
	public String toString()
	{
		return String.format("%1$2tm/%<2td/%<tY ", date) + String.format("%-15.15s %s (%s) [%s]",
				payee, paidToString(), remainingToString(), category);
	}
}
