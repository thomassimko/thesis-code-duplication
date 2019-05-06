import java.util.*;

public class ExpenseDateComparator
	implements Comparator<Expense>
{
	public int compare(Expense lft, Expense rht)
	{
		Calendar lftDate = lft.getDate();
		Calendar rhtDate = rht.getDate();
		
		if(lftDate.before(rhtDate))
		{
			return -1;
		}
		else if(lftDate.after(rhtDate))
		{
			return 1;
		}
		else
		{
			return 0;
		}
	}
}