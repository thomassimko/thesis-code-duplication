import java.util.Comparator;


public class ExpenseCategoryDelegateComparator 
implements Comparator<Expenses>
{
	Comparator<Expenses> primary;
	public ExpenseCategoryDelegateComparator(Comparator<Expenses> primary)
	{
		this.primary=primary;
	}
	
    public int compare(Expenses left, Expenses right)
    {
    	String leftString=left.getPayee();
    	String rightString=right.getPayee();
    	if (leftString.compareTo(rightString)==0)
    		return primary.compare(left, right);
    	return leftString.compareTo(rightString);
    }
}