public class Money
{
   private int dollars;
   private int cents;
   public Money(int dollars, int cents)
   {
      this.dollars = dollars;
      this.cents = cents;
   }
   public String toString()
   {
      String dVal = "" + dollars;
      String cVal = "" + cents;
      if(Integer.parseInt(dVal) == 0)
      {
         dVal = "00";
      }
      if(Integer.parseInt(cVal) == 0)
      {
         cVal = "00";
      }
      return dVal + "." + cVal;
   }
}
