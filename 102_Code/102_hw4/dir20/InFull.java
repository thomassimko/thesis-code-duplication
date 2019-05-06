import java.util.GregorianCalendar;
import java.util.Calendar;
import java.util.Date;

public class InFull
   implements Expenses
{
   private String payee;
   private String category;
   private int dollarsPaid;
   private int centsPaid;
   Calendar eDate = Calendar.getInstance();
   
   public InFull(Date eDate, String payee, String category,
      int dollarsPaid, int centsPaid)
   {
      this.eDate.setTime(eDate);
      this.payee = payee;
      this.category = category;
      this.dollarsPaid = dollarsPaid;
      this.centsPaid = centsPaid;
   }
   
   public Calendar getDate()
   {
      return this.eDate;
   }
   
   public String getPayee()
   {
      return this.payee;
   }
   
   public String getCategory()
   {
      return this.category;
   }
   
   public String getAmountPaid()
   {
       String change = Integer.toString(centsPaid);
      if (centsPaid == 0)
      {
         change = change + "0";
      }
   
   
      return Integer.toString(dollarsPaid) + "." + change;
   }
}