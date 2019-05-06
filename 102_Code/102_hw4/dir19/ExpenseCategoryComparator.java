import java.util.Comparator;
public class ExpenseCategoryComparator
	implements Comparator<Expense>
{
	private Expense first;
	private Expense second;

	public int compare(Expense first, Expense second)
	{
		return first.getDesc().compareTo(second.getDesc());
	}
}
