import java.util.Comparator;


public class ExpenseAmountComparator implements Comparator<Expense> {

	public int compare(Expense arg0, Expense arg1) {
		return (arg0.getDollars() == arg1.getDollars()) ?
				arg0.getCents() - arg1.getCents() :
				arg0.getDollars() - arg1.getDollars();
	}

}
