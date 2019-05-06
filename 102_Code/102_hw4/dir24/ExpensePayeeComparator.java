import java.io.*;
import java.util.*;
import java.util.Calendar;
import java.text.*;

public class ExpensePayeeComparator
   implements Comparator<Expense>
{

   public ExpensePayeeComparator()
   {
   }

   public int compare(Expense left, Expense right)
   {
      return left.getPayee().compareTo(right.getPayee());
   }

   public boolean equals()
      throws UnsupportedOperationException
   {
      throw new UnsupportedOperationException();
   }
}
