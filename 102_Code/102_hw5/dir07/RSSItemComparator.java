import java.util.Comparator;


public class RSSItemComparator
	implements Comparator<RSSItem>
{
	@Override
	public int compare(RSSItem item1, RSSItem item2)
	{
		return -1*(item1.getDate().compareTo(item2.getDate()));
	}

}
