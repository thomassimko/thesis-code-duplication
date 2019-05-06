import java.util.Comparator;


public class ExpenseAmountDelegateComparator implements Comparator<Expenses> {
	Comparator<Expenses> next;
	public ExpenseAmountDelegateComparator(Comparator<Expenses> next)
	{
		this.next = next;
	}
	@Override
	public int compare(Expenses e1, Expenses e2) {
		// TODO Auto-generated method stub
		Money o1 = e1.getAmount();
		Money o2 = e2.getAmount();

		if ( o1.getDollar() > o2.getDollar())
		{
			return 1;
		}
		else if ( o1.getDollar() == o2.getDollar())
		{
			if ( o1.getCents() > o2.getCents())
			{
				return 1;
			}
			else if ( o1.getCents() < o2.getCents())
			{
				return -1;
			}
		}
		else if ( o1.getDollar() < o2.getDollar())
		{
			return -1;
		}
		return next.compare(e1, e2);
		
	}

}
