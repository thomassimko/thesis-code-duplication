import java.util.Comparator;


public class ExpenseDateDelegateComparator implements Comparator<Expense> 
{

	private Comparator<Expense> nextComp;
	
	public ExpenseDateDelegateComparator(Comparator<Expense> nextComp)
	{
		this.nextComp = nextComp;
	}
	
	public int compare(Expense o1, Expense o2) 
	{
		if (o1.getDate().compareTo(o2.getDate()) == 0)
		{
			int i = nextComp.compare(o1, o2);
			return i;
		}
		else
		{ 
			int j = o1.getDate().compareTo(o2.getDate());
			return j;
		}
	}

}
