import java.util.Comparator;


public class ExpensePayeeComparator implements Comparator<expense> 
{
	public ExpensePayeeComparator()
	{
		
	}
	
	@Override
	public int compare(expense lft, expense rht) 
	{
		String left = lft.getPaidTo().toLowerCase();
		String right = rht.getPaidTo().toLowerCase();
		
		return left.compareTo(right);
	}

}
