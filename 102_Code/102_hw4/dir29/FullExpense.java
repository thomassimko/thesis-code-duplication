import java.util.Date;

public class FullExpense {
	Date date;
	String category;
	String payee;
	double amountPaid;
	
	public FullExpense(Date date, String category, String payee, double amountPaid) {
		this.date = date;
		this.category = category;
		this.payee = payee;
		this.amountPaid = amountPaid;
	}

	public String getType() {
		return "in-full";
	}

	public Date getDate() {
		return date;
	}

	public String getCategory() {
		return category;
	}

	public String getPayee() {
		return payee;
	}

	public double getAmountPaid() {
		return amountPaid;
	}

}
