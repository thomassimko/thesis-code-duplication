import java.util.*;
import java.text.*;

public class AddExpense
{
   public static void add(List<Expense> list, Scanner s)
   {
      try
      {
         System.out.print("Expense type (in-full, partial)? ");
         String type = s.next();

         System.out.print("Payment date: ");
         String date = s.next();      
         Calendar cal = Helpers.convertToDate(date);

         System.out.print("Expense Amount: ");
         String amt = s.next();
         Amount amount = Helpers.readAmount(amt);

         System.out.print("Who was this expense paid to? ");
         String payee = s.next();

         System.out.print("Expense category: ");
         String category = s.next();

         if (type.equalsIgnoreCase("partial"))
         {
            System.out.print("Expense Balance: ");
            amt = s.next();
            Amount remaining = Helpers.readAmount(amt);

            list.add(0, new PartialExpense(cal, category, payee, amount, remaining));
         }
         else if (type.equalsIgnoreCase("in-full"))
         {
            list.add(0, new FullExpense(cal, category, payee, amount));
         }
         else
            throw new IllegalArgumentException();
      }
      catch (Exception e)
      {
         System.err.println("Illegal entries.");
      }
   }
}
