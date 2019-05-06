import java.io.*;
import java.util.*;
import java.util.Calendar;
import java.text.*;

public class ExpenseCategoryComparator
   implements Comparator<Expense>
{

   public ExpenseCategoryComparator()
   {
   }
   
   public int compare(Expense left, Expense right)
   {
      return left.getCategory().compareTo(right.getCategory());
   }
   
   public boolean equals()
      throws UnsupportedOperationException
   {
      throw new UnsupportedOperationException();
   }
}
