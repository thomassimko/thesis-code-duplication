import java.io.*;
import java.util.*;
import java.util.Calendar;
import java.text.*;

public class ExpenseDelegateComparator
   implements Comparator<Expense>
{
   private Comparator<Expense> left;
   private Comparator<Expense> right;

   public ExpenseDelegateComparator(Comparator<Expense> left, Comparator<Expense> right)
   {
      this.left = left;
      this.right = right;
   }
   
   public int compare(Expense left, Expense right)
   {
      int x = this.left.compare(left, right);
      if(x == 0)
      {
         x = this.right.compare(left, right);
      }
      return x;
   }
   
   public boolean equals()
      throws UnsupportedOperationException
   {
      throw new UnsupportedOperationException();
   }
}
