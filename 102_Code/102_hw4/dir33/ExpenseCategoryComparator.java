import java.util.Comparator;

public class ExpenseCategoryComparator
   implements Comparator<Expense>
{
   public int compare(Expense first, Expense second)
   {
      return first.getCategory().compareTo(second.getCategory());
   }
}
