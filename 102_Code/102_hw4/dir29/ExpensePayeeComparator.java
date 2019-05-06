import java.util.Comparator;


public class ExpensePayeeComparator implements Comparator<FullExpense> {

	public ExpensePayeeComparator() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public int compare(FullExpense o1, FullExpense o2) {
		return o1.getPayee().compareTo(o2.getPayee());
	}
}
