import java.util.Comparator;


public class ExpenseDelegateComparator implements Comparator<Expense> {
	
	private Comparator<Expense> initial, delegate;
	
	public ExpenseDelegateComparator(Comparator<Expense> initial, Comparator<Expense> delegate){
		this.initial=initial;
		this.delegate=delegate;
	}
	@Override
	public int compare(Expense e1, Expense e2) {
		int compare=initial.compare(e1, e2);
		return compare==0?delegate.compare(e1, e2):compare;
	}

}
