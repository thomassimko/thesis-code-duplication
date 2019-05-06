import java.util.Comparator;


public class ExpensePayeeComparator 
	implements Comparator<Expense>
{

	@Override
	public int compare(Expense expense1, Expense expense2)
	{
		return expense1.getPayee().compareTo(expense2.getPayee());
	}

}
