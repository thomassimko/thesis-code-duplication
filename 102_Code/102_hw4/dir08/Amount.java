public class Amount
{
   private int dollars;
   private int cents;

   public Amount(int d, int c)
   {
      dollars = d;
      cents = c;
   }

   public int getDollars()
   {
      return dollars;
   }

   public int getCents()
   {
      return cents;
   }

   public String toString()
   {
      return String.format("%1$d.%2$02d", dollars, cents);
   }
}
