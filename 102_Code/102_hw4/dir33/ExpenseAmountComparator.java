import java.util.Comparator;

public class ExpenseAmountComparator
   implements Comparator<Expense>
{
   public int compare(Expense first, Expense second)
   {
      return (first.getPaid().getTotalCents() - second.getPaid().getTotalCents());
   }
}
