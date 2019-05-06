import java.util.Comparator;


public class RSSItemComparator implements Comparator<RSSItem> 
{

	
	public int compare(RSSItem arg0, RSSItem arg1) 
	{
		return arg0.getDate().compareTo(arg1.getDate());
	}

}
