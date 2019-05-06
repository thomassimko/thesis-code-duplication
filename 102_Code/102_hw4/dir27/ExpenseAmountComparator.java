import java.util.Comparator;

public class ExpenseAmountComparator<T>
	implements Comparator<T>
{
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