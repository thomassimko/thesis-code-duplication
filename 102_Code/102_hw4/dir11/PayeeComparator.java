import java.util.Comparator;


public class PayeeComparator implements Comparator<Expense>
{

	@Override
	public int compare(Expense arg0, Expense arg1)
	{
		return arg0.getPayee().compareTo(arg1.getPayee());
	}

}
