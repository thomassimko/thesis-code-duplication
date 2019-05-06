import java.io.PrintWriter;
import java.util.Calendar;


public interface Expenses 
{
	String getType();
	Calendar getDate();
	String getAmount();
	String getRemaining();
	String getPaidTo();
	String getCategory();
	int getdDollarAmnt();
	int getCentAmnt();
	int getDollarRemaining();
	int getCentRemaining();
	void save(PrintWriter writer);
	void display();
	
}
