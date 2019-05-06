import java.math.BigDecimal;
import java.util.Date;

public class PartialExpense implements Expense {

	private BigDecimal amount, balance;
	private String category, paidTo;
	private Date date;

	public PartialExpense(Date date, String category, String paidTo,
			BigDecimal amount, BigDecimal balance) {
		this.category = category;
		this.paidTo = paidTo;
		this.date = date;
		this.amount = amount;
		this.balance = balance;
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
		return "partial";
	}

	@Override
	public String getPaidTo() {
		return paidTo;
	}

	@Override
	public BigDecimal getBalance() {
		return balance;
	}

}
