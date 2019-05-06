import java.util.Comparator;


public class ExpenseAmountComparator implements Comparator<Expense> 
{

	public int compare(Expense o1, Expense o2) 
	{
		if (o1.getDollarAmount() == o2.getDollarAmount())
		{
			return o1.getCentAmount() - o2.getCentAmount();
		}
		else return o1.getDollarAmount() - o2.getDollarAmount();
	}

}
