import java.util.Comparator;

public class CategoryComparator implements Comparator<Expense>
{

	@Override
	public int compare(Expense arg0, Expense arg1)
	{
		return arg0.getDescription().compareTo(arg1.getDescription());
	}

}
