import java.util.*;

public abstract class Expense
{
	private String type;
	private Calendar date;
	private String category;
	private String payee;
	private Amount paid;
	private Amount remaining;

	public Expense(String type, Calendar date, String category, String payee, Amount paid, Amount remaining)
	{
		this.type = type;
		this.date = date;
		this.category = category;
		this.payee = payee;
		this.paid = paid;
		this.remaining = remaining;
	}

	public String getType()
	{
		return type;
	}

	public Calendar getDate()
	{
		return date;
	}

	public String getDateString()
	{
		return String.format("%1$2tm/%<2td/%<tY ", date);
	}

	public String getCategory()
	{
		return category;
	}

	public String getPayee()
	{
		return payee;
	}

	public Amount getPaid()
	{
		return paid;
	}

	public String getPaidString()
	{
		return paid.toString();
	}

	public Amount getRemaining()
	{
		return remaining;
	}

	public String getRemainingString()
	{
		return remaining.toString();
	}

	public abstract String toString();
}