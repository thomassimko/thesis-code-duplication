import java.util.Comparator;

public class ExpenseDateComparator<T>
	implements Comparator<T>
{
	public int compare(T one, T two)
	{
		int value = ((Payment)one).getDate().compareTo(((Payment)two).getDate());
		return value;
	}
}