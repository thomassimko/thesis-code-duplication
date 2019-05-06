import java.util.Comparator;


public class DateComparator implements Comparator<Expense>
{

	@Override
	public int compare(Expense arg0, Expense arg1)
	{
		return arg0.getDate().compareTo(arg1.getDate());
	}

}
