import java.util.*;

public class ExpenseCategoryDelegateComparator
   implements Comparator<Expense>
{
   private Comparator<Expense> comp;

   public ExpenseCategoryDelegateComparator(Comparator<Expense> comp)
   {
      this.comp = comp;
   }
   
   public int compare(Expense first, Expense second)
   {
      if(first.category().equals(second.category()))
      {
         return comp.compare(first, second);
      }
      else return first.category().compareTo(second.category());
   }
}

