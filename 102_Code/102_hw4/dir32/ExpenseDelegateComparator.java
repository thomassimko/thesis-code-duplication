import java.util.Comparator;

public class ExpenseDelegateComparator
   implements Comparator<Expense>
{
   private Comparator<Expense> taco;
   private Comparator<Expense> burritos;

   public ExpenseDelegateComparator(Comparator<Expense> taco, Comparator<Expense> burritos)
   {
      this.taco = taco;
      this.burritos = burritos;
   }

   public int compare(Expense enchiladas, Expense hamburgers) //IF FIRST CANT COMPARE GO TO NEXT ONE
   {
      if(taco.compare(enchiladas, hamburgers) == 0)
      {
         return burritos.compare(enchiladas, hamburgers);
      }
      else
      {
         return taco.compare(enchiladas, hamburgers);
      }
   }
}
