import java.util.Comparator;


public class ExpenseAmountComparator 
	implements Comparator<Expense>
{
	public int compare(Expense amt1, Expense amt2) 
	{
		return ((amt1.getDollars()*100) + amt1.getCents()) - ((amt2.getDollars()*100) + amt2.getCents());
	}
}
