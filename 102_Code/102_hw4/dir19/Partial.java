import java.util.Date;
import java.util.Calendar;
public class Partial
	implements Expense
{
	private Calendar date;
	private Money money;
	private String paidTo;
	private String desc;
	private Money remain;

	public Partial(Calendar date, Money money, String paidTo, String desc, Money remain)
	{
		this.date = date;
		this.money = money;
		this.paidTo = paidTo;
		this.desc = desc;
		this.remain = remain;
	}
	
	public Calendar getDate()
	{
		return this.date;
	}
	
	public String paidAmount()
	{
		return this.money.toString();
	}
		
	public String paidTo()
	{
		return this.paidTo;
	}
	
	public String getDesc()
	{
		return this.desc;
	}

	public Money paidMoney()
	{
		return this.money;
	}
	
	public String getBal()
	{
		return this.remain.toString();
	}
	
	public String print()
	{
		return String.format("%1$2tm/%<2td/%<tY ", date)
		+ String.format("%-15.15s %s (%s) [%s]",
		paidTo, money.toString(), remain.toString(), desc);
	}
}
