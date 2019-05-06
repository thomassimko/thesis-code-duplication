import java.util.Comparator;

public class ExpensePayeeDelegateComparator
   implements Comparator<Expense>
{
   private Comparator<Expense> comp;
   public ExpensePayeeDelegateComparator(Comparator<Expense> comp)
   {
      this.comp = comp;
   }
   public int compare(Expense e1, Expense e2)
   {
      ExpensePayeeComparator payeeComp = new ExpensePayeeComparator();
      if(payeeComp.compare(e1, e2) == 0)
      {
         return this.comp.compare(e1, e2);
      }
      return payeeComp.compare(e1, e2);
   }
}