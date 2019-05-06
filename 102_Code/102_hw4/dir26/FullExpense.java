import java.math.BigDecimal;
import java.util.Date;

public class FullExpense implements Expense {

	private BigDecimal amount;
	private String category, paidTo;
	private Date date;

	public FullExpense(Date date, String category, String paidTo,
			BigDecimal amount) {
		this.category = category;
		this.paidTo = paidTo;
		this.date = date;
		this.amount = amount;
	}

	@Override
	public Date getDate() {
		return date;
	}

	@Override
	public BigDecimal getAmount() {
		return amount;
	}

	@Override
	public String getCategory() {
		return category;
	}

	@Override
	public String getType() {
		return "in-full";
	}

	@Override
	public String getPaidTo() {
		return paidTo;
	}

	@Override
	public BigDecimal getBalance() {
		throw new UnsupportedOperationException();
	}

}
