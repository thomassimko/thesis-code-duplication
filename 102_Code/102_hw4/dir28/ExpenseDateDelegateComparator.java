import java.util.Comparator;

public class ExpenseDateDelegateComparator
   implements Comparator<Expense>
{
   private Comparator<Expense> comp;
   public ExpenseDateDelegateComparator(Comparator<Expense> comp)
   {
      this.comp = comp;
   }
   public int compare(Expense e1, Expense e2)
   {
      ExpenseDateComparator dateComp = new ExpenseDateComparator();
      if(dateComp.compare(e1, e2) == 0)
      {
         return this.comp.compare(e1, e2);
      }
      return dateComp.compare(e1, e2);
   }
}