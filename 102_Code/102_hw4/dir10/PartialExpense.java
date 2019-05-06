import java.util.Calendar;


public class PartialExpense implements Expense {
	private Calendar date;
	private int dollars;
	private int cents;
	private String payee;
	private String category;
	private int amountDollars;
	private int amountCents;
	
	public PartialExpense(Calendar date, int dollars, int cents, String payee, String category, int amountDollars, int amountCents) {
		this.date = date;
		this.dollars = dollars;
		this.cents = cents;
		this.payee = payee;
		this.category = category;
		this.amountDollars = amountDollars;
		this.amountCents = amountCents;
	}
	
	public String getType() {
		return "partial";
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
	
	public int getAmountDollars() {
		return amountDollars;
	}
	
	public int getAmountCents() {
		return amountDollars;
	}
	
	public int getRemainingBalDollars() {
		return amountDollars;
	}
	
	public int getRemainingBalCents() {
		return amountCents;
	}

	@Override
	public String getRemainingBal() {
		int dollars = getRemainingBalDollars();
		int cents = getRemainingBalCents();
		return dollars + "." + cents;
	}

	@Override
	public String printExpense() {
		return String.format("%1$2tm/%<2td/%<tY ", this.getDate()) + String.format("%-15.15s %s (%s) [%s]", this.getPayee(), this.getPaidAmount(), this.getRemainingBal(), this.getCategory());
	}
	

}
