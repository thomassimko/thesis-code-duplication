//programmed by Michael Olivarez
import java.util.*;
public class ExpensePayeeComparator
  extends ExpenseDelegateComparator
{
  public int compare(Expense lft, Expense rht)
  {
     return lft.getPaidTo().compareTo(rht.getPaidTo()); 
  }
}
