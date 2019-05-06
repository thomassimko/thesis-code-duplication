import java.util.Comparator;


public class ExpenseDelegateComparator
		implements Comparator<Expenses>
{
	Comparator<Expenses> comp;
	Comparator<Expenses> delegator;
	public ExpenseDelegateComparator(Comparator<Expenses> comp, Comparator<Expenses> delegator)
	{
		this.comp = comp;
		this.delegator = delegator;
	}

	public int compare(Expenses lft, Expenses rht) 
	{
		int val = comp.compare(lft, rht);
		if(val == 0)
		{
			return delegator.compare(lft, rht);
		}
		else return val;
	}
	
	

}
