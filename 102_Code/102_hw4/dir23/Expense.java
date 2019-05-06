import java.util.*;

public interface Expense {
	public Calendar getDate();
	public String getCategory();
	public String getPayee();
	public String getPaid();
	public String getType();
	public String getRemaining();
	public String printDisplay();
}
