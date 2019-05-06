import java.util.*;

public class ExpenseDateComparator
   implements Comparator
{
   public int compare(Object e1, Object e2)
   {
      Calendar c1 = ((Expense)e1).getCalendar();
      Calendar c2 = ((Expense)e2).getCalendar();

      return (int)Math.signum(c1.compareTo(c2));
   }
}
