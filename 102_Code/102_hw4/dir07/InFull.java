import java.util.Date;


public class InFull 
	implements Expense
{
	private Date date;
	private String payee;
	private String category;
	private int paidDollars;
	private int paidCents;
	
	public InFull(Date date, String category, String payee, String paid)
	{
		this.date = date;
		this.payee = payee;
		this.category = category;
		
		int index = paid.indexOf(".");		
		this.paidDollars = Integer.parseInt(paid.substring(0, index));
		this.paidCents = Integer.parseInt(paid.substring(index+1));
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
		return 0;
	}

	@Override
	public int getRemainingCents()
	{
		return 0;
	}
	
	@Override
	public String toString()
	{
		return String.format("%1$2tm/%<2td/%<tY ", date)
				+ String.format("%-15.15s %s [%s]", payee, paidToString(), category);
	}
}
