import java.util.*;

public class ShowExpenses
{
   public static void show(List<Expense> list)
   {
      System.out.println();

      for (Expense e : list)
      {
         System.out.println(e.toString());
      }
   }
}
