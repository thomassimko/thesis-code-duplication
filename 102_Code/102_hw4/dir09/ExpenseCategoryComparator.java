import java.util.*;

public class ExpenseCategoryComparator
   implements Comparator<Expense>
{
   public int compare(Expense first, Expense second)
	{
	   return first.category().compareTo(second.category());
	}
}
