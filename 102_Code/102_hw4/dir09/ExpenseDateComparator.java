import java.util.*;

public class ExpenseDateComparator
   implements Comparator<Expense>
{
   public int compare(Expense first, Expense second)
	{
	   return first.date().compareTo(second.date());
	}
}

