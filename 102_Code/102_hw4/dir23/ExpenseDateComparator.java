import java.util.Comparator;


public class ExpenseDateComparator implements Comparator<Expense> {

	@Override
	public int compare(Expense o1, Expense o2) {
		// TODO Auto-generated method stub
		return o1.getDate().compareTo(o2.getDate());
	}

}
