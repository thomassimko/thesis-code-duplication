import java.util.Comparator;


public class ExpensePayeeDelegateComparator 
	implements Comparator<Expense>
{
	private Comparator<Expense> comp;
	
	public ExpensePayeeDelegateComparator(Comparator<Expense> comp)
	{
		this.comp = comp;
	}
	
	public int compare(Expense payee1, Expense payee2) 
	{
		int diff = payee1.getPaidTo().compareTo(payee2.getPaidTo());
		
		if(diff == 0)
		{
			diff = comp.compare(payee1, payee2);
		}
		
		return diff;
	}
}
