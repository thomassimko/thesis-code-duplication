import java.util.*;
public class Partial
   implements Expense
{
   private int amountD;
   private int amountC;
   private String cat;
   private Calendar date;
   private String payee;
   private int balanceD;
   private int balanceC;
   public Partial(int amountD, int amountC, String cat, Calendar date, String payee, int balanceD, int 
balanceC)
   {
      this.amountD = amountD;
      this.amountC = amountC;
      this.cat = cat;
      this.payee = payee;
      this.date = date;
      this.balanceD = balanceD;
      this.balanceC = balanceC;
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
      return "partial";
   }
}
