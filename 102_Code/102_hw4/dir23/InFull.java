import java.util.*;

public class InFull implements Expense {
	private Calendar date;
	private int paidDollars, paidCents;
	private String payee, category;
	
	public InFull(Calendar date, int paidDollars, int paidCents, String payee, String category) {
		this.date = date;
		this.paidDollars = paidDollars;
		this.paidCents = paidCents;
		this.payee = payee;
		this.category = category;
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
		return "in-full";
	}

	@Override
	public String getRemaining() {
		// TODO Auto-generated method stub
		return "0";
	}

	@Override
	public String printDisplay() {
		// TODO Auto-generated method stub
		return String.format("%1$2tm/%<2td/%<tY", date)
				+ String.format(" %-15.15s %10s [%s]", payee, (paidDollars + "." + paidCents).toString(), category);
	}
}
