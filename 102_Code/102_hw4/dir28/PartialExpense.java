import java.util.Date;

public class PartialExpense
   implements Expense
{
   private Date date;
   private String category, payee;
   private int cents, dollars, remCents, remDollars;
   public PartialExpense(Date date, String category, String payee, int dollars, int cents, int remDollars, int remCents)
   {
      this.date=date;
      this.dollars=dollars;
      this.cents=cents;
      this.payee=payee;
      this.category=category;
      this.remDollars=remDollars;
      this.remCents=remCents;
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
      return this.remDollars;
   }
   public int getRemCents()
   {
      return this.remCents;
   }
   public String getRemAmountString()
   {
      return this.remDollars + "." + this.remCents;
   }
}