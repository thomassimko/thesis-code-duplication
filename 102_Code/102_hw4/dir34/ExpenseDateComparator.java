import java.util.Comparator;
public class ExpenseDateComparator
implements Comparator
{
	public int compare(Object o1, Object o2)
	{
		//return ((Expenses)o1).getDate().compare(((Expenses)o2).getDate());
		if(((Expenses)o1).getDate().before(((Expenses)o2).getDate()))
		{
			return -1;
		}
		if(((Expenses)o1).getDate().after(((Expenses)o2).getDate()))
		{
			return 1;
		}
		else
		{
			return 0;
		}
	}
}
