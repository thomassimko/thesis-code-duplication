import java.util.Comparator;
import java.util.Date;


public class dateComparator implements Comparator<RSSItem> 
{
	
	@Override
	public int compare(RSSItem lft, RSSItem rht) 
	{
		Date lftDate = lft.getDate().getTime();
		Date rhtDate = rht.getDate().getTime();
		
		if(lftDate.equals(rhtDate))
		{
			return 0;
		}
		else if(lftDate.before(rhtDate))
		{
			return -1;
		}
		else
		{
			return 1;
		}
	}

}
