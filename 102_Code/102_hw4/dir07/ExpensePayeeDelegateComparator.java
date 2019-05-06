import java.util.Comparator;


public class ExpensePayeeDelegateComparator 
	implements Comparator<Expense>
{
	private Comparator<Expense> comp;
	
	public ExpensePayeeDelegateComparator(Comparator<Expense> c)
	{
		this.comp = c;
	}

	@Override
	public int compare(Expense expense1, Expense expense2)
	{
		int compareResult = expense1.getPayee().compareTo(expense2.getPayee());

		if(compareResult == 0)
		{
			return comp.compare(expense1, expense2);
		}
		else return compareResult;
	}

}
