import java.util.Comparator;


public class ExpenseAmountComparator implements Comparator<Expense> {

	@Override
	public int compare(Expense e1, Expense e2) {
		return e1.getAmount().compareTo(e2.getAmount());
	}

}
