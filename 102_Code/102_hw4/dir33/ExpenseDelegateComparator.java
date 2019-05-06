import java.util.Comparator;

public class ExpenseDelegateComparator
   implements Comparator<Expense>
{
   private Comparator<Expense> first;
   private Comparator<Expense> second;

   public ExpenseDelegateComparator(Comparator<Expense> first, Comparator<Expense> second)
   {
      this.first = first;
      this.second = second;
   }

   public int compare(Expense one, Expense two)
   {
      int val = this.first.compare(one, two);   
      
      if (val == 0)
      {
         val = this.second.compare(one, two);
      }

      return val;
   }
}
