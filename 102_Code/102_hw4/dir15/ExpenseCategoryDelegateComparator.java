import java.util.Comparator;


public class ExpenseCategoryDelegateComparator 
	implements Comparator<Expense> 
{
	private Comparator<Expense> comp;

	public ExpenseCategoryDelegateComparator(Comparator<Expense> comp)
	{
		this.comp = comp;
	}
	
	public int compare(Expense cat1, Expense cat2) 
	{
		if(cat1.getCat().compareTo(cat2.getCat()) == 0)
		{
			return comp.compare(cat1, cat2);
		}
		else
		{
			return cat1.getCat().compareTo(cat2.getCat());
		}
	}

}
