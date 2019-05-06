import java.util.Calendar;
import java.util.Date;


public interface Expense 
{
	Calendar getDate();
	
	int getDollarAmount();
	
	int getCentAmount();
	
	String getPaidTo();
	
	String getCategory();
	
	int getRemainingDollar();
	
	int getRemainingCent();
	
	String getType();
	
	String formatString();
	
	String getDateString();
	
	String paidString();
	
	String remainingString();
}
