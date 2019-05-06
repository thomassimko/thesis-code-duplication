import java.util.Date;

public interface Expense
{
	Date getDate();
	String getPayee();
	String getCategory();
	int getPaidDollars();
	int getPaidCents();
	int getRemainingDollars();
	int getRemainingCents();
	String toString();
}
