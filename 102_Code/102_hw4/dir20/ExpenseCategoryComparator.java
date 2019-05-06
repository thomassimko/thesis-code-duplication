import java.util.Comparator;

public class ExpenseCategoryComparator
  implements Comparator<Expenses>
  {
     public int compare(Expenses left, Expenses right)
     {
        return left.getCategory().compareTo(right.getCategory());
     }
  }