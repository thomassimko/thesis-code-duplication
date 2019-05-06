import java.util.*;
public class ExpenseDateComparator
   implements Comparator<Expense>
{
   public int compare(Expense ex1, Expense ex2)
   {
      int returnInt = -1;
      Date date1 = ex1.getDate().getTime();
      Date date2 = ex2.getDate().getTime();
      if(date1.after(date2))
      {
         returnInt = 1;
      }
      else if(date1.equals(date2))
      {
         returnInt = 0;
      }
      return returnInt;
   }
   public boolean equals(Object obj)
   {
      throw new UnsupportedOperationException("Unsupported!");
   }
}
