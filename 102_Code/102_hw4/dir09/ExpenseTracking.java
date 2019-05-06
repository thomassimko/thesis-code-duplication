import java.util.*;
import java.text.*;
import java.io.*;

public class ExpenseTracking
{
   public static void main(String [] args)
   {
      choiceScreen();
   }
	
   private static void choiceScreen()
   {
      int choice = 0;
      Scanner s = new Scanner(System.in);
      List<Expense> list = new ArrayList<Expense>();
      loadFile(list);
      while(choice != 5)
      {
         System.out.println("");
         System.out.println("1. Display");
         System.out.println("2. Add Expense");
	 System.out.println("3. Sort");
         System.out.println("4. Save");
         System.out.println("5. Quit");
         System.out.println("");
	 System.out.print("Enter choice: ");
	 choice = s.nextInt();
	 s.nextLine();
		
	 if(choice == 1) display(list);
	 else if(choice == 2) add(s, list);
	 else if(choice == 3) sort(s, list);
	 else if(choice == 4) save(list);
	 else if(choice == 5) return;
	 else System.err.println("Error: choice must be between 1 and 5");
      }
   }
	
   private static void loadFile(List<Expense> list)
   {
      try
      {
         Scanner s = new Scanner(new File("StoredExpenses"));
         DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
         while(s.hasNextLine())
         {
            String type = s.nextLine();
            String temp = s.nextLine();
            Date date = parseDate(df, temp);
            String category = s.nextLine();
            String payee = s.nextLine();
            String paid = s.nextLine();
            int paidDollar = getDollar(paid);
            int paidCent = getCent(paid);
            if(type.equals("partial"))
            {
	       String remaining = s.nextLine();
	       int remainingDollar = getDollar(remaining);
	       int remainingCent = getCent(remaining);
	       list.add(new Partial(date, paidDollar, paidCent, payee, category, remainingDollar, remainingCent));
	    }
	    else
            {
	       list.add(new InFull(date, paidDollar, paidCent, payee, category));
	    }
         }
         System.out.println("File Loaded");
      }
      catch(FileNotFoundException e)
      {
         System.err.println("File not found. Continuing with an empty list of expenses.");
      }
      catch(ParseException e)
      {
         System.err.println("Error parsing date.");
      }
   }
      
   private static void display(List<Expense> list)
   {
      int size = list.size();
      System.out.println("");
      for(int i=0;i<size;i++)
      {
         System.out.println(list.get(i).toString());
      }  
   }
	
   private static void add(Scanner s, List<Expense> list)
   {
      System.out.print("Expense type (in-full, partial)? ");
      String expenseType = s.next();
      
      System.out.print("Payment date: ");
      String str = s.next();
      DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
		
      System.out.print("Expense amount: ");
      String temp = s.next();
      int paidDollar = getDollar(temp);
      int paidCent = getCent(temp);
		
      System.out.print("Who was this expense paid to? ");
      String payee = s.next();
		
      System.out.print("Expense category: ");
      String category = s.next();
		
      try
      {
         if(expenseType.equals("in-full"))
         {
            Date date = parseDate(df, str);
            Expense inFull = new InFull(date, paidDollar, paidCent, payee, category);
	    list.add(inFull);
         }
         else if(expenseType.equals("partial"))
         {
            Date date = parseDate(df, str);
            System.out.print("Expense balance: ");
	    String temp2 = s.next();
            int remainingDollar = getDollar(temp2);
            int remainingCent = getCent(temp2);
 	    Expense partial = new Partial(date, paidDollar, paidCent, payee, category, remainingDollar, remainingCent);
	    list.add(partial);
         }
         else System.err.println("Invalid expense type");
      }
      catch(ParseException e)
      {
         System.err.println("Incorrect format for date. Please enter it again.");
      }
   }
	
   private static void sort(Scanner s, List<Expense> list)
   {
      List<String> keys = new ArrayList<String>();
      Comparator<Expense> comp;
      System.out.print("Keys to sort by: ");
      String str = s.nextLine();
      Scanner s2 = new Scanner(str);
      keys.add(0, s2.next());
      if(s2.hasNext()) keys.add(0, s2.next());
      if(s2.hasNext()) keys.add(0, s2.next());
      if(s2.hasNext()) keys.add(0, s2.next());
      int size = keys.size();
      
      if(keys.get(0).equals("amount")) comp = new ExpenseAmountComparator();
      else if(keys.get(0).equals("category")) comp = new ExpenseCategoryComparator();
      else if(keys.get(0).equals("payee")) comp = new ExpensePayeeComparator();
      else if(keys.get(0).equals("date")) comp = new ExpenseDateComparator();
      else
      {
         System.err.println("Invalid key.");
         return;
      }
      
      for(int i=1;i<size;i++)
      {
         if(keys.get(i).equals("amount"))
         {
            comp = new ExpenseAmountDelegateComparator(comp);
         }
         else if(keys.get(i).equals("category"))
         {
            comp = new ExpenseCategoryDelegateComparator(comp);
         }
         else if(keys.get(i).equals("payee"))
         {
            comp = new ExpensePayeeDelegateComparator(comp);
         }
         else if(keys.get(i).equals("date"))
         {
            comp = new ExpenseDateDelegateComparator(comp);
         }
	 else
	 {
	    System.err.println("Invalid key.");
	    return;
	 }
      }
      Collections.sort(list, comp);
   }
	
   private static void save(List<Expense> list)
   {
      try
      {
         PrintWriter writer = new PrintWriter(new File("StoredExpenses"));
         int size = list.size();
         for(Expense e : list)
         {
            writer.println(e.getType());
            writer.println(String.format("%1$2tm/%<2td/%<tY ", e.date()));
            writer.println(e.category());
            writer.println(e.payee());
            writer.println(e.paid());
            if(e instanceof Partial)
            {
               writer.println(((Partial)e).remaining());
            }
         }
       	 writer.close();
         System.out.println("");
         System.out.println("Expenses Saved.");
      }
      catch(FileNotFoundException e)
      {
         System.err.println("File not found. Saving unsuccessful.");
      }
   }

   private static Date parseDate(DateFormat df, String str) throws ParseException
   {
      Date d = df.parse(str);
      Calendar c = Calendar.getInstance();
      c.setTime(d);
      return d;
   }

   private static int getDollar(String str)
   {
      int i = str.indexOf(".");
      return Integer.parseInt(str.substring(0, i));
   }

   private static int getCent(String str)
   {
      int i = str.indexOf(".");
      return Integer.parseInt(str.substring(i+1));
   }
}
 
