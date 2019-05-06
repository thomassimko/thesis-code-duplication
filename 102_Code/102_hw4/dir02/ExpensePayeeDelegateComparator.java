import java.util.*;
public class ExpensePayeeDelegateComparator
   implements Comparator<Expense>
{
   private Comparator<Expense> comp;
   public ExpensePayeeDelegateComparator(Comparator<Expense> comp)
   {
      this.comp = comp;
   }
   public int compare(Expense ex1, Expense ex2)
   {
      String payee1 = ex1.getPayee().toLowerCase();
      String payee2 = ex2.getPayee().toLowerCase();
      int returnVal = -1;
      if(payee1.compareTo(payee2) > 0)
      {
         returnVal = 1;
      }
      else if(payee1.equals(payee2))
      {
         returnVal = comp.compare(ex1, ex2);
      }
      return returnVal;
   }
}
