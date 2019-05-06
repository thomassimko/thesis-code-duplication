//programmed by Michael Olivarez
import java.util.*;
import java.lang.*;
public class InFullExpense 
  implements Expense
{
  private int dollars;
  private int cents;
  private GregorianCalendar c;
  private String paidTo;
  private String category;
  public InFullExpense(GregorianCalendar c, int dollars, int cents, String paidTo, String category )
  {
    this.dollars = dollars;
    this.cents = cents;
    this.c = c;
    this.paidTo = paidTo;
    this.category = category;
  }
  public String getType()
  {
    return "in-full";
  }
  public String getDate()
  {
    String date = String.format("%1$tm/%1$te/%1$tY",this.c);
    return date;
  }
  public String getAmt()
  {
    if(this.cents >= 10)
    {
      return this.dollars + "." + this.cents;
    }
    else
    {
      return this.dollars + ".0" + this.cents;
    }
  }
  public String getPaidTo()
  {
    return this.paidTo;
  }
  public String getCategory()
  {
    return this.category;
  }
  public String getAmtDue()
  {
    return "0.00";
  }
  
  public int getDollNum()
  {
    return this.dollars;
  }
  public int getCentNum()
  {
    return this.cents;
  }
}
