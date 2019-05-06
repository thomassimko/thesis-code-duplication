import java.util.Comparator;


public class ExpenseDelegateComparator implements Comparator<Expense> {
	Comparator<Expense> first, second;
	public ExpenseDelegateComparator(Comparator<Expense> primary, Comparator<Expense> secondary) {
		first = primary;
		second = secondary;
	}

	public int compare(Expense o1, Expense o2) {
		int compared = first.compare(o1, o2);
		if (compared == 0)
			return second.compare(o1, o2);
		return compared;
	}

}
