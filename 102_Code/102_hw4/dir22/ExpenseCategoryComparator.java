//programmed by Michael Olivarez
import java.util.*;
public class ExpenseCategoryComparator
  extends ExpenseDelegateComparator
{
  public int compare(Expense lft, Expense rht)
  {
    return lft.getCategory().compareTo(rht.getCategory());
  }
}
