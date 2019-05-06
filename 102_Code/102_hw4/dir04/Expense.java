import java.util.Calendar;


public interface Expense 
{
		Calendar makeDate();
		String getType();
		String getDate();
		String getCat();
		String getPaidTo();
		String getAmount();
		String getBalance();
		int getDollars();
		int getCents();
}
