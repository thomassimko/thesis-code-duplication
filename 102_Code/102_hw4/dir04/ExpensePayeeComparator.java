import java.util.Comparator;


public class ExpensePayeeComparator 
	implements Comparator<Expense>
{
	public int compare(Expense payee1, Expense payee2) 
	{
		return payee1.getPaidTo().compareTo(payee2.getPaidTo());
	}
}
