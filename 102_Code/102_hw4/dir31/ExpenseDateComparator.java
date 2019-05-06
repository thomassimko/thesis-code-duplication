import java.util.Comparator;


public class ExpenseDateComparator 
		implements Comparator<Expenses>
{

	public int compare(Expenses lft, Expenses rht) 
	{
		int result = lft.getDate().compareTo(rht.getDate());
		return result;
		
	}

}
