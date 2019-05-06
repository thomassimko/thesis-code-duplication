import java.util.Comparator;


public class ExpenseDateComparator implements Comparator<Expense> {

	@Override
	public int compare(Expense one, Expense two) {
		return one.getDate().compareTo(two.getDate());
		/*if (one.getDate().toString().compareTo(two.getDate().toString()) < 0) {
			return -1;
		}
		else if (one.getDate().toString().compareTo(two.getDate().toString()) > 0) {
			return 1;
		}
		else {
			return 0;
		}*/
	}

}
