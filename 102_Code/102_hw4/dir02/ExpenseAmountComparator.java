import java.util.*;
public class ExpenseAmountComparator
   implements Comparator<Expense>
{
   public int compare(Expense ex1, Expense ex2)
   {
      int amount1 = 10*ex1.getAmountD() + ex1.getAmountC();
      int amount2 = 10*ex2.getAmountD() + ex2.getAmountC();
      int returnInt = -1;
      if(amount1 > amount2)
      {
         returnInt = 1;
      }
      else if(amount1 == amount2)
      {
         returnInt = 0;
      }
      return returnInt;
   }
   public boolean equals(Object obj)
   {
      throw new UnsupportedOperationException("Operation not stupported!");
   }  
}
