import java.util.*;

public class ExpenseAmountDelegateComparator
   implements Comparator<Expense>
{
   private Comparator<Expense> comp;
   
   public ExpenseAmountDelegateComparator(Comparator<Expense> comp)
   {
      this.comp = comp;
   }
   
   public int compare(Expense first, Expense second)
   {
      if(first.paidValue() == second.paidValue())
      {
         return comp.compare(first, second);
      }
      else return first.paidValue() - second.paidValue();
   }
}
