import java.util.Date;
import java.util.Calendar;
public interface Expense
{
	Calendar getDate();
	String paidAmount();
	String paidTo();
	String getDesc();
	String getBal();
	String print();
	Money paidMoney();
}
