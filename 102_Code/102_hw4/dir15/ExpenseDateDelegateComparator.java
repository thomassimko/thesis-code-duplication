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
		if(date1.getDate().compareTo(date2.getDate()) == 0)
		{
			return comp.compare(date1, date2);
		}
		else
		{
			return date1.getDate().compareTo(date2.getDate());
		}
	}

}
