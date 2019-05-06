import java.util.Comparator;

public class ExpenseCategoryComparator
implements Comparator
{
	public int compare(Object o1, Object o2)
	{
		return ((Expenses)o1).getCategory().compareTo(((Expenses)o2).getCategory());
	}

}
