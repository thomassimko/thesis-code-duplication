import java.util.*;

public class ExpenseDelegateComparator
	implements Comparator<Expense>
{
	private Comparator<Expense> initial;
	private Comparator<Expense> delegation;

	public ExpenseDelegateComparator(Comparator<Expense> initial, Comparator<Expense> delegation)
	{
		this.initial = initial;
		this.delegation = delegation;
	}

	public int compare(Expense lft, Expense rht)
	{
		int val = initial.compare(lft, rht);

		if(val == 0)
		{
			return delegation.compare(lft, rht);
		
		}

		return val;
	}
}