import java.util.Comparator;

public class ExpensePayeeComparator
   implements Comparator<Expense>
{
   public int compare(Expense first, Expense second)
   {
      return first.getPayee().compareTo(second.getPayee());
   }
}