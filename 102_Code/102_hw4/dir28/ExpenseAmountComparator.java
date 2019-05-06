import java.util.Comparator;

public class ExpenseAmountComparator
   implements Comparator<Expense>
{
   public int compare(Expense e1, Expense e2)
   {
      if(e1.getDollars() > e2.getDollars())
      {
         return 1;
      }
      else if(e1.getDollars() == e2.getDollars())
      {
         if(e1.getCents() > e2.getCents())
         {
            return 1;
         }
         else if(e1.getCents() == e2.getCents())
         {
            return 0;
         }
         else
         {
            return -1;
         }
      }
      else
      {
         return -1;
      }
   }
}