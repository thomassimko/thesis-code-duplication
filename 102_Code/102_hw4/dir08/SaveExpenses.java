import java.util.*;
import java.io.*;
import java.text.*;

public class SaveExpenses 
{
   public static void save(List<Expense> list, String filename)
   {
      PrintWriter prt;

      try
      {
         prt = new PrintWriter(new File(filename));

         for (Expense e : list)
         {
            prt.println(e.saveString());
         } 
      
         System.out.println("\nExpenses saved.");
      }
      catch (IOException e)
      {
         System.err.println("\nCould not open destination file.");
         return;
      }

      prt.close();
   }
}
