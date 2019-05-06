import java.util.Comparator;

public class ExpenseDateDelegateComparator<T>
	implements Comparator<T>
{
	Comparator<T> next;
	public ExpenseDateDelegateComparator(Comparator<T> next)
	{
		this.next = next;
	}
	public int compare(T one, T two)
	{
		int value = ((Payment)one).getDate().compareTo(((Payment)two).getDate());
		if (value==0)
		{
			return next.compare(one, two);
		}
		return value;
	}
}