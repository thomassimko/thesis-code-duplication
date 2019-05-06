import java.util.*;


public class ExpenseDateDelegateComparator 
implements Comparator<Expenses>
{
	Comparator<Expenses> primary;
	public ExpenseDateDelegateComparator(Comparator<Expenses> primary)
	{
		this.primary=primary;
	}
	
	public int compare(Expenses left, Expenses right)
    {
    	Calendar leftDate=left.getDate();
    	Calendar rightDate=right.getDate();
    	if (leftDate.compareTo(rightDate)==0)
    		return primary.compare(left, right);
    	return leftDate.compareTo(rightDate);
    }
}
