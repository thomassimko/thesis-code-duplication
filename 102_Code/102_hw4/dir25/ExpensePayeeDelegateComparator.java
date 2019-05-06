import java.util.Comparator;


public class ExpensePayeeDelegateComparator implements Comparator<Expenses> {
	Comparator<Expenses> next;
	
	public ExpensePayeeDelegateComparator (Comparator<Expenses> next)
	{
		this.next = next;
	}
	@Override
	public int compare(Expenses e1, Expenses e2) {
		// TODO Auto-generated method stub
		String o1 = e1.getPayee();
		String o2 = e2.getPayee();
		int comparisonResult = o1.compareTo(o2);
		if ( comparisonResult > 0)
		{
			return 1;
		}
		if ( comparisonResult < 0)
		{
			return -1;
		}
		else
		{
			return next.compare(e1, e2);
		}
	}

}
