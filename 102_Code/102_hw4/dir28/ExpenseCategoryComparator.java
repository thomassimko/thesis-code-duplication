import java.util.Comparator;

public class ExpenseCategoryComparator
   implements Comparator<Expense>
{
   public int compare(Expense e1, Expense e2)
   {
      return e1.getCategory().compareTo(e2.getCategory());
   }
}