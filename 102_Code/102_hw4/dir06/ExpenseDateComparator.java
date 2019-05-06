import java.util.Comparator;


public class ExpenseDateComparator implements Comparator<Expense> 
{

	
	public int compare(Expense o1, Expense o2) 
	{
		return o1.getDate().compareTo(o2.getDate());
	}
	
}
