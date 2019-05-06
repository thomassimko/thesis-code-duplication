import java.util.Calendar;

public class PartialPayment implements Expense
{
	Calendar date;
	Money amount;
	String payee;
	String description;
	Money remaining;
	
	public PartialPayment(Calendar date, Money amount, String payee, String description, Money remaining)
	{
		this.date = date;
		this.amount = amount;
		this.payee = payee;
		this.description = description;
		this.remaining = remaining;
	}
	
	@Override
	public String getType()
	{
		return "partial";
	}
	
	@Override
	public Calendar getDate()
	{
		return this.date;
	}

	@Override
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
	public Money getRemaining()
	{
		return this.remaining;
	}

	@Override
	public int getRemainingDollars()
	{
		return this.remaining.getDollar();
	}

	@Override
	public int getRemainingCents()
	{
		return this.remaining.getCent();
	}

}
