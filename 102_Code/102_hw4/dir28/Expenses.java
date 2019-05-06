import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Expenses
{
   private static List<Expense> expenses = new ArrayList<Expense>();
   private static File expensesFile = new File("StoredExpenses");
   
   private static void readInFile()
   {
      try
      {
         Scanner in = new Scanner(expensesFile);
         while(in.hasNextLine())
         {
            String type = in.nextLine();
            String date = in.nextLine();
            DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
            Date d = df.parse(date);
            Calendar c = Calendar.getInstance();
            c.setTime(d);
            String category = in.nextLine();
            String payee = in.nextLine();
            String amount = in.nextLine();
            String[] parts;
            parts = amount.split("[.]");
            int dollars = Integer.parseInt(parts[0]);
            int cents = Integer.parseInt(parts[1]);
            if(type.equals("in-full"))
            {
               expenses.add(new InFullExpense(d, category, payee, dollars, cents));
            }
            else if(type.equals("partial"))
            {
               String amountRem = in.nextLine();
               String[] partsRem;
               partsRem = amountRem.split("[.]");
               int dollarsRem = Integer.parseInt(partsRem[0]);
               int centsRem = Integer.parseInt(partsRem[1]);
               expenses.add(new PartialExpense(d, category, payee, dollars, cents, dollarsRem, centsRem));
            }
            else
            {
               System.err.println("Error: Incompatible Expense Type");
            }
         }
         System.out.println("File Loaded");
      }
      catch(FileNotFoundException e)
      {
         System.out.println("No Save File Exists");
      }
      catch (ParseException e)
      {
         System.err.println("Error reading file. Not all expenses were read from file.");
      }
   }
   
   private static void addExpense()
   {
      Scanner in = new Scanner(System.in);
      System.out.print("Expense type (in-full, partial)? ");
      String type = in.nextLine();
      if(!(type.equals("in-full") || type.equals("partial")))
      {
         System.err.println("Error: Must be of type 'in-full' or 'partial'.");
         return;
      }
      else
      {
         System.out.print("Payment date: ");
         String date = in.nextLine();
         DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
         Date d = null;
         try
         {
            d = df.parse(date);
            Calendar c = Calendar.getInstance();
            c.setTime(d);
         }
         catch(ParseException e)
         {
            System.err.println("Error: Incorrect Date Format.");
            return;
         }
         System.out.print("Expense Amount: ");
         String amount = in.nextLine();
         String[] parts;
         parts = amount.split("[.]");
         int dollars = Integer.parseInt(parts[0]);
         int cents = Integer.parseInt(parts[1]);
         System.out.print("Who was this expense paid to? ");
         String payee = in.nextLine();
         System.out.print("Expense category: ");
         String category = in.nextLine();
         if(type.equals("partial"))
         {
            System.out.print("Expense Balance: ");
            String amountRem = in.nextLine();
            String[] partsRem;
            partsRem = amountRem.split("[.]");
            int dollarsRem = Integer.parseInt(partsRem[0]);
            int centsRem = Integer.parseInt(partsRem[1]);
            expenses.add(new PartialExpense(d, category, payee, dollars, cents, dollarsRem, centsRem));
         }
         else
         {
            expenses.add(new InFullExpense(d, category, payee, dollars, cents));
         }
      }
   }
   
   private static void sortExpenses()
   {
      Scanner in = new Scanner(System.in);
      System.out.print("Keys to sort by: ");
      String choices = in.nextLine();
      String[] parts = choices.split("\\s+");
      Comparator<Expense> comp = null;
      for(int i = parts.length-1; i >= 0; i--)
      {
         if(parts[i].equals("amount"))
         {
            if(comp == null)
            {
               comp = new ExpenseAmountComparator();
            }
            else
            {
               comp = new ExpenseAmountDelegateComparator(comp);
            }
         }
         else if(parts[i].equals("category"))
         {
            if(comp == null)
            {
               comp = new ExpenseCategoryComparator();
            }
            else
            {
               comp = new ExpenseCategoryDelegateComparator(comp);
            }
         }
         else if(parts[i].equals("date"))
         {
            if(comp == null)
            {
               comp = new ExpenseDateComparator();
            }
            else
            {
               comp = new ExpenseDateDelegateComparator(comp);
            }
         }
         else if(parts[i].equals("payee"))
         {
            if(comp == null)
            {
               comp = new ExpensePayeeComparator();
            }
            else
            {
               comp = new ExpensePayeeDelegateComparator(comp);
            }
         }
         else
         {
            System.err.println("Error: Invalid Key(s)");
            return;
         }
         Collections.sort(expenses, comp);
      }
   }
   
   private static void saveExpenses()
   {
      try
      {
         PrintWriter out = new PrintWriter(expensesFile);
         int size = expenses.size();
         for(int i = 0; i < size; i++)
         {
            Expense e = expenses.get(i);
            if(e instanceof InFullExpense)
            {
               out.println("in-full");
            }
            else
            {
               out.println("partial");
            }
            out.println(String.format("%1$2tm/%<2td/%<tY ", e.getDate()));
            out.println(e.getCategory());
            out.println(e.getPayee());
            out.println(e.getAmountString());
            if(e instanceof PartialExpense)
            {
               out.println(e.getRemAmountString());
            }
         }
         out.close();
         System.out.println();
         System.out.println("Expenses Saved");
      }
      catch(FileNotFoundException e)
      {
         System.err.println("Error: Save File Not Found");
      }
   }
   
   private static void uiPrompt()
   {
      System.out.println();
      System.out.println("1. Display\n2. Add Expense\n3. Sort\n4. Save\n5. Quit");
      System.out.println();
   }
   
   private static void userInput()
   {
      Scanner in = new Scanner(System.in);
      uiPrompt();
      System.out.print("Enter choice: ");
      int choice = in.nextInt();
      System.out.println();
      while(choice != 5)
      {
         if(choice == 1)
         {
            printOutExpenses(expenses);
         }
         else if(choice == 2)
         {
            addExpense();
         }
         else if(choice == 3)
         {
            sortExpenses();
         }
         else if(choice == 4)
         {
            saveExpenses();
         }
         else
         {
            System.err.println("Error: Not a valid choice.");
         }
         uiPrompt();
         System.out.print("Enter choice: ");
         choice = in.nextInt();
      }
   }
   
   private static void printOutExpenses(List<Expense> list)
   {
      int size = list.size();
      for(int i = 0; i < size; i++)
      {
         Expense e = list.get(i);
         if(e instanceof InFullExpense)
         {
            System.out.println(String.format("%1$2tm/%<2td/%<tY ", e.getDate()) + String.format("%-15.15s %10s [%s]", e.getPayee(), e.getAmountString(), e.getCategory()));
         }
         else if(e instanceof PartialExpense)
         {
            System.out.println(String.format("%1$2tm/%<2td/%<tY ", e.getDate()) + String.format("%-15.15s %10s (%s) [%s]", e.getPayee(), e.getAmountString(), e.getRemAmountString(), e.getCategory()));
         }
         else
         {
            System.err.println("Error: Expense Type Not Recognized");
         }
      }
   }
   
   public static void main(String[] args)
   {
      readInFile();
      userInput();
   }
}
