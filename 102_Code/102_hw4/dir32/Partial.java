import java.io.*;
import java.util.*;
import java.lang.*;
import java.text.*;

public class Partial
   implements Expense
{
   private String paid_to;
   private int dollars;
   private int cents;
   private String category;
   private Date date;
   private int balanceDollars;
   private int balanceCents;

   public Partial(Date date, String category, String paid_to, int dollars, int cents, int balanceDollars, 
int balanceCents)
   {
      this.paid_to = paid_to;
      this.dollars = dollars;
      this.cents = cents;
      this.category = category;
      this.date = date;
      this.balanceDollars = balanceDollars;
      this.balanceCents = balanceCents;
   }

   public String getPaidString()
   {
      return ((Integer)dollars).toString() + "." + ((Integer)cents).toString();
   }

   public String getPayee()
   {
      return this.paid_to;
   }

   public int getDollars()
   {
      return this.dollars;
   }

   public int getCents()
   {
      return this.cents;
   }

   public String getCategory()
   {
      return this.category;
   }

   public Date getDate()
   {
      return this.date;
   }

   public int getBalanceDollars()
   {
      return this.balanceDollars;
   }

   public int getBalanceCents()
   {
      return this.balanceCents;
   }

   public String toBalanceString()
   {
      if(cents < 10 && cents >= 0)
      {
         return dollars + ".0" + cents;
      }
      return balanceDollars + "." + cents;
   }

   public String toString()
   {
      if(cents < 10 && cents >= 0)
      {
         return dollars + ".0" + cents;
      }
      return dollars + "." + cents;
   }

   public String toStringFile()
   {
      return "in-full\n" + getStringDate() + "\n" + category + "\n" + paid_to + "\n" + toString() + toBalanceString();
   }

   public String getStringDate()
   {
      return String.format("%1$2tm/%<2td/%<tY ", date);
   }

}
