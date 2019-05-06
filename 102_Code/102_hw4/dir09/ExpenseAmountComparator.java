import java.util.*;

public class ExpenseAmountComparator
   implements Comparator<Expense>
{
   public int compare(Expense first, Expense second)
   {
      return first.paidValue() - second.paidValue();
   }
}
