import java.util.Date;


public class inFull 
	implements Expense 
{
	private Date date;
	private int dollar;
	private int cent;
	private String payee;
	private String category;
	private String dateString;
	
	public inFull(String dateString, Date date, int dollar, int cent, String payee, String category)
	{
		this.date = date;
		this.dollar = dollar;
		this.cent = cent;
		this.payee = payee;
		this.category = category;
		this.dateString = dateString;
	}
	
	public String getStringDate()
	{
		return dateString;
	}
	
	public String getType()
	{
		String type = "in-full";
		return type;
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
	public int getDollarBal() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getCentBal() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String remainToString() 
	{
		// TODO Auto-generated method stub
		return null;
	}

}
