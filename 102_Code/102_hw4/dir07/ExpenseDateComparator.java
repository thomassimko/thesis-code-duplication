import java.util.Comparator;


public class ExpenseDateComparator 
	implements Comparator<Expense>
{

	@Override
	public int compare(Expense expense1, Expense expense2)
	{
		return expense1.getDate().compareTo(expense2.getDate());
	}

}
