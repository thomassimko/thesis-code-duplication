import java.util.Comparator;


public class ExpensePayeeDelegateComparator implements Comparator<Expense> 
{
	private Comparator<Expense> nextComp;
	
	public ExpensePayeeDelegateComparator(Comparator<Expense> nextComp)
	{
		this.nextComp = nextComp;
	}

	public int compare(Expense o1, Expense o2) 
	{
		if (o1.getPaidTo().compareTo(o2.getPaidTo()) == 0)
		{
			return nextComp.compare(o1, o2);
		}
		else
		{
			return o1.getPaidTo().compareTo(o2.getPaidTo());
		}
	}

}
