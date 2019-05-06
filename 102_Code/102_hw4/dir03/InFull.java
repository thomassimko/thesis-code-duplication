//import java.text.*;
import java.util.*;

public class InFull 
implements Expenses
{
	Calendar date;
	String payee;
	String category;
	int amtDollars, amtCents;

    public InFull(Calendar date, int amtDollars, int amtCents, String payee, String category)
    {
        this.date=date;
        this.amtDollars=amtDollars;
        this.amtCents=amtCents;
        this.payee=payee;
        this.category=category;
    }
    
    public Calendar getDate()
    {
        return this.date;
    }
    
    public int getAmtDollars()
    {
        return this.amtDollars;
    }
    
    public int getAmtCents()
    {
    	return this.amtCents;
    }
    
    public String getAmtString()
    {
    	return (this.amtDollars+"."+this.amtCents);
    }
    
    public String getPayee()
    {
        return this.payee;
    }
    
    public String getCategory()
    {
        return this.category;
    }

	public int getBalDollars() 
	{
		return 0;
	}

	public int getBalCents()
	{
		return 0;
	}
	
	public String getBalString()
    {
    	return null;
    }
}
