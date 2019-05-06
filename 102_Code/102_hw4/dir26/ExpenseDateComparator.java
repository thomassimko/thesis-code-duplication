import java.util.Comparator;


public class ExpenseDateComparator implements Comparator<Expense> {

	@Override
	public int compare(Expense e1, Expense e2) {
		if(e1.getDate().before(e2.getDate()))
			return -1;
		else if(e1.getDate().equals(e2.getDate()))
			return 0;
		return 1;
	}

}
