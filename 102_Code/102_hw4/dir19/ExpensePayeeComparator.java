import java.util.Comparator;
public class ExpensePayeeComparator
	implements Comparator<Expense>
{
	private Expense first;
	private Expense second;

	public int compare(Expense first, Expense second)
	{
		return first.paidTo().compareTo(first.paidTo());
	}
}
		
