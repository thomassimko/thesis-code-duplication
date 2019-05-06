import java.util.Date;
import java.lang.UnsupportedOperationException;

public class InFull implements Expense
{
   private Date date;
   private String category;
   private String payee;
   private int famount;
   private int samount;
   
   public InFull(Date date, String category, String payee, int famount, int samount)
   {
      this.date = date;
      this.category = category;
      this.payee = payee;
      this.famount = famount;
      this.samount = samount;
   }
   public Date getDate()
   {
      return this.date;
   }
   public String getCategory()
   {
      return this.category;
   }
   public String getPayee()
   {
      return this.payee;
   }
   public int getFAmount()
   {
      return this.famount;
   }
   public int getSAmount()
   {
      return this.samount;
   }
   public int getFRemaining()
   {
      throw new UnsupportedOperationException();
   }
   public int getSRemaining()
   {
      throw new UnsupportedOperationException();
   }
}