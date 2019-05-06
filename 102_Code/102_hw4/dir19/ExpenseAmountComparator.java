import java.util.Comparator;
public class ExpenseAmountComparator
	implements Comparator<Expense>
{
	private Expense first;
	private Expense second;

	public int compare(Expense first, Expense second)
	{
		return first.paidMoney().totalCents() - second.paidMoney().totalCents();
	}
}
