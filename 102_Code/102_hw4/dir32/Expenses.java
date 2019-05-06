import java.lang.*;
import java.util.*;
import java.text.*;
import java.io.*;

public class Expenses
{
   private static String choice = "tacos";
   private static String expense_type;
   private static String paid_to;
   private static String category;
   private static Expense Infull;
   private static Expense Partial;
   private static String amountpaid;
   private static String balance;
   private static Scanner user_input = new Scanner(System.in);
   private static List<Expense> expense_list = new ArrayList<Expense>();
   private static String dollarsString;
   private static String centsString;
   private static int dollars;
   private static int cents;
   private static int balanceDollars;
   private static int balanceCents;
   private static String balanceDollarsString;
   private static String balanceCentsString;
   private static String balanceString;
   private static String dateString;
   private static Date date;
   private static Scanner scan = null;
	
   public Expenses(Expense Infull, Expense Partial)
   {
      this.Infull = Infull;
      this.Partial = Partial;
   }
   
   public static void main(String args[])
   {      
      loadfile();

      while(!choice.equals("5"))
      {
         System.out.println("1. Display\n2. Add Expense\n3. Sort\n4. Save\n5. Quit\n\nEnter choice: ");
         choice = user_input.next();

         if(choice.equals("1")) //DISPLAY
         {
           display();
         }
         if(choice.equals("2")) //ADD EXPENSE
         {
            addExpense();
         }
         if(choice.equals("3")) //SORT
         {
            sort(expense_list);
         }
         if(choice.equals("4")) //SAVE
         {
            save(expense_list);
         }
         if(choice.equals("5")) //QUIT
         {
            System.exit(1);
         }
      }
   }

   public static void loadfile()
   {
         try
         {
            scan = new Scanner(new File("StoredExpenses.txt"));
         }
         catch(FileNotFoundException e)
         {
            System.out.println("Please add a StoredExpenses.txt file.");
         }

         String storedBalanceString = null;
         int atDecimal;
         DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
         Calendar c = Calendar.getInstance();
         while(scan.hasNextLine())
         {
            String storedTypeString = scan.nextLine();
            if(storedTypeString.equals("in-full"))
            {
               String dateString = scan.nextLine();
               String storedCategoryString = scan.nextLine();
               String paid_to = scan.nextLine();
               String amountpaid = scan.nextLine();
            }
            else if(storedTypeString.equals("partial"))
            {
               String dateString = scan.nextLine();
               String storedCategoryString = scan.nextLine();
               String paid_to = scan.nextLine();
               String amountpaid = scan.nextLine();
               String balance = scan.nextLine();
            }
            else
            {
               System.err.println("File no es aqui.");
            }
            
            atDecimal = amountpaid.indexOf(".");
            dollarsString = amountpaid.substring(0, atDecimal);
            centsString = amountpaid.substring(atDecimal + 1);
            dollars = Integer.parseInt(dollarsString);
            cents = Integer.parseInt(centsString);

            atDecimal = balance.indexOf(".");
            balanceDollarsString = balance.substring(0, atDecimal);
            balanceCentsString = balance.substring(atDecimal + 1);
            balanceDollars = Integer.parseInt(balanceDollarsString);
            balanceCents = Integer.parseInt(balanceCentsString);

            try
            {
               date = df.parse(dateString);
            }
            catch(ParseException e)
            {
               System.out.println("Date not found");
            }
            c.setTime(date);

            if(storedTypeString.equals("in-full"))
            {
               expense_list.add(new Infull(date, category, paid_to, dollars, cents));
            }
            else if(storedTypeString.equals("partial"))
            {
               expense_list.add(new Partial(date, category, paid_to, dollars, cents, balanceDollars, 
balanceCents));
            }
         }
       System.out.println("File Loaded\n");
   }

   public static void display()
   {
      for(Expense tacos : expense_list)
      {
         if(tacos instanceof Infull)
         {
            System.out.println(String.format("%1$2tm/%<2td/%<tY ", tacos.getDate()) + 
String.format("%-15.15s %10s [%s]", tacos.getPayee(), tacos.getPaidString(), tacos.getCategory()));
         }
         else
         {
             System.out.println(String.format("%1$2tm/%<2td/%<tY ", tacos.getDate()) +
String.format("%-15.15s %10s (%s) [%s]", tacos.getPayee(), tacos.getPaidString(), tacos.getCategory()));

         }
      }
   }

   public static void addExpense()
   {  
      int atDecimal;
      DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
      Calendar c = Calendar.getInstance();

      System.out.print("Expense type (in-full, partial)? ");
      expense_type = user_input.next();
      if(expense_type.equals("in-full"))
      {
         System.out.print("Payment date: ");
         dateString = user_input.next();
         try
         {
            date = df.parse(dateString);
         }
         catch(ParseException e)
         {
            System.out.println("Date not found");
         }
         c.setTime(date);

         System.out.print("Expense Amount: ");
         amountpaid = user_input.next();

         atDecimal = amountpaid.indexOf(".");
         dollarsString = amountpaid.substring(0, atDecimal);
         centsString = amountpaid.substring(atDecimal + 1);
         dollars = Integer.parseInt(dollarsString);
         cents = Integer.parseInt(centsString);
      
         System.out.print("To whom was this expense paid? ");
         paid_to = user_input.next();

         System.out.print("Expense category: ");
         category = user_input.next();

         expense_list.add(new Infull(date, category, paid_to, dollars, cents));
      }
      else if(expense_type.equals("partial"))
      {
         System.out.print("Payment date: ");
         dateString = user_input.next();
         try
         {
            date = df.parse(dateString);
         }
         catch(ParseException e)
         {
            System.out.println("Date not found");
         }
         c.setTime(date);

         System.out.print("Expense Amount: ");
         amountpaid = user_input.next();

         atDecimal = amountpaid.indexOf(".");
         dollarsString = amountpaid.substring(0, atDecimal);
         centsString = amountpaid.substring(atDecimal + 1);
         dollars = Integer.parseInt(dollarsString);
         cents = Integer.parseInt(centsString);

         System.out.print("To whom was this expense paid? ");
         paid_to = user_input.next();

         System.out.print("Expense category: ");
         category = user_input.next();
         
         System.out.print("Expense balance: ");
         balanceString = user_input.next();

         atDecimal = balanceString.indexOf(".");
         balanceDollarsString = balanceString.substring(0, atDecimal);
         balanceCentsString = balanceString.substring(atDecimal + 1);
         balanceDollars = Integer.parseInt(balanceDollarsString);
         balanceCents = Integer.parseInt(balanceCentsString);

       	 expense_list.add(new Partial(date, category, paid_to, dollars, cents, balanceDollars, 
balanceCents));
      }
      else
      {
       	 System.err.println("Error: Invalid command, please check syntax.");
      }
   }

   public static void save(List expense_list)
   {
      PrintWriter writer = null;
            
      try
      {
         writer = new PrintWriter(new File("StoredExpenses.txt"));
      }
      catch(FileNotFoundException e)
      {
         System.out.println("Woah bro, no file.");
         System.exit(-1);
      }

      for(int i=0; i < expense_list.size(); i++)
      {
         Expense cur = (Expense)expense_list.get(i);
         writer.println(cur.toStringFile());
      }
      writer.close();
   }

   public static void sort(List expense_list)
   {
   
   }   
}
