import java.util.*;

public class RSSItemDateComparator
	implements Comparator<RSSItem>
{
	public int compare(RSSItem lft, RSSItem rht)
	{
		return rht.getDate().compareTo(lft.getDate());
	}
}