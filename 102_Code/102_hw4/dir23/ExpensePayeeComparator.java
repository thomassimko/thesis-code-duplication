import java.util.Comparator;


public class ExpensePayeeComparator implements Comparator<Expense> {

	@Override
	public int compare(Expense o1, Expense o2) {
		// TODO Auto-generated method stub
		return o1.getPayee().compareTo(o2.getPayee());
	}

}
