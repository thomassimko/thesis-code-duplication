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
		if(payee1.getPayee().compareTo(payee2.getPayee()) == 0)
		{
			return comp.compare(payee1, payee2);
		}
		else
		{
			return payee1.getPayee().compareTo(payee2.getPayee());
		}
	}

}
