import java.util.Comparator;


public class ExpensePayeeComparator implements Comparator<Expense> 
{

	public int compare(Expense o1, Expense o2) 
	{
		return o1.getPaidTo().compareTo(o2.getPaidTo());
	}
	
}
