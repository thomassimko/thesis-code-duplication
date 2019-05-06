import java.util.Comparator;

public class ExpenseAmountComparator 
	implements Comparator<Expense> 
{
	public int compare(Expense amt1, Expense amt2) 
	{
		/*int dollar1 = ((amt1.getDollar())*100)+amt1.getCent();
		int dollar2 = ((amt2.getDollar())*100)+amt2.getCent();
		
		return dollar1-dollar2;*/
		
		return (amt1.paidToString()).compareTo(amt2.paidToString());
	}
}
