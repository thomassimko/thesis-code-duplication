import java.util.*;
public class ExpenseCategoryDelegateComparator
   implements Comparator<Expense>
{
   private Comparator<Expense> comp;
   public ExpenseCategoryDelegateComparator(Comparator<Expense> comp)
   {
      this.comp = comp;
   }
   public int compare(Expense ex1, Expense ex2)
   {
      String cat1 = ex1.getCat().toLowerCase();
      String cat2 = ex2.getCat().toLowerCase();
      int returnVal = -1;
      if(cat1.compareTo(cat2) > 0)
      {
         returnVal = 1;
      }
      else if(cat1.equals(cat2))
      {
         returnVal = comp.compare(ex1, ex2);
      }
      return returnVal;
   }
}
