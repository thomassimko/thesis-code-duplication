import java.util.*;

public class Partial
   implements Expense
{
   private Date date;
   private int paidDollar, paidCent, remainingDollar, remainingCent;
   private String payee, category;
	
   public Partial(Date date, int paidDollar, int paidCent, String payee, String category, int remainingDollar, int remainingCent)
   {
      this.date = date;
      this.paidDollar = paidDollar;
      this.paidCent = paidCent;
      this.payee = payee;
      this.category = category;
      this.remainingDollar = remainingDollar;
      this.remainingCent = remainingCent;
   }

   public String getType()
   {
      return "partial";
   }
	
   public Date date()
   {
      return date;
   }
	
   public String paid()
   {
      if(paidCent<10) return paidDollar + ".0" + paidCent;
      else return paidDollar + "." + paidCent;
   }
        
   public int paidValue()
   {
      return paidDollar*100 + paidCent;
   }
	
   public String payee()
   {
      return payee;
   }
	
   public String category()
   {
      return category;
   }
	
   public String remaining()
   {
      if(remainingCent<10) return remainingDollar + ".0" + remainingCent;
      else return remainingDollar + "." + remainingCent;
   }
	
   public String toString()
   {
      return String.format("%1$2tm/%<2td/%<tY ", date) + String.format("%-15.15s %10s (%s) [%s]", payee, paid(), remaining(), category);
   }
}
