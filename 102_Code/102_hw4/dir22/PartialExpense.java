//programmed by Michael Olivarez
import java.util.*;
public class PartialExpense
  implements Expense
{
  private int dollarsPaid;
  private int centsPaid;
  private int dollarsDue;
  private int centsDue;
  private GregorianCalendar c;
  private String paidTo;
  private String category;
  public PartialExpense(GregorianCalendar c, int dollarsPaid, int centsPaid, 
               int dollarsDue, int centsDue, String paidTo, String category)
  {
    this.dollarsPaid = dollarsPaid;
    this.centsPaid = centsPaid;
    this.c = c;
    this.dollarsDue = dollarsDue;
    this.centsDue = centsDue;
    this.paidTo = paidTo;
    this.category = category;
  }
  public String getType()
  {
    return "partial";
  }
  public String getDate()
  {
    String date = String.format("%1$tm/%1$te/%1$tY",this.c);
    return date;
  }
  public String getAmt()
  {
    if(this.centsPaid >= 10)
    {
      return this.dollarsPaid + "." + this.centsPaid;
    }
    else
    {
      return this.dollarsPaid + ".0" + this.centsPaid;
    }
  }
  public String getAmtDue()
  {
    if(this.centsDue >= 10)
    {
      return this.dollarsDue + "." + this.centsDue;
    }
    else
    {
      return this.dollarsDue + ".0" + this.centsDue;
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
  public int getDollNum()
  {
    return this.dollarsPaid;
  }
  public int getCentNum()
  {
    return this.centsPaid;
  }

}
