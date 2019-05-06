import java.util.Date;

public class InFull
	implements Payment
{
	private Paid paid;
	private String category;
	private Date date;
	private String payee;
	public InFull(Paid a, String cat, Date date, String payee)
	{
		this.paid = a;
		this.category = cat;
		this.date = date;
		this.payee = payee;
	}
	public String getType()
	{
		return "in-full";
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
		return new Paid(0, 0);
	}
	public String toString()
	{
		return String.format("%1$2tm/%<2td/%<tY ", this.date)
					+ String.format("%-15.15s %10s [%s]", payee, paid.toString(), category);
	}
}