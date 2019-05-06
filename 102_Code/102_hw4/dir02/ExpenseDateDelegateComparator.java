import java.util.*;
public class ExpenseDateDelegateComparator
   implements Comparator<Expense>
{
   private Comparator<Expense> comp;
   public ExpenseDateDelegateComparator(Comparator<Expense> comp)
   {
      this.comp = comp;
   }
   public int compare(Expense ex1, Expense ex2)
   {
      Date date1 = ex1.getDate().getTime();
      Date date2 = ex2.getDate().getTime();
      int returnVal = -1;
      if(date1.after(date2))
      {
         returnVal = 1;
      }
      else if(date1.equals(date2))
      {
         returnVal = comp.compare(ex1, ex2);
      }
      return returnVal;
   }
}
