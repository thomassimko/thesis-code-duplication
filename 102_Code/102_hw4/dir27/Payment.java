import java.util.Date;

public interface Payment
{
	Date getDate();
	Paid getPay();
	String getPayee();
	String getCategory();
	Paid getRemaining();
	String getType();
}