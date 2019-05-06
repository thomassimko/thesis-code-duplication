import java.util.Comparator;


public class ExpenseDateDelegateComparator 
	implements Comparator<Expense>
{
	private Comparator<Expense> comp;
	
	public ExpenseDateDelegateComparator(Comparator<Expense> c)
	{
		this.comp = c;
	}

	@Override
	public int compare(Expense expense1, Expense expense2)
	{
		int compareResult = expense1.getDate().compareTo(expense2.getDate());
		if(compareResult == 0)
		{
			return comp.compare(expense1, expense2);
		}
		else return compareResult;
	}
	
}
