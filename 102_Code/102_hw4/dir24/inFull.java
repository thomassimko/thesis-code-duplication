import java.io.*;
import java.util.Calendar;
import java.text.*;
import java.util.Date;

public class inFull
   implements Expense
{
   private Date date;
   private Amount paid;
   private String payee;
   private String category;

   public inFull(Date date, Amount paid, String payee, String category)
   {
      this.date = date;
      this.paid = paid;
      this.payee = payee;
      this.category = category;
   }

   public String getType()
   {
      return "in-full";
   }

   public Date getDate()
   {
      return this.date;
   }
   public Amount amountPaid()
   {
      return this.paid;
   }
   public String getPayee()
   {
      return this.payee;
   }
   public String getCategory()
   {
      return this.category;
   }
   public Amount getBalance()
      throws UnsupportedOperationException
   {
      throw new UnsupportedOperationException();
   }
}
