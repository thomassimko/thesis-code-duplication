import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.text.SimpleDateFormat;
import java.text.DateFormat;
import java.util.Date;
import java.util.Calendar;
import java.text.ParseException;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Comparator;
import java.util.Collections;
import java.lang.NumberFormatException;
import java.util.NoSuchElementException;
import java.util.InputMismatchException;

public class ExpenseTracker
{
   public static void main(String[] args)
   {
      List<Expense> list = new ArrayList<Expense>();
      boolean check = false;

      try
      {
         File StoredExpenses = new File("StoredExpenses");
         Scanner scanner = new Scanner(StoredExpenses);

         while (scanner.hasNext())
         {
            String next = scanner.next();

            if (next.equals("in-full"))
            {
               check = true;
               list.add(scanInFull(scanner));
            }
            else if (next.equals("partial"))
            {
               check = true;
               list.add(scanPartial(scanner));
            }
            else
            {
               throw new IncorrectFileFormatException();
            }
         }

         if (check == true)
         {
            System.out.println("File loaded");
         }
      }
      catch (FileNotFoundException e)
      {
         System.err.println("No file exists with the name 'StoredExpenses'!");
      }
      catch (ParseException e)
      {
         System.err.println("Parse exception, incorrect date format has been entered!");
      }
      catch (IncorrectFileFormatException e)
      {
         System.err.println("File input is in the incorrect format, not all expenses were read!");
      }
      catch (NumberFormatException e)
      {
         System.err.println("File input for amount is incorrect, not all expenses were read!");
      }
      catch (NoSuchElementException e)
      {
         System.err.println("File input is missing a line, not all expenses were read!");
      }

      try
      {
         Scanner system = new Scanner(System.in);
         PrintWriter print = new PrintWriter("StoredExpenses");

         int response;

         do
         {
            System.out.println("\n1. Display \n2. Add Expense \n3. Sort \n4. Save \n5. Quit\n");
            System.out.print("Enter choice: ");

            response = system.nextInt();

            if (response == 1)
            {
               displayExpenses(list);
            }
            else if (response == 2)
            {
               try
               {
                  list = addExpense(list, system);
               }
               catch (NumberFormatException e)
               {
                  System.err.println("Entered incorrect format for a number.");
               }
               catch (ParseException e)
               {
                  System.out.println("Parse exception!");         
               }
            }
            else if (response == 3)
            {
               list = sortList(list, system);
            }
            else if (response == 4)
            {
               for (int i = 0; i < list.size(); i++)
               {
                  print.write(list.get(i).fileFormat() + "\n");               
               }

               System.out.println("\nExpenses Saved");

            }
         } while (response == 1 || response == 2 || response == 3 || response == 4);

         print.close();
      }
      catch (FileNotFoundException e)
      {
         System.out.println("No file exists with the name 'StoredExpenses'!");
      }
      catch (InputMismatchException e)
      {
         System.err.println("Incorrect input entered.");
      }
   }

   public static Calendar dateReader(String date)
      throws ParseException
   {
      DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
      Date d = df.parse(date);
      Calendar c = Calendar.getInstance();
      c.setTime(d);

      return c;
   }

   public static Amount stringToAmount(String paid)
      throws NumberFormatException
   {
      String[] money = paid.split("\\.");
      int dollars = Integer.parseInt(money[0]);
      int cents = Integer.parseInt(money[1]);

      return new Amount(cents, dollars);
   }

