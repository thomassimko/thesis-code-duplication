import java.util.Comparator;


public class ExpensePayeeComparator implements Comparator<Expenses> {

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
			return 0;
		}
	}

}
