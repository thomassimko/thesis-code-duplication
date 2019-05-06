import java.util.Comparator;


public class ExpensePayeeDelegateComparator implements Comparator<Expense> {
	Comparator<Expense> afterCompare;
	
	public ExpensePayeeDelegateComparator (Comparator<Expense> afterCompare) {
		this.afterCompare = afterCompare;
	}
	
	@Override
	public int compare(Expense one, Expense two) {
		if (one.getPayee().toLowerCase().compareTo(two.getPayee().toLowerCase()) < 0) {
			return -1;
		}
		else if (one.getPayee().toLowerCase().compareTo(two.getPayee().toLowerCase()) > 0) {
			return 1;
		}
		else {
			return afterCompare.compare(one, two);
		}
	}

}
