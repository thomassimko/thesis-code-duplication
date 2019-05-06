import java.util.*;

public class ExpenseAmountComparator
	implements Comparator<Expense>
{
	public int compare(Expense lft, Expense rht)
	{
		Amount lftAmount = lft.getPaid();
		Amount rhtAmount = rht.getPaid();

		int lftDollars = lftAmount.getDollars();
		int rhtDollars = rhtAmount.getDollars();

		if(lftDollars < rhtDollars)
		{
			return -1;
		}
		else if(lftDollars > rhtDollars)
		{
			return 1;
		}
		else
		{
			int lftCents = lftAmount.getCents();
			int rhtCents = rhtAmount.getCents();

			if(lftCents < rhtCents)
			{
				return -1;
			}
			else if(lftCents > rhtCents)
			{
				return 1;
			}
			else
			{
				return 0;
			}
		}
	}
}