import java.util.*;

public class ExpenseCategoryComparator
   implements Comparator
{
   public int compare(Object e1, Object e2)
   {
      String s1 = ((Expense)e1).getCategory();
      String s2 = ((Expense)e2).getCategory();

      return (int)Math.signum(s1.compareToIgnoreCase(s2));
   }
}
