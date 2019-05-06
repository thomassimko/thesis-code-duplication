import java.util.Calendar;
import java.util.Comparator;

public class DateComparator
    implements Comparator<RSSItem>
{
    public int compare(RSSItem left, RSSItem right)
    {
	return left.getDate().compareTo(right.getDate());
    }
}