import java.util.Comparator;

public class ExpenseCategoryDelegateComparator<T>
	implements Comparator<T>
{
	Comparator<T> next;
	public ExpenseCategoryDelegateComparator(Comparator<T> next)
	{
		this.next = next;
	}
	public int compare(T one, T two)
	{
		int value = ((Payment)one).getCategory().compareTo(((Payment)two).getCategory());
		if (value==0)
		{
			return next.compare(one, two);
		}
		return value;
	}
}