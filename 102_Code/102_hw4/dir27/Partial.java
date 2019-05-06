import java.util.Date;
	
public class Partial
	implements Payment
{
	private Paid paid, remaining;
	private String category;
	private Date date;
	private String payee;
	public Partial(Paid a, String cat, Date date, String payee, Paid remaining)
	{
		this.paid = a;
		this.category = cat;
		this.date = date;
		this.payee = payee;
		this.remaining = remaining;
	}
	public String getType()
	{
		return "partial";
	}
	public Date getDate()
	{
		return this.date;		
	}
	public Paid getPay()
	{
		return this.paid;
	}
	public String getPayee()
	{
		return this.payee;
	}
	public String getCategory()
	{
		return this.category;
	}
	public Paid getRemaining()
	{
		return this.remaining;
	}
	public String toString()
	{
		return String.format("%1$2tm/%<2td/%<tY ", date)
			+ String.format("%-15.15s %10s (%s) [%s]",
				payee, paid.toString(), remaining.toString(), category);
	}
}