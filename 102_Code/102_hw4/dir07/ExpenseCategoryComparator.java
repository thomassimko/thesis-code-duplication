import java.util.Comparator;


public class ExpenseCategoryComparator 
	implements Comparator<Expense>
{

	@Override
	public int compare(Expense expense1, Expense expense2)
	{
		return expense1.getCategory().compareTo(expense2.getCategory());
	}

}
