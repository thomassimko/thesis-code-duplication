import java.util.*;
public class ExpensePayeeComparator
   implements Comparator<Expense>
{
   public int compare(Expense ex1, Expense ex2)
   {
      String payee1 = ex1.getPayee().toLowerCase();
      String payee2 = ex2.getPayee().toLowerCase();
      return payee1.compareTo(payee2);
   }
   public boolean equals(Object obj)
   {
      throw new UnsupportedOperationException("Operation not supported!");
   }
}
