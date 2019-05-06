import java.util.Comparator;
public class ExpenseDateComparator
	implements Comparator<Expense>
{
	private Expense first;
	private Expense second;

	public int compare(Expense first, Expense second)
	{
		return first.getDate().compareTo(second.getDate());
	}
}
