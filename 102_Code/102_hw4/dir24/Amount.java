public class Amount
{
   private int dollar;
   private int cent;
   
   public Amount(String amount)
   {

      int i;
      for(i = 0; amount.charAt(i) != '.'; i++)
      {
      }
      String toDollar = amount.substring(0, i);
      String toCent = amount.substring(i+1);
/*
      String[] money = amount.split(".");
      String toDollar = money[0];
      String toCent = money[1];
*/
      this.dollar = Integer.parseInt(toDollar);
      this.cent = Integer.parseInt(toCent);
   }
   
   public int getDollar()
   {
      return this.dollar;
   }
   
   public int getCent()
   {
      if(this.cent < 10)
      {
         return this.cent * 10;
      }
      return this.cent;
   }
}
