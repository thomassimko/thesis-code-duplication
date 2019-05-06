import java.util.Calendar;


public class InFullExpense extends Expense {

	public InFullExpense(Calendar cal, int d, int c, String paidTo, String category) {
		super.type = true;
		super.date = cal;
		super.paidTo = paidTo;
		super.category = category;
		super.amountd = d;
		super.amountc = c;
	}

}
