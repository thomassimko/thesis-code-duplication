import java.util.Comparator;


public class ExpenseCategoryComparator implements Comparator<Expense> {

	@Override
	public int compare(Expense o1, Expense o2) {
		// TODO Auto-generated method stub
		return o1.getCategory().compareTo(o2.getCategory());
	}

}
