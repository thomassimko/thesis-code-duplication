import java.util.Comparator;


public class ExpenseAmountDelegateComparator implements Comparator<Expense> {
	Comparator<Expense> afterCompare;
	
	public ExpenseAmountDelegateComparator (Comparator<Expense> afterCompare) {
		this.afterCompare = afterCompare;
	}
	
	public int compare(Expense one, Expense two) {
		if (one.getPaidAmountDollars() == two.getPaidAmountDollars()) {
			if (one.getPaidAmountCents() > two.getPaidAmountCents()) {
				return 1;
			}
			else if (one.getPaidAmountCents() < two.getPaidAmountCents()) {
				return -1;
			}
			else {
				return this.afterCompare.compare(one, two);
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
