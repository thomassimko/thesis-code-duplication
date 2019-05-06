import java.util.Calendar;

public interface Expense
{
	String getType();
	Calendar getDate();
	Money getAmount();
	int getAmountDollars();
	int getAmountCents();
	String getPayee();
	String getDescription();
	Money getRemaining();
	int getRemainingDollars();
	int getRemainingCents();
}
