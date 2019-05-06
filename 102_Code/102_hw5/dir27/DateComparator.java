import java.util.Comparator;

public class DateComparator<T>
	implements Comparator<T>
{
	public int compare(T one, T two)
	{
		int value = ((RSSItem)one).getDateString().compareTo(((RSSItem)two).getDateString());
		return -value;
	}
}