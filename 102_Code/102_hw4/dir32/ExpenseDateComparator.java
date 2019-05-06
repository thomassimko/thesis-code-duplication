import java.util.Comparator;
public class ExpenseDateComparator
   implements Comparator<Expense>
{   
   public int compare(Expense tacos, Expense burritos)
   {
      return (int)(tacos.getDate().getTime() - burritos.getDate().getTime());
   }
}
