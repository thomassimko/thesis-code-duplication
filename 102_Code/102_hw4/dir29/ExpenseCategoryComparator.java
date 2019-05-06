import java.util.Comparator;


public class ExpenseCategoryComparator implements Comparator<FullExpense> {

	public ExpenseCategoryComparator() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public int compare(FullExpense o1, FullExpense o2) {
		return o1.getCategory().compareTo(o2.getCategory());
	}
}