   public static List<Expense> addExpense(List<Expense> list, Scanner system)
      throws ParseException, NumberFormatException
   {
      boolean check = false;

      do
      {
         System.out.print("Expense type (in-full, partial)? ");
         String tempNext = system.next();

         Calendar tempDate;
         Amount tempPaid;
         String tempPayee;
         String tempCategory;
         Amount tempRemaining;

         if (tempNext.equals("in-full"))
         {
            check = true;

            System.out.print("Payment date: ");
            tempDate = dateReader(system.next());

            System.out.print("Expense Amount: ");
            tempPaid = stringToAmount(system.next());            

            System.out.print("Who was this expense paid to? ");
            tempPayee = system.next();            

            System.out.print("Expense category: ");
            tempCategory = system.next();

            list.add(0, new InFull(tempDate, tempCategory, tempPayee, tempPaid));   
         }
         else if (tempNext.equals("partial"))
         {
            check = true;

            System.out.print("Payment date: ");
            tempDate = dateReader(system.next());

            System.out.print("Expense Amount: ");
            tempPaid = stringToAmount(system.next());            

            System.out.print("Who was this expense paid to? ");
            tempPayee = system.next();            

            System.out.print("Expense category: ");
            tempCategory = system.next();
            
            System.out.print("Expense Balance: ");
            tempRemaining = stringToAmount(system.next());

            list.add(0, new Partial(tempDate, tempCategory, tempPayee, tempPaid, tempRemaining));   
         }
      } while (check == false);

      return list;
   }

   public static Expense scanInFull(Scanner scanner)
      throws ParseException, IncorrectFileFormatException, NumberFormatException, NoSuchElementException
   {
      Calendar tempDate;
      String tempCategory;
      String tempPayee;
      Amount tempPaid;

      tempDate = dateReader(scanner.next());
      tempCategory = scanner.next();
      tempPayee = scanner.next();
      tempPaid = stringToAmount(scanner.next());

      return new InFull(tempDate, tempCategory, tempPayee, tempPaid);
   }

   public static Expense scanPartial(Scanner scanner)
      throws ParseException, IncorrectFileFormatException, NumberFormatException, NoSuchElementException
   {
      Calendar tempDate;
      String tempCategory;
      String tempPayee;
      Amount tempPaid;
      Amount tempRemaining;

      tempDate = dateReader(scanner.next());
      tempCategory = scanner.next();
      tempPayee = scanner.next();
      tempPaid = stringToAmount(scanner.next());
      tempRemaining = stringToAmount(scanner.next());

      return new Partial(tempDate, tempCategory, tempPayee, tempPaid, tempRemaining); 
   }

   public static void displayExpenses(List<Expense> list) 
   {
      for (int i = 0; i < list.size(); i++)
      {
         System.out.println(list.get(i).print());
      }
   }

   public static List<Expense> sortList(List<Expense> list, Scanner system)
   {
      try
      {
         String[] s = getKeys(system);
         Comparator<Expense> comp = createComparator(s);
         Collections.sort(list, comp);
      }
      catch (InvalidKeysException e)
      {
         System.err.println("Invalid keys entered.");
      }

      return list;
   }

   public static String[] getKeys(Scanner system)
   {
      System.out.print("Keys to sort by: ");
      system.nextLine();
      String keys = system.nextLine();
      String[] sortKeys = keys.split(" ");

      return sortKeys;
   }

   public static Comparator<Expense> createComparator(String[] sortKeys)
      throws InvalidKeysException
   {
      int i = sortKeys.length - 1;

      Comparator<Expense> comp = null;
 
      if (sortKeys[i].equals("amount"))
      {
         comp = new ExpenseAmountComparator();
      }
      else if (sortKeys[i].equals("category"))
      {
         comp = new ExpenseCategoryComparator();
      }
      else if (sortKeys[i].equals("date"))
      {
         comp = new ExpenseDateComparator();
      }
      else if (sortKeys[i].equals("payee"))
      {
         comp = new ExpensePayeeComparator();
      }
      else
      {
         throw new InvalidKeysException();
      }
      
      for (int j = i - 1; j >= 0; j--)
      {
         if (sortKeys[j].equals("amount"))
         {
            comp = new ExpenseDelegateComparator(new ExpenseAmountComparator(), comp);
         }
         else if (sortKeys[j].equals("category"))
         {
            comp = new ExpenseDelegateComparator(new ExpenseCategoryComparator(), comp);
         }
         else if (sortKeys[j].equals("date"))
         {
            comp = new ExpenseDelegateComparator(new ExpenseDateComparator(), comp);
         }
         else if (sortKeys[j].equals("payee"))
         {
            comp = new ExpenseDelegateComparator(new ExpensePayeeComparator(), comp);
         }
         else
         {
            throw new InvalidKeysException();
         }
      }

      return comp;
   }
}
