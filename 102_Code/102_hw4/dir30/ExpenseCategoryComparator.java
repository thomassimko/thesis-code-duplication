import java.util.Comparator;


public class ExpenseCategoryComparator implements Comparator<expense> 
{
	public ExpenseCategoryComparator()
	{
		
	}
	
	@Override
	public int compare(expense lft, expense rht) 
	{
		String left;
		String right;
		
		left = lft.getCategory().toLowerCase();
		right = rht.getCategory().toLowerCase();
		
		return left.compareTo(right);
	}
	
}
