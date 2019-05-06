import java.util.Comparator;

public class ExpensePayeeComparator<T>
implements Comparator
{

	public int compare(Object o1, Object o2) {
		return ((Expenses)o1).getPayee().compareTo(((Expenses)o2).getPayee());
	}

}
