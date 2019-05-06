import java.util.Comparator;

public class ExpensePayeeDelegateComparator<T>
	implements Comparator<T>
{
	Comparator<T> next;
	public ExpensePayeeDelegateComparator(Comparator<T> next)
	{
		this.next = next;
	}
	public int compare(T one, T two)
	{
		int value = ((Payment)one).getPayee().compareTo(((Payment)two).getPayee());
		if (value==0)
		{
			return next.compare(one, two);
		}
		return value;
	}
}