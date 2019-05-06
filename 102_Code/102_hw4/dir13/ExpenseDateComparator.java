import java.util.Comparator;


public class ExpenseDateComparator implements Comparator<Expense> {

	public int compare(Expense arg0, Expense arg1) {
		return arg0.getDate().compareTo(arg1.getDate());
	}

}
