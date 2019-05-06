import java.util.Comparator;


public class ExpenseAmountDelegateComparator implements Comparator<Expense> {
	private Comparator<Expense> expenseComparator;
	
	public ExpenseAmountDelegateComparator(Comparator<Expense> expenseComparator) {
		this.expenseComparator = expenseComparator;
	}

	@Override
	public int compare(Expense o1, Expense o2) {
		// TODO Auto-generated method stub
		String amount1 = o1.getPaid();
		String[] amountSplit1 = amount1.split("\\.");
		int amountDollars1 = Integer.parseInt(amountSplit1[0]);
		int amountCents1 = Integer.parseInt(amountSplit1[1]);
		String amount2 = o2.getPaid();
		String[] amountSplit2 = amount2.split("\\.");
		int amountDollars2 = Integer.parseInt(amountSplit2[0]);
		int amountCents2 = Integer.parseInt(amountSplit2[1]);
		
		if(amountDollars1 > amountDollars2) {
			return 1;
		}
		else if(amountDollars1 < amountDollars2) {
			return -1;
		}
		else {
			if(amountCents1 > amountCents2) {
				return 1;
			}
			else if(amountCents1 < amountCents2) {
				return -1;
			}
			else {
				return expenseComparator.compare(o1, o2);
			}
		}
	}
}
