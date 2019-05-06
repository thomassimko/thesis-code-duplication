import java.util.Calendar;

public interface Expenses
{

   Calendar getDate();
   
   String getPayee();
 
   String getCategory();
  
   String getAmountPaid();

}