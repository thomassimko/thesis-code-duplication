import java.util.*;

public class ExpenseDelegateComparator
   implements Comparator
{
   private Comparator c1, c2;

   public ExpenseDelegateComparator(Comparator cc1, Comparator cc2)
   {
      c1 = cc1;
      c2 = cc2;
   }

   @SuppressWarnings("unchecked")
   public int compare(Object e1, Object e2)
   {
      int i = c1.compare((Expense)e1 , (Expense)e2);

      if (i == 0)
      {
         return c2.compare((Expense)e1 , (Expense)e2);
      }
      else
      {
         return i;
      }
   }
}
