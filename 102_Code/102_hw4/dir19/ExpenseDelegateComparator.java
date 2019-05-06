import java.util.Comparator;
public class ExpenseDelegateComparator
	implements Comparator<Expense>
{
	private Comparator<Expense> first;
	private Comparator<Expense> second;
	
	public ExpenseDelegateComparator(Comparator<Expense> first, Comparator<Expense> second)
	{
		this.first = first;
		this.second = second;
	}

	public int compare(Expense left, Expense right)
	{
		int i = this.first.compare(left,right);
		if (i == 0)
		{
			i = this.second.compare(left,right);
		}
		return i;
	}
}
