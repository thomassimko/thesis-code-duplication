import java.util.Calendar;

public interface Expense
{
   String print();
   Calendar getDate();
   String getPayee();
   String getCategory();
   Amount getPaid();
   String fileFormat();
   String getType();
}
