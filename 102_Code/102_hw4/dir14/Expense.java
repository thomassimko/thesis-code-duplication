import java.util.*;

public interface Expense 
{
	String getType();
	String getCategory();
	String getPaidTo();
	String getAmount();
	String getRemainingAmount();
	Date getDate();
	String stringDate();
	int getDollars();
	int getCents();
	String toString();
}
