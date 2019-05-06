import java.text.*;
import java.io.*;
import java.util.*;
public class ExpenseTracker
{
   public static void main(String[] args)
   {
      List<Expense> expenseList;
      expenseList = initializeList();
      prompt(expenseList);
   }
   public static List<Expense> initializeList()
   {
      Scanner in = null;
      File expenseFile = null;
      List<Expense> expenseList = null;
      try
      {
         expenseFile = new File("StoredExpenses");
         if(!(expenseFile.exists()))
         {
            throw new FileNotFoundException();
         }
         in = new Scanner(expenseFile);
         expenseList = readFromFile(in, expenseList);
      }
      catch(FileNotFoundException e)
      {
         expenseList = new ArrayList<Expense>();
         System.out.println("File loaded.");
      }
      return expenseList;
   }

   public static List<Expense> readFromFile(Scanner in, List<Expense> expenseList)
   {
      
      expenseList = new ArrayList<Expense>();
      String type = null;
      String date = null;
      String amount = null;
      String payee = null;
      String cat = null;
      String balance = null;
      Expense expenseObject;
      try
      { 
          while(in.hasNext())
          {
             type = in.nextLine();
             if(type.equals("partial"))
             {
                date = in.nextLine();
                cat = in.nextLine();  
                payee = in.nextLine();
                amount = in.nextLine();
                balance = in.nextLine();
                expenseObject = parseExpenseData(expenseList, type, date, amount, payee, cat, balance);
                expenseList.add(expenseList.size(), expenseObject);
             }
             else if(type.equals("in-full"))
             {
                date = in.nextLine();
                cat = in.nextLine();
                payee = in.nextLine();
                amount = in.nextLine();
                expenseObject = parseExpenseData(expenseList, type, date, amount, payee, cat, "0.0");
                expenseList.add(expenseList.size(), expenseObject);
             }
             else
             {
                throw new NoSuchElementException();
             }
         }
         System.out.println("\nFile loaded.");
      }
      catch(NoSuchElementException e)
      {
         System.out.println("\nNot all contents were read from the file.");
      }
      return(expenseList);
   }

   public static Expense parseExpenseData(List<Expense> expenseList, String type, String date, String 
      amount, String payee, String cat, String balance)
   {
      Expense expenseObject = null;
      Calendar expenseDate = parseDate(date);
      int amountD = parseDollars(amount);
      int amountC = parseCents(amount);
      int balanceD = parseDollars(balance); 
      int balanceC = parseCents(balance);
      if(type.equals("in-full"))
      {
         expenseObject = new InFull(amountD, amountC, cat, expenseDate, payee);
      }
      else if(type.equals("partial"))
      {
         expenseObject = new Partial(amountD, amountC, cat, expenseDate, payee, balanceD, balanceC);
      }
      return expenseObject;       
   }

   public static Calendar parseDate(String date)
   {
      Calendar cal = null;
      try
      {
         DateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
         Date returnDate = formatter.parse(date);
         cal = Calendar.getInstance();
         cal.setTime(returnDate);
      }
      catch(ParseException e)
      {
         System.out.println("Error while parsing!");
      }
      return cal;
   }

   public static int parseDollars(String value)
   {
      return  Integer.parseInt(value.substring(0, value.indexOf('.')));
   }

   public static int parseCents(String value)
   {
      return Integer.parseInt(value.substring(value.indexOf('.') + 1, value.length()));
   }

   public static void displayExpenses(List<Expense> expenseList)
   {
      System.out.println("");
      for(Expense e: expenseList)
      {
         if(e instanceof InFull)
         {
            Money paid = new Money(e.getAmountD(), e.getAmountC());
            System.out.println(String.format("%1$2tm/%<2td/%<tY ", e.getDate()) 
               + String.format("%-15.15s %10s [%s]", e.getPayee(), paid.toString(), 
                  e.getCat()));
         }
         else
         {
            Money paid = new Money(e.getAmountD(), e.getAmountC());
            Money balance = new Money(e.getBalanceD(), e.getBalanceC());
            System.out.println(String.format("%1$2tm/%<2td/%<tY ", e.getDate())
               + String.format("%-15.15s %10s (%s) [%s]", e.getPayee(), 
                  paid.toString(), balance.toString(), e.getCat()));
         }   
      }
   }

   public static List<Expense> addExpenses(List<Expense> expenseList, Scanner in)
   {
      Expense expenseObject = null;
      String balance = "0.0";
      System.out.print("Expense type (in-full, partial)? ");
      String type = in.nextLine();
      System.out.print("Payment date: ");
      String date = in.nextLine();
      System.out.print("Expense Amount: ");
      String amount = in.nextLine();
      System.out.print("Who was this expense paid to? ");
      String payee = in.nextLine();
      System.out.print("Expense category: ");
      String cat = in.nextLine();
      if(type.equals("partial"))
      {
         System.out.print("Expense Balance: ");
         balance = in.nextLine();
         expenseObject = parseExpenseData(expenseList, type, date, amount, payee, cat, balance);
      }
      else if(type.equals("in-full"))
      {     
         expenseObject = parseExpenseData(expenseList, type, date, amount, payee, cat, balance);
      }
      expenseList.add(0, expenseObject);
      return expenseList;
   }

