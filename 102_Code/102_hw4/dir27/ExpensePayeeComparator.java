import java.util.Comparator;

public class ExpensePayeeComparator<T>
	implements Comparator<T>
{
	public int compare(T one, T two)
	{
		int value = ((Payment)one).getPayee().compareTo(((Payment)two).getPayee());
		return value;
	}
}