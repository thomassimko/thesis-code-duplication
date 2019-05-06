import java.util.*;
public interface Expense
{
   public Date getDate();
   public int getBalanceDollars();
   public int getBalanceCents();
   public int getDollars();
   public int getCents();
   public String getCategory();
   public String getStringDate();
   public String toString();
   public String toStringFile();
   public String getPayee();
   public String getPaidString();
}
