import java.io.*;
import java.util.*;
import java.util.Calendar;
import java.text.*;

public class ExpenseAmountComparator
   implements Comparator<Expense>
{

   public ExpenseAmountComparator()
   {
   }
   
   public int compare(Expense left, Expense right)
   {
      if(left.amountPaid().getDollar() < right.amountPaid().getDollar())
      {
         return -1;
      }
      else if(left.amountPaid().getDollar() > right.amountPaid().getDollar())
      {
         return 1;
      }
      else if(left.amountPaid().getCent() < right.amountPaid().getCent())
      {
         return -1;
      }
      else if(left.amountPaid().getCent() > right.amountPaid().getCent())
      {
         return 1;
      }
      else
      {
         return 0;
      }
   }
   
   public boolean equals()
      throws UnsupportedOperationException
   {
      throw new UnsupportedOperationException();
   }
}
