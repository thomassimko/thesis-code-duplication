import java.util.Comparator;

public class ExpensePayeeComparator
  implements Comparator<Expenses>
  {
     public int compare(Expenses left, Expenses right)
     {
        return left.getPayee().compareTo(right.getPayee());
     }
  }