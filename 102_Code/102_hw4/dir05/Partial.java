import java.util.Date;

public class Partial implements Expense
{
   private Date date;
   private String category;
   private String payee;
   private int famount;
   private int samount;
   private int fremaining;
   private int sremaining;
   
   public Partial(Date date, String category, String payee, int famount, 
            int samount, int fremaining, int sremaining)
   {
      this.date = date;
      this.category = category;
      this.payee = payee;
      this.famount = famount;
      this.samount = samount;
      this.fremaining = fremaining;
      this.sremaining = sremaining;
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
      return this.fremaining;
   }
   public int getSRemaining()
   {
      return this.sremaining;
   }
}