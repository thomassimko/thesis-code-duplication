import java.util.Date;

public interface Expense
{
   Date getDate();
   String getCategory();
   String getPayee();
   int getFAmount();
   int getSAmount();
   int getFRemaining();
   int getSRemaining();
}