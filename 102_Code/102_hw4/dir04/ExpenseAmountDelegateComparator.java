import java.util.Comparator;


public class ExpenseAmountDelegateComparator 
	implements Comparator<Expense>
{
	private Comparator<Expense> comp;
	
	public ExpenseAmountDelegateComparator(Comparator<Expense> comp)
	{
		this.comp = comp;
	}
	
	public int compare(Expense amt1, Expense amt2) //neg if amt1 is smaller 
	{
		int diff = ((amt1.getDollars()*100) + amt1.getCents()) - ((amt2.getDollars()*100) + amt2.getCents());
		
		if(diff == 0)
		{
			diff = comp.compare(amt1, amt2);
		}
		
		return diff;
	}

}

