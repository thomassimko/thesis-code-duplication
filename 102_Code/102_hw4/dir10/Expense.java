import java.util.Calendar;

public interface Expense {
	String getType();
	Calendar getDate();
	String getPaidAmount();
	int getPaidAmountDollars();
	int getPaidAmountCents();
	String getPayee();
	String getCategory();
	String getRemainingBal();
	String printExpense();
}
