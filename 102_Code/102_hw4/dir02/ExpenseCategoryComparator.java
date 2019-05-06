import java.util.*;
public class ExpenseCategoryComparator
   implements Comparator<Expense>
{
   public int compare(Expense ex1, Expense ex2)
   {
      String cat1 = ex1.getCat().toLowerCase();
      String cat2 = ex2.getCat().toLowerCase();
      return cat1.compareTo(cat2);
   }
   public boolean equals(Object obj)
   {
      throw new UnsupportedOperationException("Operation not supported!");
   }
}
