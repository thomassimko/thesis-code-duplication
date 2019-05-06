import java.util.Comparator;

public class ExpenseAmountDelegateComparator
   implements Comparator<Expense>
{
   private Comparator<Expense> comp;
   public ExpenseAmountDelegateComparator(Comparator<Expense> comp)
   {
      this.comp = comp;
   }
   public int compare(Expense e1, Expense e2)
   {
      ExpenseAmountComparator amountComp = new ExpenseAmountComparator();
      if(amountComp.compare(e1, e2) == 0)
      {
         return this.comp.compare(e1, e2);
      }
      return amountComp.compare(e1, e2);
   }
}