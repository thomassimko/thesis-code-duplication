import java.util.Comparator;

public class ExpensePayeeComparator
   implements Comparator<Expense>
{
   public int compare(Expense e1, Expense e2)
   {
      return e1.getPayee().compareTo(e2.getPayee());
   }
}