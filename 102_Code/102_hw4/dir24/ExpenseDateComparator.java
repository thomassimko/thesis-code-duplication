import java.io.*;
import java.util.*;
import java.util.Calendar;
import java.text.*;

public class ExpenseDateComparator
   implements Comparator<Expense>
{

   public ExpenseDateComparator()
   {

   }
   
   public int compare(Expense first, Expense second)
   {
      return first.getDate().compareTo(second.getDate());
   }
   
   public boolean equals()
      throws UnsupportedOperationException
   {
      throw new UnsupportedOperationException();
   }
}
