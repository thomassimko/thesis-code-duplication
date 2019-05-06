import java.util.Comparator;

public class ExpenseAmountComparator
   implements Comparator<Expense>
{
   public int compare(Expense first, Expense second)
   {
      return ((first.getFAmount()*100) + (first.getSAmount())) - 
            ((second.getFAmount()*100) + (second.getSAmount()));
   }
}