import java.util.Comparator;


public class ExpenseCategoryComparator implements Comparator<Expense> {

	public int compare(Expense arg0, Expense arg1) {
		return arg0.getCategory().compareTo(arg1.getCategory());
	}

}
