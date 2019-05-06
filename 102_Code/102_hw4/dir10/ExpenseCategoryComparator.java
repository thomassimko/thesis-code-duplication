import java.util.Comparator;


public class ExpenseCategoryComparator implements Comparator<Expense> {

	@Override
	public int compare(Expense one, Expense two) {
		if (one.getCategory().toLowerCase().compareTo(two.getCategory()) < 0) {
			return -1;
		}
		else if (one.getCategory().toLowerCase().compareTo(two.getCategory()) > 0) {
			return 1;
		}
		else {
			return 0;
		}
	}

}
