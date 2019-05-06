import java.util.Comparator;
public class DateComparator
implements Comparator
{
	public int compare(Object o1, Object o2)
	{
		return ((RSSItem)o1).getDate().compareTo(((RSSItem)o2).getDate());
	}
}
