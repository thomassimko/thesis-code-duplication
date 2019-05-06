import java.math.BigDecimal;
import java.util.Date;

public interface Expense {
	public Date getDate();

	public BigDecimal getAmount();

	public String getCategory();
	
	public String getType();
	
	public String getPaidTo();
	
	public BigDecimal getBalance();
}
