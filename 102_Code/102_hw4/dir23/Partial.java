import java.util.*;

public class Partial implements Expense {
	private Calendar date;
	private int paidDollars, paidCents, remainingBalDollars, remainingBalCents;
	private String payee, category;
	
	public Partial(Calendar date, int paidDollars, int paidCents, String payee, String category, int remainingBalDollars, int remainingBalCents) {
		this.date = date;
		this.paidDollars = paidDollars;
		this.paidCents = paidCents;
		this.payee = payee;
		this.category = category;
		this.remainingBalDollars = remainingBalDollars;
		this.remainingBalCents = remainingBalCents;
	}

	@Override
	public Calendar getDate() {
		// TODO Auto-generated method stub
		return date;
	}

	@Override
	public String getCategory() {
		// TODO Auto-generated method stub
		return category;
	}

	@Override
	public String getPayee() {
		// TODO Auto-generated method stub
		return payee;
	}

	@Override
	public String getPaid() {
		// TODO Auto-generated method stub
		return paidDollars + "." + paidCents;
	}

	@Override
	public String getType() {
		// TODO Auto-generated method stub
		return "partial";
	}

	@Override
	public String getRemaining() {
		// TODO Auto-generated method stub
		return remainingBalDollars + "." + remainingBalCents;
	}

	@Override
	public String printDisplay() {
		// TODO Auto-generated method stub
		return String.format("%1$2tm/%<2td/%<tY", date)
				+ String.format(" %-15.15s %10s (%s) [%s]",
				payee, (paidDollars + "." + paidCents).toString(), (remainingBalDollars + "." + remainingBalCents).toString(), category);
	}
}
