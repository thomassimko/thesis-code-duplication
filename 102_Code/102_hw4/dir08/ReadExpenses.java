import java.util.*;
import java.io.*;
import java.text.*;

public class ReadExpenses
{
   public static List<Expense> read(String filename)
   {
      Scanner s;
      List<Expense> list = new LinkedList<Expense>();

      try
      {
         s = new Scanner(new File(filename));

         System.out.println("\nFile loaded.");

         while (s.hasNextLine())
         {
            list.add(readExpense(s));
         }

         s.close();
      }
      catch (FileNotFoundException e)
      {
         System.err.println("\nCan't find source file.");
      }
      catch (Exception e)
      {
         System.err.println("\nCould not read all contents from file.");
      }

      return list;
   }

   private static Expense readExpense(Scanner s) throws Exception
   {
      String type = s.nextLine();

      if (type.equalsIgnoreCase("in-full") || type.equalsIgnoreCase("partial"))
      {}
      else
      {
         throw new IllegalArgumentException();
      }

      String date = s.nextLine();
      Calendar cal = Helpers.convertToDate(date);

      String category = s.nextLine();

      String payee = s.nextLine();

      String amt = s.nextLine();
      Amount amount = Helpers.readAmount(amt);
      
      if (type.equalsIgnoreCase("partial"))
      {
         amt = s.nextLine();
         Amount remaining = Helpers.readAmount(amt);

         return new PartialExpense(cal, category, payee, amount, remaining); 
      }
      else
      {
         return new FullExpense(cal, category, payee, amount);
      }
   }
}
