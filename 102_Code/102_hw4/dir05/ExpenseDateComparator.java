import java.util.Comparator;
import java.util.Date;

public class ExpenseDateComparator
   implements Comparator<Expense>
{
   public int compare(Expense first, Expense second)
   {
      return first.getDate().compareTo(second.getDate());
   }
}