import java.util.Comparator;

public class ExpenseDateComparator
   implements Comparator<Expense>
{
   public int compare(Expense one, Expense two)
   {
      return one.getDate().compareTo(two.getDate());
   }
}
