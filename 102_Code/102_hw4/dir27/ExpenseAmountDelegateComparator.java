import java.util.Comparator;

public class ExpenseAmountDelegateComparator<T>
	implements Comparator<T>
{
	Comparator<T> next;
	public ExpenseAmountDelegateComparator(Comparator<T> next)
	{
		this.next = next;
	}
	public int compare(T one, T two)
	{
		int oneDollar = ((Payment)one).getPay().getDollars();
		int twoDollar = ((Payment)two).getPay().getDollars();
		int oneCents = ((Payment)one).getPay().getCents();
		int twoCents = ((Payment)two).getPay().getCents();
		if (oneDollar-twoDollar < 0 || oneDollar-twoDollar > 0)
		{
			return oneDollar-twoDollar;
		}
		return oneCents-twoCents;
	}
}