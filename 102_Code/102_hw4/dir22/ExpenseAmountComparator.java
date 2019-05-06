//programmed by Michael Olivarez
import java.util.*;
public class ExpenseAmountComparator
  extends ExpenseDelegateComparator
{
  public int compare(Expense lft, Expense rht)
  {
    if(lft.getDollNum() != rht.getDollNum())
    {
      return lft.getDollNum() - rht.getDollNum();
    }
    else
    {
      return lft.getCentNum() - rht.getCentNum();
    }
  }
}
