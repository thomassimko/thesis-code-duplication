import java.util.Calendar;
import java.util.Comparator;


public class DateComparator implements Comparator<RSSItem>
{

	@Override
	public int compare(RSSItem o1, RSSItem o2)
	{
		return o1.getDate().compareTo(o2.getDate());
	}

}
