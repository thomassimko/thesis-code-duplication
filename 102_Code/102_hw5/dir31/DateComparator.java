
import java.util.Comparator;


public class DateComparator 
		implements Comparator<RSSItem>
{

	public int compare(RSSItem lft, RSSItem rht) 
	{
		int result = lft.getDate().compareTo(rht.getDate());
		return result;
		
	}



}
