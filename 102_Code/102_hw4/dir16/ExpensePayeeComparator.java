import java.util.*;

public class ExpensePayeeComparator
	implements Comparator<Expense>
{
	public int compare(Expense lft, Expense rht)
	{
		int val = lft.getPayee().compareTo(rht.getPayee());

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