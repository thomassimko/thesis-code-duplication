import java.util.*;

public class ExpenseCategoryComparator
	implements Comparator<Expense>
{
	public int compare(Expense lft, Expense rht)
	{
		int val = lft.getCategory().compareTo(rht.getCategory());

		if(val < 0)
		{
			return -1;
		}
		else if(val > 0)
		{
			return 1;
		}
		else
		{
			return 0;
		}
	}
}