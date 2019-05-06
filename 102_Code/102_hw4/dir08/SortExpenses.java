import java.util.*;
import java.io.*;
import java.text.*;

public class SortExpenses
{
   @SuppressWarnings("unchecked")
   public static void sort(List<Expense> list, Scanner s)
   {
      System.out.print("Keys to sort by: ");
      String string = s.nextLine();
      String[] tokens = string.split("\\s+");

      Comparator[] comp = new Comparator[tokens.length];

      for (int i = 0; i < tokens.length; i++)
      {
         if (tokens[i].equalsIgnoreCase("date"))
         {
            comp[i] = new ExpenseDateComparator();
         }
         else if (tokens[i].equalsIgnoreCase("amount"))
         {
            comp[i] = new ExpenseAmountComparator();
         }
         else if (tokens[i].equalsIgnoreCase("payee"))
         {
            comp[i] = new ExpensePayeeComparator();
         }
         else if (tokens[i].equalsIgnoreCase("category"))
         {
            comp[i] = new ExpenseCategoryComparator();
         }
         else
         {
            System.err.println("Invalid keys.");
            return;
         }
      }

      for (int i = tokens.length - 2; i >= 0; i--)
      {
         comp[i] = new ExpenseDelegateComparator(comp[i], comp[i + 1]);
      }

      Collections.sort(list, comp[0]);
   }
}
