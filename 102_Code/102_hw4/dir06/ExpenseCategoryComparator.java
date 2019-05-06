import java.util.Comparator;


public class ExpenseCategoryComparator implements Comparator<Expense> 
{

	public int compare(Expense o1, Expense o2) 
	{
		return o1.getCategory().compareTo(o2.getCategory());
	}

}
