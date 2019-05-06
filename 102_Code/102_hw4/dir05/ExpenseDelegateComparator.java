import java.util.Comparator;

public class ExpenseDelegateComparator
   implements Comparator<Expense>
{
   Comparator<Expense> first;
   Comparator<Expense> second;
   public ExpenseDelegateComparator(Comparator<Expense> first, Comparator<Expense> second)
   {
      this.first = first;
      this.second = second;
   }
   public int compare(Expense one, Expense two)
   {
      return first.compare(one, two) - second.compare(one,two);
   }
}