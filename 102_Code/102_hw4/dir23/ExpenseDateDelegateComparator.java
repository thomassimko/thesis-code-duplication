import java.util.Comparator;


public class ExpenseDateDelegateComparator implements Comparator<Expense> {
	private Comparator<Expense> expenseComparator;
	
	public ExpenseDateDelegateComparator(Comparator<Expense> expenseComparator) {
		this.expenseComparator = expenseComparator;
	}

	@Override
	public int compare(Expense o1, Expense o2) {
		// TODO Auto-generated method stub
		int temp = o1.getDate().compareTo(o2.getDate());
		if(temp == 0) {
			return expenseComparator.compare(o1, o2);
		}
		return temp;
	}
}
