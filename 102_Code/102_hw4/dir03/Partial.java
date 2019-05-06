//import java.text.*;
import java.util.*;

public class Partial 
implements Expenses
{
	Calendar date;
    int amtDollars;
    int amtCents;
    String payee;
    String category;
    int balDollars;
    int balCents;
    
    public Partial(Calendar date, int amtDollars, int amtCents, String payee, String category, int baldollars, int balcents)
    {
        this.date=date;
        this.amtDollars=amtDollars;
        this.amtCents=amtCents;
        this.payee=payee;
        this.category=category;
        this.balDollars=baldollars;
        this.balCents=balcents;
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
        return this.balDollars;
    }

    public int getBalCents()
    {
    	return this.balCents;
    }
    
    public String getBalString()
    {
    	return (this.balDollars+"."+this.balCents);
    }
}
