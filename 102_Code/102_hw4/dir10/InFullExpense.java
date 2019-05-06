import java.util.Calendar;

public class InFullExpense implements Expense {
	private Calendar date;
	private int dollars;
	private int cents;
	private String payee;
	private String category;
	
	public InFullExpense(Calendar date, int dollars, int cents, String payee, String category) {
		this.date = date;
		this.dollars = dollars;
		this.cents = cents;
		this.payee = payee;
		this.category = category;
	}
	public String getType() {
		return "in-full";
	}
	
	public Calendar getDate() {
		return date;
	}
	public String getPaidAmount() {
		return dollars + "." + cents;
	}

	public int getPaidAmountDollars() {
		return dollars;
	}

	public int getPaidAmountCents() {
		return cents;
	}

	public String getPayee() {
		return payee;
	}

	public String getCategory() {
		return category;
	}
	public String getRemainingBal() {
		return "0.00";
	}
	public int getRemainingBalDollars() {
		return 0;
	}
	
	public int getRemainingBalCents(){
		return 0;
	}
	public String printExpense() {
		return String.format("%1$2tm/%<2td/%<tY ", this.getDate()) + String.format("%-15.15s %s [%s]", this.getPayee(), this.getPaidAmount(), this.getCategory());
	}

}
