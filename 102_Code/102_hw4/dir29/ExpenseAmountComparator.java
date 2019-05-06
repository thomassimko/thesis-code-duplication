import java.util.Comparator;


public class ExpenseAmountComparator implements Comparator<FullExpense> {

	public ExpenseAmountComparator() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public int compare(FullExpense o1, FullExpense o2) {
		if( o1.getAmountPaid() > o2.getAmountPaid()){
			return 1;
		}else if(o1.getAmountPaid() < o2.getAmountPaid()){
			return -1;
		}
		return 0;
	}
}
