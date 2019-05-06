import java.util.Date;

public interface Expense
{
   Date getDate();
   String getCategory();
   int getCents();
   int getDollars();
   String getPayee();
   String getAmountString();
   int getRemDollars();
   int getRemCents();
   String getRemAmountString();
}