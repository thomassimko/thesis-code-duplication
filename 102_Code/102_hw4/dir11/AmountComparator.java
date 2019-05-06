import java.util.Comparator;


public class AmountComparator implements Comparator<Expense>
{

	@Override
	public int compare(Expense arg0, Expense arg1)
	{
		if(arg0.getAmount().getDollar() > arg1.getAmount().getDollar())
		{
			return 1;
		}
		else if(arg0.getAmount().getDollar() < arg1.getAmount().getDollar())
		{
			return -1;
		}
		else
		{
			if(arg0.getAmount().getCent() > arg1.getAmount().getCent())
			{
				return 1;
			}
			else if(arg0.getAmount().getCent() < arg1.getAmount().getCent())
			{
				return -1;
			}
			else return 0;
		}
	}

}
