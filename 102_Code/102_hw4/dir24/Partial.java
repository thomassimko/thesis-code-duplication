import java.io.*;
import java.util.Calendar;
import java.text.*;
import java.util.Date;

public class Partial
   implements Expense
{
   private Date date;
   private Amount paid;
   private String payee;
   private String category;
   private Amount balance;

   public Partial(Date date, Amount paid, String payee, String category, Amount balance)
   {
      this.date = date;
      this.paid = paid;
      this.payee = payee;
      this.category = category;
      this.balance = balance;
   }
   
   public String getType()
   {
      return "Partial";
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
   {
      return this.balance;
   }
}
