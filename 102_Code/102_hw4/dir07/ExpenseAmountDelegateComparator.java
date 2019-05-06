import java.util.Comparator;


public class ExpenseAmountDelegateComparator 
	implements Comparator<Expense>
{
	private Comparator<Expense> comp;
	
	public ExpenseAmountDelegateComparator(Comparator<Expense> c)
	{
		this.comp = c;
	}

	@Override
	public int compare(Expense expense1, Expense expense2)
	{
		int paid1 = (expense1.getPaidDollars() * 100) + expense1.getPaidCents();
		int paid2 = (expense2.getPaidDollars() * 100) + expense2.getPaidCents();
		
		if(paid1-paid2 == 0)
		{
			return comp.compare(expense1, expense2);
		}
		else return paid1 - paid2;
	}

}
