import java.util.Comparator;


public class ExpenseAmountComparator 
	implements Comparator<Expense>
{

	@Override
	public int compare(Expense expense1, Expense expense2)
	{
		int paid1 = (expense1.getPaidDollars() * 100) + expense1.getPaidCents();
		int paid2 = (expense2.getPaidDollars() * 100) + expense2.getPaidCents();
		return paid1 - paid2;
	}
}
