import java.util.Comparator;

public class ExpenseDateComparator
  implements Comparator<Expenses>
  {
     public int compare(Expenses left, Expenses right)
     {
        return left.getDate().compareTo(right.getDate());
     }
  }