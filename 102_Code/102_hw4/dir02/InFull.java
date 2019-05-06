import java.util.*;
public class InFull
   implements Expense
{
   private int amountD;
   private int amountC;
   private String cat;
   private Calendar date;
   private String payee;
   private int balanceD = 0;
   private int balanceC = 0;
   public InFull(int amountD, int amountC, String cat, Calendar date, String payee)
   {
      this.amountD = amountD;
      this.amountC = amountC;
      this.cat = cat;
      this.payee = payee;
      this.date = date;
   }
   public int getAmountD()
   {
      return amountD;
   }
   public int getAmountC()
   {
      return amountC;
   }
   public String getCat()
   {
      return cat;
   }
   public Calendar getDate()
   {
      return date;
   }
   public String getPayee()
   {
      return payee;
   }
   public int getBalanceD()
   {
      return balanceD;
   }
   public int getBalanceC()
   {
      return balanceC;
   }
   public String toString()
   {
      return "in-full";
   }
}
