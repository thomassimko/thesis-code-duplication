import java.util.*;

public class ExpenseAmountComparator
   implements Comparator
{
   public int compare(Object e1, Object e2)
   {
      Amount a1 = ((Expense)e1).getAmount();
      Amount a2 = ((Expense)e2).getAmount();

      if(a1.getDollars() > a2.getDollars())
      {
         return 1;
      }
      else if (a1.getDollars() < a2.getDollars())
      {
         return -1;
      }
      else
      {
         if (a1.getCents() > a2.getCents())
         {
            return 1;
         }
         else if (a1.getCents() < a2.getCents())
         {
            return -1;
         }
         else
         {
            return 0;
         }
      }
   }
}
