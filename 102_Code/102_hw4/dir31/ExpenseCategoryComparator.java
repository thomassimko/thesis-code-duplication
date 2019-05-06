import java.util.Comparator;


public class ExpenseCategoryComparator 
		implements Comparator<Expenses>
{

	public int compare(Expenses lft, Expenses rht) 
	{
		return lft.getCategory().compareTo(rht.getCategory());		
	}

}
