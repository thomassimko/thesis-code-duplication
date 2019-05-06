import java.util.Comparator;


public class ExpenseAmountDelegateComparator implements Comparator<Expense> 
{
	private Comparator<Expense> nextComp;
	
	public ExpenseAmountDelegateComparator(Comparator<Expense> nextComp)
	{
		this.nextComp = nextComp;
	}

	
	public int compare(Expense o1, Expense o2) 
	{
		if (o1.getDollarAmount() == o1.getDollarAmount() && o1.getCentAmount() == o2.getCentAmount())
		{
			return nextComp.compare(o1, o2);
		}
		else
		{
			if (o1.getDollarAmount() == o2.getDollarAmount())
			{
				return o1.getCentAmount() - o2.getCentAmount();
			}
			else return o1.getDollarAmount() - o2.getDollarAmount();
		}
	}
}
