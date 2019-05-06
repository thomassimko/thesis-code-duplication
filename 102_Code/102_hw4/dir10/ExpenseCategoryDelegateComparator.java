import java.util.Comparator;


public class ExpenseCategoryDelegateComparator implements Comparator<Expense> {
	Comparator<Expense> afterCompare;
	
	public ExpenseCategoryDelegateComparator (Comparator<Expense> afterCompare) {
		this.afterCompare = afterCompare;
	}
	
	@Override
	public int compare(Expense one, Expense two) {
		if (one.getCategory().toLowerCase().compareTo(two.getCategory().toLowerCase()) < 0) {
			return -1;
		}
		else if (one.getCategory().toLowerCase().compareTo(two.getCategory().toLowerCase()) > 0) {
			return 1;
		}
		else {
			return afterCompare.compare(one, two);
		}
	}

}
