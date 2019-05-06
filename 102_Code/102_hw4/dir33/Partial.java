import java.util.Calendar;
import java.text.Format;

public class Partial
   implements Expense
{
   private Calendar date;
   private String category;
   private String payee;
   private Amount paid;
   private Amount remaining;

   public Partial(Calendar date, String category, String payee, Amount paid, Amount remaining)
   {
      this.date = date;
      this.category = category;
      this.payee = payee;
      this.paid = paid;
      this.remaining = remaining;
   }

   public String print()
   {
      return String.format("%1$2tm/%<2td/%<tY ", date)
         + String.format("%-15.15s %s (%s) [%s]",
            payee, paid.toString(), remaining.toString(), category);
   }

   public String fileFormat()
   {
      return "partial\n" + String.format("%1$2tm/%<2td/%<tY ", this.date) + "\n" + this.category + "\n" + this.payee + "\n" + this.paid.toString() + "\n" + this.remaining.toString();
   }

   public Calendar getDate()
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

   public Amount getPaid()
   {
      return this.paid;
   } 

   public Amount getRemaining()
   {
      return this.remaining;
   }

   public String getType()
   {
      return "partial";
   }
}
