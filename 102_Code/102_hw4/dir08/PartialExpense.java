import java.util.*;
import java.text.*;

public class PartialExpense
   implements Expense
{
   private String category, payee;
   private Amount paid, remaining;
   private Calendar cal;

   public PartialExpense(Calendar ca, String cat, String p, 
                         Amount a, Amount r)
   {
      category = cat;
      payee = p;
      paid = a;
      remaining = r;
      cal = ca; 
   }

   public Calendar getCalendar()
   {
      return cal;
   }

   public String getPayee()
   {
      return payee;
   }

   public String getCategory()
   {
      return category;
   }

   public Amount getAmount()
   {
      return paid;
   }

   public String toString()
   {
      return String.format("%1$2tm/%<2td/%<tY ", cal)
           + String.format("%-15.15s %10s (%s) [%s]", 
                           payee, paid.toString(), remaining.toString(), category);
   }

   public String saveString()
   {
      return "partial\n" + String.format("%1$2tm/%<2td/%<tY", cal)
           + "\n" + category+ "\n" + payee+ "\n" 
           + paid.toString() + "\n" + remaining.toString();
   }
}
