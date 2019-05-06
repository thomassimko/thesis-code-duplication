import java.util.Comparator;


public class ExpensePayeeComparator 
		implements Comparator<Expenses>
{

	public int compare(Expenses lft, Expenses rht) 
	{
		return lft.getPaidTo().compareTo(rht.getPaidTo());		
	}

}
