public class Amount
{
   private int coins;
   private int dollars;

   public Amount(int coins, int dollars)
   {
      this.coins = coins;
      this.dollars = dollars;
   }

   public String toString()
   {
      if (this.coins == 0)
      {
         return this.dollars + ".00";
      }

      return this.dollars + "." + this.coins;
   }

   public int getTotalCents()
   {
      return this.dollars*100 + this.coins;
   }
}
