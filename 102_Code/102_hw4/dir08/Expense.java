import java.util.*;

public interface Expense
{
   Calendar getCalendar();
   String getPayee();
   String getCategory();
   Amount getAmount();
   String toString();
   String saveString();
}
