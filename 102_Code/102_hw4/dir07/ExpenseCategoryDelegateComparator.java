import java.util.Comparator;


public class ExpenseCategoryDelegateComparator 
	implements Comparator<Expense>
{
	private Comparator<Expense> comp;
	
	public ExpenseCategoryDelegateComparator(Comparator<Expense> c)
	{
		this.comp = c;
	}

	@Override
	public int compare(Expense expense1, Expense expense2)
	{
		int compareResult = expense1.getCategory().compareTo(expense2.getCategory());

		if(compareResult == 0)
		{
			return comp.compare(expense1, expense2);
		}
		else return compareResult;
	}

}
