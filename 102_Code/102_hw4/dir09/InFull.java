import java.util.*;

public class InFull
   implements Expense
{
   private Date date;
   private int paidDollar, paidCent;
   private String payee, category;
	
   public InFull(Date date, int paidDollar, int paidCent, String payee, String category)
   {
      this.date = date;
      this.paidDollar = paidDollar;
      this.paidCent = paidCent;
      this.payee = payee;
      this.category = category;
   }
   
   public String getType()
   {
      return "in-full";
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
	
   public String toString()
   {
      return String.format("%1$2tm/%<2td/%<tY ", date) + String.format("%-15.15s %10s [%s]", payee, paid(), category);
   }
}
