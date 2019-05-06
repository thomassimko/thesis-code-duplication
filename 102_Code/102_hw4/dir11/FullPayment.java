import java.util.Calendar;

public class FullPayment implements Expense
{
	Calendar date;
  Money amount;
	String payee;
	String description;
	
	public FullPayment(Calendar date, Money amount, String payee, String description)
	{
		this.date = date;
		this.amount = amount;
		this.payee = payee;
		this.description = description;
	}
	
	@Override
	public String getType()
	{
		return "in-full";
	}
	
	@Override
	public Calendar getDate()
	{
		return this.date;
	}
	
	public Money getAmount()
	{
		return this.amount;
	}

	@Override
	public int getAmountDollars()
	{
		return this.amount.getDollar();
	}

	@Override
	public int getAmountCents()
	{
		return this.amount.getCent();
	}

	@Override
	public String getPayee()
	{
		return this.payee;
	}

	@Override
	public String getDescription()
	{
		return this.description;
	}

	@Override
	public int getRemainingDollars()
	{
		throw new UnsupportedOperationException();
	}

	@Override
	public int getRemainingCents()
	{
		throw new UnsupportedOperationException();
	}

	@Override
	public Money getRemaining()
	{
		throw new UnsupportedOperationException();
	}

}
