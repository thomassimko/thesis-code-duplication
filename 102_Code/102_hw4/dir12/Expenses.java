import java.util.Date;

public interface Expenses {
	Date getDate();
	double getAmount();
	String getCategory();
	String getName();
	double getBalance();
	String print();
	String getType();
}
