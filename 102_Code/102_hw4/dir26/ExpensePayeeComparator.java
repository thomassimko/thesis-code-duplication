import java.util.Comparator;


public class ExpensePayeeComparator implements Comparator<Expense> {

	@Override
	public int compare(Expense e1, Expense e2) {
		return e1.getPaidTo().compareTo(e2.getPaidTo());
	}

}
