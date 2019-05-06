import java.util.Comparator;

public class DateComparator 
	implements Comparator<RSSItem> 
{
	public int compare(RSSItem item1, RSSItem item2) 
	{
		return item2.getDate().compareTo(item1.getDate());	
	}

}
