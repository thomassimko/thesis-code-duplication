import java.util.*;

public class DateComparator 
implements java.util.Comparator<Expenses>
{
	public int compare(Expenses left, Expenses right)
    {
    	Calendar leftDate=left.getDate();
    	Calendar rightDate=right.getDate();
    	return leftDate.compareTo(rightDate);
    }
}
