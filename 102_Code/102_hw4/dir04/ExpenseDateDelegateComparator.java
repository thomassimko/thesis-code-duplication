import java.util.Comparator;


public class ExpenseDateDelegateComparator 
implements Comparator<Expense>
{
	private Comparator<Expense> comp;
	
	public ExpenseDateDelegateComparator(Comparator<Expense> comp)
	{
		this.comp = comp;
	}
	
	public int compare(Expense date1, Expense date2) 
	{
		int diff = date1.makeDate().compareTo(date2.makeDate());
		
		if(diff == 0)
		{
			diff = comp.compare(date1, date2);
		}
		
		return diff;
	}
}
