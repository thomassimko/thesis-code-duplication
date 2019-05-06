import java.util.*;

public class ExpensePayeeDelegateComparator
   implements Comparator<Expense>
{
   private Comparator<Expense> comp;
   
   public ExpensePayeeDelegateComparator(Comparator<Expense> comp)
   {
      this.comp = comp;
   }
   
   public int compare(Expense first, Expense second)
   {
      if(first.payee().equals(second.payee()))
      {
         return comp.compare(first, second);
      }
      else return first.payee().compareTo(second.payee());
   }
}

