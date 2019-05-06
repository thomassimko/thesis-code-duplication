import java.util.*;
public class RSSItemComparator 
	implements Comparator<RSSItem>
{
	public int compare(RSSItem item1, RSSItem item2) 
	{
		Calendar cal1 = item1.getDate();
		Calendar cal2 = item2.getDate();
		int returnVal = 1;
		if(cal1.after(cal2))
		{
			returnVal = -1;
		}
		return returnVal;
	}
	public boolean equals(RSSItem other)
	{
		throw new UnsupportedOperationException();
	}
}
