import java.util.Comparator;

public class ExpenseCategoryDelegateComparator
   implements Comparator<Expense>
{
   private Comparator<Expense> comp;
   public ExpenseCategoryDelegateComparator(Comparator<Expense> comp)
   {
      this.comp = comp;
   }
   public int compare(Expense e1, Expense e2)
   {
      ExpenseCategoryComparator categoryComp = new ExpenseCategoryComparator();
      if(categoryComp.compare(e1, e2) == 0)
      {
         return this.comp.compare(e1, e2);
      }
      return categoryComp.compare(e1, e2);
   }
}