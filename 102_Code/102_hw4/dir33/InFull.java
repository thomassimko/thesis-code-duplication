import java.util.Calendar;
import java.text.Format;

public class InFull
   implements Expense
{
   private Calendar date;
   private String category;
   private String payee;
   private Amount paid;

   public InFull(Calendar date, String category, String payee, Amount paid)
   {
      this.date = date;
      this.category = category;
      this.payee = payee;
      this.paid = paid;
   }

   public String print()
   {
      return String.format("%1$2tm/%<2td/%<tY ", date)
         + String.format("%-15.15s %s [%s]", payee, paid.toString(), category);
   }

   public String fileFormat()
   {
      return "in-full\n" + String.format("%1$2tm/%<2td/%<tY ", this.date) + "\n" + this.category + "\n" + this.payee + "\n" + this.paid.toString();
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

   public String getType()
   {
      return "in-full";
   }
}
