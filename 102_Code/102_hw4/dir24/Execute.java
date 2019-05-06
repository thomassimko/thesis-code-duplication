import java.io.*;
import java.util.*;
import java.util.Calendar;
import java.text.*;

public class Execute
{
   public static void main(String[] args)
   {
      File input;
      try
      {
         input = new File("StoredExpenses.txt");
         if(!input.exists())
         {
            input.createNewFile();
         }

         ArrayList<Expense> newList = new ArrayList<Expense>();
         System.out.println("File Loaded");
         System.out.println("");
         System.out.println("1. Display");
         System.out.println("2. Add Expense");
         System.out.println("3. Sort");
         System.out.println("4. Save");
         System.out.println("5. Quit");
         System.out.println("");

         Scanner s = new Scanner(input);

         while(s.hasNextLine())
         {
            String type = s.nextLine();
            String date = s.nextLine();
            String category = s.nextLine();
            String payee = s.nextLine();
            String ame = s.nextLine();
            DateFormat format = new SimpleDateFormat("MM/dd/yyyy");
            Date d = format.parse(date);
            Amount paid = new Amount(ame);
            if(type.equals("partial"))
            {
               String balance = s.nextLine();
               Amount left = new Amount(balance);
               Expense read1 = new Partial(d, paid, payee, category, left);
               newList.add(read1);
            }
            if(type.equals("in-full"))
            {
               Expense read2 = new inFull(d, paid, payee, category);
               newList.add(read2);
            }
         }
         
         Scanner one = new Scanner(System.in);
         System.out.print("Enter choice: ");
         int choice = one.nextInt();
         System.out.println("");

         while(choice != 5)
         {
            if(choice == 1)
            {
               int size = newList.size();
               int i = 0;
               while(i < size)
               {
                  String type = newList.get(i).getType().toLowerCase();
                  
                  String toDate = newList.get(i).getDate().toString();
                  /*
                  DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
                  Date date = df.parse(toDate);
                  Calendar c = Calendar.getInstance();
                  c.setTime(date);
                  */
                  String category = newList.get(i).getCategory();
                  String payee = newList.get(i).getPayee();
                  String paid = newList.get(i).amountPaid().getDollar() + "." + newList.get(i).amountPaid().getCent();
                  if(type.equals("partial"))
                  {
                     String balance = newList.get(i).getBalance().getDollar() + "." + newList.get(i).getBalance().getCent();
                     String print1 = String.format("%1$2tm/%<2d/%<tY", toDate) + String.format(
                        "%-15.15s %s (%s) [%s]", payee, paid, balance, 
                        category);
                     System.out.println(print1);
                  }
                  if(type.equals("in-full"))
                  {
                     String print2 = String.format("%1$2tm/%<2d/%<tY", toDate) + String.format(
                        "%-15.15s %s [%s]", payee, paid, category);
                     System.out.println(print2);
                  }
                  i++;
               }
            }

            if(choice == 2)
            {
                  String buffer = one.nextLine();
                  System.out.print("Expense type (in-full, partial)? ");
                  String type = one.nextLine();
                  System.out.print("Payment date: ");
                  String date = one.nextLine();
                  System.out.print("Expense amount: ");
                  String amount = one.nextLine();
                  System.out.print("Who was this expense paid to? ");
                  String payee = one.nextLine();
                  System.out.print("Expense category: ");
                  String category = one.nextLine();

                  Amount newAmount = new Amount(amount);

                  DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
                  Date format = df.parse(date);

                  Calendar myCal = Calendar.getInstance();
                  myCal.setTime(format);
                  int month = myCal.get(Calendar.MONTH) + 1;
                  int day = myCal.get(Calendar.DATE) + 1;
                  int year = myCal.get(Calendar.YEAR) + 1;

                  String print = String.format("%1$tm/%1$td/%1$ty", myCal);
                  if(type.equals("partial"))
                  {
                     System.out.print("Expense balance: ");
                     String balance = one.nextLine();
                     Amount balanceAmount = new Amount(balance);
                     Expense expense1 = new Partial(format, newAmount, payee, category, 
                     balanceAmount);
                     newList.add(expense1);
                  }
                  if(type.equals("in-full") || type.equals("infull"))
                  {
                     Expense expense2 = new inFull(format, newAmount, payee, category);
                     newList.add(expense2);
                  }
            }

            if(choice == 3)
            {
               String buffer = one.nextLine();
               System.out.print("Keys to sort by: ");
               String key = one.nextLine();
               String[] keys = key.split(" ");
               for(int i = 0; i < keys.length; i++)
               {
                  keys[i] = keys[i].toLowerCase();
               }
               String last = keys[keys.length - 1];
               
               Comparator<Expense> comp = null;
               boolean error = false;
               
               if(last.equals("amount"))
               {
                  comp = new ExpenseAmountComparator();
               }
               else if(last.equals("category"))
               {
                  comp = new ExpenseCategoryComparator();
               }
               else if(last.equals("date"))
               {
                  comp = new ExpenseDateComparator();
               }
               else if(last.equals("payee"))
               {
                  comp = new ExpensePayeeComparator();
               }
               else
               {
                  error = true;
                  System.err.println("Not a valid key");
               }

               if(error == false)
               {
                  for(int i = keys.length - 1; i >=0; i--)
                  {
                     if(keys[i].equals("amount"))
                     {
                        comp = new ExpenseDelegateComparator(new ExpenseAmountComparator(), comp);
                     }
                     if(keys[i].equals("date"))
                     {
                        comp = new ExpenseDelegateComparator(new ExpenseDateComparator(), comp);
                     }
                     if(keys[i].equals("category"))
                     {
                        comp = new ExpenseDelegateComparator(new ExpenseCategoryComparator(), comp);
                     }
                     if(keys[i].equals("payee"))
                     {
                        comp = new ExpenseDelegateComparator(new ExpensePayeeComparator(), comp);
                     }
                  }
                  Collections.sort(newList, comp);
               }
/*
                  if(keys.length == 1)
                  {
                     if(keys[i].equals
                  }
                  else if(keys.length == 2)
                  {
                     Comparator<Expense> two = new ExpenseDelegateComparator(comp[0], comp[1]);
                     Collections.sort(newList, two);
                  }
                  else if(keys.length == 3)
                  {
                     Comparator<Expense> three = new ExpenseDelegateComparator(comp[0], new ExpenseDelegateComparator(comp[1], comp[2]));
                     Collections.sort(newList, three);
                  }
                  else if(keys.length == 4)
                  {
                     Comparator<Expense> four = new ExpenseDelegateComparator(comp[0], new ExpenseDelegateComparator(comp[1], new ExpenseDelegateComparator(comp[2], comp[3])));
                     Collections.sort(newList, four);
                  }
*/
            }

            if(choice == 4)
            {
               PrintWriter p = new PrintWriter(input);
               int size = newList.size();
               for(int k = 0; k < size; k++)
               {
                  p.println(newList.get(k).getType());
                  p.println(newList.get(k).getDate());
                  p.println(newList.get(k).getCategory());
                  p.println(newList.get(k).getPayee());
                  p.println(newList.get(k).amountPaid().getDollar() + "." + newList.get(k).amountPaid().getCent());
                  if(newList.get(k) instanceof Partial)
                  {
                     p.println(newList.get(k).getBalance().getDollar() + "." + newList.get(k).getBalance().getCent());
                  }
               }
               p.close();
               System.out.println("Expenses Saved");
            }

            System.out.println("");
            System.out.println("1. Display");
            System.out.println("2. Add Expense");
            System.out.println("3. Sort");
            System.out.println("4. Save");
            System.out.println("5. Quit");
            System.out.println("");
            System.out.print("Enter choice: ");
            choice = one.nextInt();
            System.out.println("");
         }
         System.exit(1);
      }
      catch(FileNotFoundException e)
      {
         System.err.println("File not found");
      }
      catch(IOException i)
      {
      
      }
      catch(ParseException p)
      {
         System.err.println("Parse error");
      }
   }
}
