import java.util.Comparator;


public class ExpenseDateDelegateComparator implements Comparator<Expense> {
	Comparator<Expense> afterCompare;
	
	public ExpenseDateDelegateComparator (Comparator<Expense> afterCompare) {
		this.afterCompare = afterCompare;
	}
	
	@Override
	public int compare(Expense one, Expense two) {
		if (one.getDate().toString().compareTo(two.getDate().toString()) < 0) {
			return -1;
		}
		else if (one.getDate().toString().compareTo(two.getDate().toString()) > 0) {
			return 1;
		}
		else {
			return afterCompare.compare(one, two);
		}
	}

}
