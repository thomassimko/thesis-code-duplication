import java.util.*;

public class ExpensePayeeComparator
   implements Comparator
{
   public int compare(Object e1, Object e2)
   {
      String s1 = ((Expense)e1).getPayee();
      String s2 = ((Expense)e2).getPayee();

      return (int)Math.signum(s1.compareToIgnoreCase(s2));
   }
}