   public static List<Expense> sortExpenses(List<Expense> expenseList, Scanner in)
   {
      List<String> keyList = new ArrayList<String>();
      System.out.print("Keys to sort by: ");
      String keys = in.nextLine();
      Scanner keyReader = new Scanner(keys);
      try
      {
         while(keyReader.hasNext())
         {
            keys = keyReader.next();
            if(!(keys.equals("amount")) && !(keys.equals("category")) && !(keys.equals("date"))
                && !(keys.equals("payee")))
            {
               throw new NoSuchElementException();
            }
            keyList.add(0, keys);
         }
         Comparator<Expense> comparator = comparatorBuilder(keyList);
         Collections.sort(expenseList, comparator);
      }
      catch(NoSuchElementException e)
      {
         System.out.println("\nInvalid key input.");
      }
      catch(IndexOutOfBoundsException e)
      {
         System.out.println("\nNo input. Input a valid key.");
      }
      return expenseList;
   }

   public static Comparator<Expense> comparatorBuilder(List<String> keyList)
   {
      Comparator<Expense> comparator1 = null;
      Comparator<Expense> comparator2 = null;
      String key1 = keyList.remove(0);
      if(key1.equals("amount"))
      {
         comparator1 = new ExpenseAmountComparator();
      }
      else if(key1.equals("category"))
      {
         comparator1 = new ExpenseCategoryComparator();
      }
      else if(key1.equals("date"))
      {
         comparator1 = new ExpenseDateComparator();
      }
      else if(key1.equals("payee"))
      {
         comparator1 = new ExpensePayeeComparator();
      }
      for(int i = 0; i < keyList.size(); i++)
      {
         if(keyList.get(i).equals("amount"))
         {
            comparator2 = new ExpenseAmountDelegateComparator(comparator1);
            comparator1 = comparator2;
         }
         else if(keyList.get(i).equals("category"))
         {
            comparator2 = new ExpenseCategoryDelegateComparator(comparator1);
            comparator1 = comparator2;
         }
         else if(keyList.get(i).equals("date"))
         {
            comparator2 = new ExpenseDateDelegateComparator(comparator1);
            comparator1 = comparator2;
         }
         else if(keyList.get(i).equals("payee"))
         {
            comparator2 = new ExpensePayeeDelegateComparator(comparator1);
            comparator1 = comparator2;
         }
      }
      return comparator1;
   }
   
   public static void saveFile(List<Expense> expenseList)
   {
      File expenseFile = new File("StoredExpenses");
      PrintWriter expenseWriter = null;
      try
      {
         expenseWriter = new PrintWriter(expenseFile);
      }
      catch(FileNotFoundException e)
      {
         System.out.println("File not found");
      }
      for(Expense e: expenseList)
      {
         expenseWriter.println(e.toString());
         expenseWriter.println(String.format("%1$tm/%1$td/%1$tY", e.getDate()));
         expenseWriter.println(e.getCat());
         expenseWriter.println(e.getPayee());
         expenseWriter.println(e.getAmountD() + "." + e.getAmountC());
         if(e instanceof Partial)
         {
            expenseWriter.println(((Partial)e).getBalanceD() + "." + ((Partial)e).getBalanceC());
         }
      }
      expenseWriter.close();
      System.out.println("\nExpenses saved.");
   }

   public static void prompt(List<Expense> expenseList)
   {
      int choice = 0;
      Scanner in = new Scanner(System.in);
      while(true)
      {
         System.out.println("");
         System.out.println("1. Display");
         System.out.println("2. Add Expense");
         System.out.println("3. Sort");
         System.out.println("4. Save");
         System.out.println("5. Quit");
         System.out.println("");
         System.out.print("Enter choice: ");      
         try
         {
            choice = in.nextInt();
            in.nextLine();
         }
         catch(InputMismatchException e)
         {
            System.out.println("\nInvalid input.");
            prompt(expenseList);
         }
         switch(choice)
         {
            case 1: displayExpenses(expenseList);
            break;
            case 2: expenseList = addExpenses(expenseList, in);
            break;
            case 3: expenseList = sortExpenses(expenseList, in);
            break;
            case 4: saveFile(expenseList);
            break;
            case 5: 
            System.exit(0);
            break;
            default: System.out.println("\nInvalid input.");
         }         
      }
   }
}
