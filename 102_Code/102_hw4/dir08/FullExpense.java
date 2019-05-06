import java.util.*;
import java.text.*;

public class FullExpense
   implements Expense
{
   private String category, payee;
   private Amount paid;
   private Calendar cal;

   public FullExpense(Calendar ca, String cat, 
                        String p, Amount a)
   {
      category = cat;
      payee = p;
      paid = a;
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
           + String.format("%-15.15s %10s [%s]", payee, paid.toString(), category);
   }

   public String saveString()
   {
      return "in-full\n" + String.format("%1$2tm/%<2td/%<tY ", cal)
           + "\n" + category + "\n" + payee + "\n" + paid.toString();
   }
}
