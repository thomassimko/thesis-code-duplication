import java.util.Comparator;


public class ExpenseCategoryDelegateComparator implements Comparator<Expense> 
{

	private Comparator<Expense> nextComp;
	
	public ExpenseCategoryDelegateComparator(Comparator<Expense> nextComp)
	{
		this.nextComp = nextComp;
	}
	
	public int compare(Expense o1, Expense o2) 
	{
		if(o1.getCategory().compareTo(o2.getCategory()) == 0)
		{
			return nextComp.compare(o1, o2);
		}
		else
		{
			return o1.getCategory().compareTo(o2.getCategory());
		}
	}

}
