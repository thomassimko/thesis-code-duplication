import java.util.Date;


public class PartialExpense extends FullExpense {
	double remainingAmount;
	
	public PartialExpense(Date date, String category, String payee, double amountPaid, double remainingAmount) {
		super(date, category, payee, amountPaid);
		this.remainingAmount = remainingAmount;
	}

	public double getRemainingAmount() {
		return remainingAmount;
	}

}
