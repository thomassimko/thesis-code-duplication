import java.util.Comparator;

public class ExpenseCategoryComparator<T>
	implements Comparator<T>
{
	public int compare(T one, T two)
	{
		int value = ((Payment)one).getCategory().compareTo(((Payment)two).getCategory());
		return value;
	}
}