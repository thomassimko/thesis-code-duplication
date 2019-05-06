import java.util.*;

public class ExpensePayeeComparator
   implements Comparator<Expense>
{
   public int compare(Expense first, Expense second)
	{
	   return first.payee().compareTo(second.payee());
	}
}
