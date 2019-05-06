import java.util.Comparator;


public class ExpensePayeeComparator implements Comparator<Expense> {

	public int compare(Expense one, Expense two) {
		if (one.getPayee().toLowerCase().compareTo(two.getPayee()) < 0) {
			return -1;
		}
		else if (one.getPayee().toLowerCase().compareTo(two.getPayee()) > 0) {
			return 1;
		}
		else {
			return 0;
		}
	}

}
