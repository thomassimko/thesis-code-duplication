import java.util.*;

public interface Expense
{
   String getType();
   Date getDate();
   Amount amountPaid();
   String getPayee();
   String getCategory();
   Amount getBalance();
}
