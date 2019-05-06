import java.util.*;
import java.text.*;
import java.io.*;

public class ExpenseTracking
{
   private static void UI(List<Expense> l) throws FileNotFoundException, 
      ParseException, IOException
   {
      Scanner scanner = new Scanner(System.in);
      List<Expense> list = new ArrayList<Expense>();
      list = l;
      int choice = 0;
      
      while(choice != 5)
      {
         System.out.println("1. Display");
         System.out.println("2. Add Expense");
         System.out.println("3. Sort");
         System.out.println("4. Save");
         System.out.println("5. Quit" + "\n");
         
         System.out.print("Enter choice: ");
         choice = scanner.nextInt();
      
         if(choice == 1)
         {
            display(list);
         }
         else if(choice == 2)
         {
            list = l;
            Expense e = addExpense();
            list.add(0, e);
         }
         else if(choice == 3)
         {
            String [] s = sortInput();
            Comparator<Expense> comp = sort(s);
            Collections.sort(list, comp);
         }
         else if(choice == 4)
         {
            save(list);
         }
      }
   }
   private static void save(List<Expense> list) 
      throws FileNotFoundException, IOException
   {
      PrintWriter pw = new PrintWriter("StoredExpenses.txt");
      
      int size = list.size();
      for(int i = 0; i < size; i++)
      {
         if(list.get(i) instanceof InFull)
         {
            pw.println("In-full");
            pw.println(list.get(i).getDate().toString());
            pw.println(list.get(i).getCategory());
            pw.println(list.get(i).getPayee());
            pw.println(list.get(i).getFAmount() + "." + 
               list.get(i).getSAmount());
         }
         else if(list.get(i) instanceof Partial)
         {
            pw.println("Partial");
            pw.println(list.get(i).getDate().toString());
            pw.println(list.get(i).getCategory());
            pw.println(list.get(i).getPayee());
            pw.println(list.get(i).getFAmount() + "." + 
               list.get(i).getSAmount());
            pw.println(list.get(i).getFRemaining() + "." + 
               list.get(i).getSRemaining());
         }
         else
         {
            throw new NoSuchElementException();
         }
      }
      pw.close();
      System.out.println("\n" + "Expenses Saved" + "\n");
   }
   private static String [] sortInput()
   {
      Scanner scanner = new Scanner(System.in);
      
      System.out.print("Keys to sort by: ");
      String sortby = scanner.nextLine();
      String [] s = sortby.split(" ");
      System.out.print("\n");
      return s;
   }
   private static Comparator<Expense> sort(String [] s)
   {
      int i = 0;
      Comparator<Expense> c = null;

      if(s[i].equals("amount"))
      {
         c = new ExpenseAmountComparator();
      }
      else if(s[i].equals("category"))
      {
         c = new ExpenseCategoryComparator();
      }
      else if(s[i].equals("date"))
      {
         c = new ExpenseDateComparator();
      }
      else if(s[i].equals("payee"))
      {
         c = new ExpensePayeeComparator();
      }
      else
      {
         System.err.print("Invalid key entered");
      }
      
      if(s.length > 1)
      {
         int size = s.length - 1;
         Comparator<Expense> comp = c;
      
         for(int j = size; j > 1; j--)
         {
            if(s[j].equals("amount"))
            {
               comp = new ExpenseDelegateComparator(comp, new ExpenseAmountComparator());
            }
            else if(s[j].equals("category"))
            {
               comp = new ExpenseDelegateComparator(comp, new ExpenseCategoryComparator());
            }
            else if(s[j].equals("payee"))
            {
               comp = new ExpenseDelegateComparator(comp, new ExpensePayeeComparator());
            }
            else
            {
               comp = new ExpenseDelegateComparator(comp, new ExpenseDateComparator());
            }
         }
         return comp;
      }  
      return c;
   }
   private static Expense addExpense() throws ParseException
   {
      Scanner scanner = new Scanner(System.in);
      
      System.out.print("Expense type (in-full, partial)? ");
      String eType = scanner.next();
      
      System.out.print("Payment date: ");
      String d = scanner.next();
      
      DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
      Date date = df.parse(d);
      Calendar c = Calendar.getInstance();
      c.setTime(date);
      
      System.out.print("Expense amount: ");
      String paid = scanner.next();
      
      int amount1 = Integer.parseInt(paid.substring(0, paid.indexOf('.')));
      int amount2 = Integer.parseInt(paid.substring(paid.indexOf('.') 
          + 1, paid.length())); 
             
      System.out.print("Who was this amount paid to? ");
      String payee = scanner.next();
      
      System.out.print("Expense category: ");
      String category = scanner.next();
            
      if(eType.equals("partial"))
      {
         System.out.print("Expense balance: ");
         String bal = scanner.next();
         int remaining1 = Integer.parseInt(bal.substring(0, bal.indexOf('.')));
         int remaining2 = Integer.parseInt(bal.substring(bal.indexOf('.') 
            + 1, bal.length()));
         System.out.print("\n");
         return new Partial(date, category, payee, amount1, 
            amount2, remaining1, remaining2);
      }
      System.out.print("\n");
      return new InFull(date, category, payee, amount1, amount2);
   }
   private static void display(List<Expense> list)
   {
      System.out.print("\n");
      int size = list.size();
      String paid = null;
      String remaining = null;
      for(int i = 0; i < size; i++)
      {
         if(list.get(i) instanceof InFull)
         {
            if(list.get(i).getSAmount() == 0)
            {
               paid = list.get(i).getFAmount() + "." + "00";
            }
            else
            {
               paid = list.get(i).getFAmount() + "." + 
                  list.get(i).getSAmount();
            }
            System.out.println(String.format("%1$2tm/%<2td/%<tY ", 
               list.get(i).getDate())
               + String.format("%-15.15s %10s [%s]", 
               list.get(i).getPayee(), paid, list.get(i).getCategory()));
         }
         else
         {
            if(list.get(i).getSAmount() == 0)
            {
               paid = list.get(i).getFAmount() + "." + "00";
            }
            else
            {
               paid = list.get(i).getFAmount() + "." + 
                  list.get(i).getSAmount();
            }
            if(list.get(i).getSRemaining() == 0)
            {
               remaining = list.get(i).getFRemaining() + "." + "00";
            }
            else
            {
               remaining = list.get(i).getFRemaining() + "." 
                   + list.get(i).getSRemaining();
            }
            System.out.println(String.format("%1$2tm/%<2td/%<tY ", 
                list.get(i).getDate())
                + String.format("%-15.15s %10s (%s) [%s]", list.get(i).getPayee(), 
                paid, remaining, list.get(i).getCategory()));
         }
      }
      System.out.print("\n");
   }
   public static void main(String [] args) throws FileNotFoundException
   {
      List<Expense> list = new ArrayList<Expense>();
      try
      {
         File f = new File("StoredExpenses.txt");
         if(f.exists() == false)
         {
            f.createNewFile();
         }
         Scanner infile = new Scanner(f);
         while(infile.hasNextLine())
         {
            String type = infile.nextLine();
            if(type.equals("In-full"))
            {
               String d = infile.nextLine();
     
               DateFormat df = new SimpleDateFormat("EEE MMM dd HH:mm:ss z yyyy");
               Date da = df.parse(d);
               
               DateFormat dff = new SimpleDateFormat("MM/dd/yyyy");
               String formatted = dff.format(da);
               
               Date date = dff.parse(formatted);
               
               String category = infile.nextLine();
               String payee = infile.nextLine();
               String paid = infile.nextLine();
      
               int amount1 = Integer.parseInt(paid.substring(0, paid.indexOf('.')));
               int amount2 = Integer.parseInt(paid.substring(paid.indexOf('.') 
                   + 1, paid.length())); 
               
               Expense e = new InFull(date, category, payee, amount1, amount2);
               list.add(e);
            }
            if(type.equals("Partial"))
            {
               String d = infile.nextLine();
     
               DateFormat df = new SimpleDateFormat("EEE MMM dd HH:mm:ss z yyyy");
               Date da = df.parse(d);
               
               DateFormat dff = new SimpleDateFormat("MM/dd/yyyy");
               String formatted = dff.format(da);
               
               Date date = dff.parse(formatted);
               
               String category = infile.nextLine();
               String payee = infile.nextLine();
               String paid = infile.nextLine();
      
               int amount1 = Integer.parseInt(paid.substring(0, paid.indexOf('.')));
               int amount2 = Integer.parseInt(paid.substring(paid.indexOf('.') 
                   + 1, paid.length()));
               
               String bal = infile.nextLine();
               int remaining1 = Integer.parseInt(bal.substring(0, bal.indexOf('.')));
               int remaining2 = Integer.parseInt(bal.substring(bal.indexOf('.') 
                  + 1, bal.length()));
               
               Expense e = new Partial(date, category, payee, amount1, 
                  amount2, remaining1, remaining2);
               list.add(e);
            }
         }
         
         System.out.println("File Loaded" + "\n");
         UI(list);
      }
      catch(FileNotFoundException e)
      {
         System.err.println("Error: File not found");
      }
      catch(ParseException p)
      {
         System.err.println("Parsing error");
      }
      catch(IOException i)
      {
         System.err.println("Error");
      }
   }
}