
import java.util.Comparator;


public class ExpenseAmountComparator 
		implements Comparator<Expenses>
{

	public int compare(Expenses lft, Expenses rht) 
	{
		if(lft.getdDollarAmnt() == rht.getdDollarAmnt() && lft.getCentAmnt() == rht.getCentAmnt())
		{
			return 0;
		}
		if(lft.getdDollarAmnt() > rht.getdDollarAmnt() || lft.getCentAmnt() > rht.getCentAmnt() && lft.getdDollarAmnt() == rht.getdDollarAmnt() )
		{
			return 1;
		}
		else return -1;
	}
}