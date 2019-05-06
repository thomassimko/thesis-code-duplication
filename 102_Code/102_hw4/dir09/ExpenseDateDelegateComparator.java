import java.util.*;

public class ExpenseDateDelegateComparator
   implements Comparator<Expense>
{
   private Comparator<Expense> comp;
   
   public ExpenseDateDelegateComparator(Comparator<Expense> comp)
   {
      this.comp = comp;
   }
   
   public int compare(Expense first, Expense second)
   {
      if(first.date().equals(second.date()))
      {
         return comp.compare(first, second);
      }
      else return first.date().compareTo(second.date());
   }
}
