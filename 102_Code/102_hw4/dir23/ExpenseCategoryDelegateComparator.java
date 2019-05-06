import java.util.Comparator;


public class ExpenseCategoryDelegateComparator implements Comparator<Expense> {
	private Comparator<Expense> expenseComparator;
	
	public ExpenseCategoryDelegateComparator(Comparator<Expense> expenseComparator) {
		this.expenseComparator = expenseComparator;
	}
	
	@Override
	public int compare(Expense o1, Expense o2) {
		// TODO Auto-generated method stub
		int temp = o1.getCategory().compareTo(o2.getCategory());
		if(temp == 0) {
			return expenseComparator.compare(o1, o2);
		}
		return temp;
	}
}
