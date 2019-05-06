import java.util.GregorianCalendar;
import java.util.Calendar;
import java.util.Date;

public class Partial
   implements Expenses
{
   Calendar eDate = Calendar.getInstance();
   private String payee;
   private String category;
   private int dollarsPaid;
   private int centsPaid;
   private int dollarsRemain;
   private int centsRemain;
   
    public Partial(Date eDate, String payee, String category, 
       int dollarsPaid, int centsPaid, int dollarsRemain, int centsRemain)
   {
      this.eDate.setTime(eDate);
      this.payee = payee;
      this.category = category;
      this.dollarsPaid = dollarsPaid;
      this.centsPaid = centsPaid;
      this.dollarsRemain = dollarsRemain;
      this.centsRemain = centsRemain;
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
   
   public String getBalanceRemain()
   {
      String change = Integer.toString(centsRemain);
      if (centsRemain == 0)
      {
         change = change + "0";
      }
   
   
      return Integer.toString(dollarsRemain) + "." + change;
   }
   
}