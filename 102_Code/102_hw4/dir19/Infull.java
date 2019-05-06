import java.util.Date;
import java.util.Calendar;
public class Infull
	implements Expense
{
	private Calendar date;
	private Money money;
	private String paidTo;
	private String desc;

	public Infull(Calendar date, Money money, String paidTo, String desc)
	{
		this.date = date;
		this.money = money;
		this.paidTo = paidTo;
		this.desc = desc;
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
		Money myMoney = new Money(0,0);
		return myMoney.toString();
	}
	
	public String print()
	{
		return String.format("%1$2tm/%<2td/%<tY ", date)
		+ String.format("%-15.15s %s [%s]", paidTo, money.toString(), desc);
	}
}
