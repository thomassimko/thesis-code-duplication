import java.util.Calendar;


public class PartialExpense extends Expense {
	
	public PartialExpense(Calendar cal, int ad, int ac, String paidTo, String category, int rd, int rc) {
		super.type = false;
		super.date = cal;
		super.paidTo = paidTo;
		super.category = category;
		super.amountd = ad;
		super.amountc = ac;
		super.remainingd = rd;
		super.remainingc = rc;
	}

}
