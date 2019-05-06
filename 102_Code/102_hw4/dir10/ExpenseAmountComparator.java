import java.util.Comparator;


public class ExpenseAmountComparator implements Comparator<Expense> {

	@Override
	public int compare(Expense one, Expense two) {
		if (one.getPaidAmountDollars() == two.getPaidAmountDollars()) {
			if (one.getPaidAmountCents() > two.getPaidAmountCents()) {
				return 1;
			}
			else if (one.getPaidAmountCents() < two.getPaidAmountCents()) {
				return -1;
			}
			else {
				return 0;
			}
		}
		else if (one.getPaidAmountDollars() > two.getPaidAmountDollars()) {
			return 1;
		}
		else {
			return -1;
		}
	}

}
