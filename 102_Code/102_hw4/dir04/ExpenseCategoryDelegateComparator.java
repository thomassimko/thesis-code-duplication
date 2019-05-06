import java.util.Comparator;


public class ExpenseCategoryDelegateComparator 
	implements Comparator<Expense>
{
	private Comparator<Expense> comp;
	
	public ExpenseCategoryDelegateComparator(Comparator<Expense> comp)
	{
		this.comp = comp;
	}
	
	public int compare(Expense cat1, Expense cat2)//neg means cat1 comes first 
	{
		int diff = cat1.getCat().compareTo(cat2.getCat());
		
		if(diff == 0)
		{
			diff = comp.compare(cat1, cat2);
		}
		
		return diff; 
	}

}