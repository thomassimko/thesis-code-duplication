import java.util.Date;

public class InFullExpense
   implements Expense
{
   private Date date;
   private String category, payee;
   private int cents, dollars;
   public InFullExpense(Date date, String category, String payee, int dollars, int cents)
   {
      this.date=date;
      this.dollars=dollars;
      this.cents=cents;
      this.payee=payee;
      this.category=category;
   }
   public Date getDate()
   {
      return this.date;
   }
   public String getCategory()
   {
      return this.category;
   }
   public int getCents()
   {
      return this.cents;
   }
   public int getDollars()
   {
      return this.dollars;
   }
   public String getPayee()
   {
      return this.payee;
   }
   public String getAmountString()
   {
      return this.dollars + "." + this.cents;
   }
   public int getRemDollars()
   {
      throw new UnsupportedOperationException();
   }
   public int getRemCents()
   {
      throw new UnsupportedOperationException();
   }
   public String getRemAmountString()
   {
      throw new UnsupportedOperationException();
   }
}