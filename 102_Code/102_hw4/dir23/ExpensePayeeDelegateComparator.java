import java.util.Comparator;


public class ExpensePayeeDelegateComparator implements Comparator<Expense> {
	private Comparator<Expense> expenseComparator;
	
	public ExpensePayeeDelegateComparator(Comparator<Expense> expenseComparator) {
		this.expenseComparator = expenseComparator;
	}

	@Override
	public int compare(Expense o1, Expense o2) {
		// TODO Auto-generated method stub
		int temp = o1.getPayee().compareTo(o2.getPayee());
		if(temp == 0) {
			return expenseComparator.compare(o1, o2);
		}
		return temp;
	}

}
