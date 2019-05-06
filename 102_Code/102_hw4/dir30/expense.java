import java.util.Date;

public interface expense 
{
	String getType();
	Date getDate();
	String getCategory();
	String getPaidTo();
	int getAmountDollars();
	int getAmountCents();
}
