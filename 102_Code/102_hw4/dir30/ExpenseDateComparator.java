import java.util.Comparator;


public class ExpenseDateComparator implements Comparator<expense> 
{
	public ExpenseDateComparator()
	{
		
	}
	
	@Override
	public int compare(expense lft, expense rht) 
	{
		return lft.getDate().compareTo(rht.getDate());
	}

}
