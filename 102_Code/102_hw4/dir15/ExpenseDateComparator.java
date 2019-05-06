import java.util.Comparator;

public class ExpenseDateComparator 
	implements Comparator<Expense> 
{
	public int compare(Expense date1, Expense date2) 
	{
		return date1.getDate().compareTo(date2.getDate());	
	}

}
