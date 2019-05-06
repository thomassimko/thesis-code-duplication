import java.util.Date;


public interface Expense 
{
	Date getDate();
	int getDollar();
	int getCent();
	String getPayee();
	String getCat();
	int getDollarBal();
	int getCentBal();
	String paidToString();
	String remainToString();
	String getType();
	String getStringDate();
}
