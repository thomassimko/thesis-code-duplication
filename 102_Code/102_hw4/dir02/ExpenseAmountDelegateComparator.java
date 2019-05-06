import java.util.*;
public class ExpenseAmountDelegateComparator
   implements Comparator<Expense>
{
   private Comparator<Expense> comp;
   public ExpenseAmountDelegateComparator(Comparator<Expense> comp)
   {
      this.comp = comp;
   }
   public int compare(Expense ex1, Expense ex2)
   {
      int amount1 = 10*ex1.getAmountD() + ex1.getAmountC();
      int amount2 = 10*ex2.getAmountD() + ex2.getAmountC();
      int returnVal = -1;
      if(amount1 > amount2)
      {
         returnVal = 1;
      }
      else if(amount1 == amount2)
      {
         returnVal = comp.compare(ex1, ex2);
      }
      return returnVal;
   }
}
