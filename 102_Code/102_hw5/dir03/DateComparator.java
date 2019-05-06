import java.util.*;

public class DateComparator 
implements java.util.Comparator<RSSinfo>
{
	public int compare(RSSinfo left, RSSinfo right)
    {
    	Calendar leftDate=left.getDate();
    	Calendar rightDate=right.getDate();
    	return rightDate.compareTo(leftDate);
    }
}
