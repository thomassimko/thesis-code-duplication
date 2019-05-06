import java.util.Date;


public class partial 
	implements Expense 
{
	private Date date;
	private int dollar;
	private int cent;
	private String payee;
	private String category;
	private int dollarBal;
	private int centBal;
	private String dateString;
	
	public partial(String dateString, Date date, int dollar, int cent, String payee, String category, int dollarBal, int centBal)
	{
		this.date = date;
		this.dollar = dollar;
		this.cent = cent;
		this.payee = payee;
		this.category = category;
		this.dollarBal = dollarBal;
		this.centBal = centBal;
		this.dateString = dateString;
	}
	
	public String getType()
	{
		String type = "partial";
		return type;
	}
	
	public String getStringDate()
	{
		return dateString;
	}
	
	public Date getDate() 
	{
		return date;
	}

	@Override
	public int getDollar() 
	{
		return dollar;
	}

	@Override
	public int getCent() 
	{
		return cent;
	}
	
	public String paidToString()
	{
		if(cent == 0)
		{
			return dollar + "." + "00";
		}
		else if(cent<10 && cent>0)
		{
			return dollar + "." + "0"+cent;
		}
		return dollar + "." + cent;
	}

	@Override
	public String getPayee() 
	{
		return payee;
	}

	@Override
	public String getCat() 
	{
		return category;
	}

	@Override
	public int getDollarBal() 
	{
		return dollarBal;
	}

	@Override
	public int getCentBal() 
	{
		return centBal;
	}
	
	public String remainToString()
	{
		if(centBal == 0)
		{
			return dollarBal + "." + "00";
		}
		else if(centBal<10 && centBal>0)
		{
			return dollarBal + "." + "0"+centBal;
		}
		return dollarBal + "." + centBal;
	}

}
