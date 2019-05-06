import java.util.*;

public class RSSDateComparator
   implements Comparator<RSSItem>
{
   public int compare(RSSItem first, RSSItem second)
	{
	   return (-1)*(first.getTime().compareTo(second.getTime()));
	}
}