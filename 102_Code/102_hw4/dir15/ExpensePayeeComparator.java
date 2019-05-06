import java.util.Comparator;


public class ExpensePayeeComparator 
	implements Comparator<Expense> 
{

	@Override
	public int compare(Expense payee1, Expense payee2) 
	{
		return (payee1.getPayee()).compareTo(payee2.getPayee());
	}

}
