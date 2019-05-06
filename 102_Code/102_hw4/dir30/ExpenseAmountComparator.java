import java.util.Comparator;


public class ExpenseAmountComparator implements Comparator<expense> 
{
	public ExpenseAmountComparator()
	{
		
	}
	
	@Override
	public int compare(expense lft, expense rht) 
	{
		if(lft.getAmountDollars() != rht.getAmountDollars())
		{
			return lft.getAmountDollars() - rht.getAmountDollars();
		}
		else
		{
			return lft.getAmountCents() - rht.getAmountCents();
		}
	}

}
