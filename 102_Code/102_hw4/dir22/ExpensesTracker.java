//Programmed by Michael Olivarez

/*This is the main program that will initialize the Expenses
 * tracking program, loading data from the StoredExpenses file
 * if the file exists, if not, then it will begin with an empty
 * list of expenses*/
import java.lang.*;
import java.util.*;
import java.io.*;
public class ExpensesTracker
{
  public static void doDisplay(List<Expense> expenses)
  {
     System.out.println("");
     for(int i=0; i<expenses.size(); i++)
     {
       Expense E = expenses.get(i); 
       if(E instanceof InFullExpense )
       {
       System.out.println(E.getDate()+" "+E.getPaidTo()+"\t\t"+E.getAmt()+" "+
                         "["+ E.getCategory()+"]");
       }
       else
       {
       System.out.println(E.getDate()+" "+E.getPaidTo()+"\t\t"+
                    E.getAmt()+" ("+ E.getAmtDue()+") "+" ["+ E.getCategory()+"]");
       }
     }
     System.out.println("");
  }
  public static void doAddExpense(Scanner sc, List<Expense> expenses)
  {
     System.out.println("Expense type (in-full, partial)?) ");
     String type = sc.nextLine();
     System.out.println("Payment date: ");
     String date = sc.nextLine();
     System.out.println("Expense Amount: ");
     String amt = sc.nextLine();
     System.out.println("Who was this expense paid to? ");
     String payee = sc.nextLine();
     System.out.println("Expense Category: ");
     String cat = sc.nextLine();
     Scanner dateScan = new Scanner(date);
     dateScan.useDelimiter("/");
     int month = dateScan.nextInt()-1;
     int day = dateScan.nextInt();
     int year = dateScan.nextInt();
     dateScan.close();
     int PTindex = amt.indexOf(".");
     String d = amt.substring(0,PTindex);
     String c = amt.substring(PTindex+1,amt.length());
     int dollars = Integer.parseInt(d);
     int cents = Integer.parseInt(c); 
     GregorianCalendar cal = new GregorianCalendar(year, month, day);
     if(type.equals("partial"))
     {
       System.out.println("Expense Balance: ");
       String amtdue = sc.nextLine();
       int index = amtdue.indexOf(".");
       String dRem = amtdue.substring(0,index);
       String cRem = amtdue.substring(index+1,amtdue.length());
       int dollRem = Integer.parseInt(dRem);
       int centRem = Integer.parseInt(cRem);
       Expense E = new PartialExpense(cal,dollars,cents,dollRem,centRem,payee,cat);
       expenses.add(E);
     }
     else
     {
       Expense E = new InFullExpense(cal,dollars,cents,payee,cat);
       expenses.add(E);
     }
  }
  public static void doSort(List<Expense> expenses, Scanner sc)
  {
     System.out.println("Keys to sort by: ");
     sc.nextLine();
     Scanner SR  = new Scanner(sc.nextLine());
     String key1 = SR.next();
     checkKey(key1);
     Comparator<Expense> comp1 = getComparator(key1);
     Comparator<Expense> comp2 = null;
     Comparator<Expense> comp3 = null;
     Comparator<Expense> comp4 = null;
     
     int numkeys = 1;
     //System.out.println("Key read: "+key1);
     if(SR.hasNext())
     {
       String key2 = SR.next();
       checkKey(key2);
       comp2 = getComparator(key2);
       numkeys = 2;    
       //System.out.println("Key read: "+key2);
       if(SR.hasNext())
       {
         String key3 = SR.next();
         checkKey(key3);
         comp3 = getComparator(key3);
         numkeys = 3;
         //System.out.println("Key read: "+key3);
         if(SR.hasNext())
         {
           String key4 = SR.next();
           checkKey(key4);
           comp4 = getComparator(key4);
           numkeys = 4;
           //System.out.println("Key read: "+key4);
         }
       }
     }
     SR.close(); 
     //At this point all sort keys have been read
     if(numkeys==1)
     {  
       Collections.sort(expenses, comp1);
     }
     else if(numkeys==2)
     {
       Comparator<Expense> EDC = new ExpenseDelegateComparator(comp1,comp2);
       Collections.sort(expenses, EDC);
     }
     else if(numkeys==3)
     {
       Comparator<Expense> EDC2 = new ExpenseDelegateComparator(comp2,comp3);
       Comparator<Expense> EDC1 = new ExpenseDelegateComparator(comp1,EDC2);
       Collections.sort(expenses, EDC1);
     }
     else
     {
       Comparator<Expense> EDC3 = new ExpenseDelegateComparator(comp3,comp4);
       Comparator<Expense> EDC2 = new ExpenseDelegateComparator(comp2,EDC3);
       Comparator<Expense> EDC1 = new ExpenseDelegateComparator(comp1,EDC2);
       Collections.sort(expenses, EDC1);
     }
  }
  public static Comparator<Expense> getComparator(String key)
  {
    if(key.equals("amount"))
    {
       Comparator<Expense> AmtComp = new ExpenseAmountComparator();
       return AmtComp;
    }
    else if(key.equals("category"))
    {
       Comparator<Expense> CatComp = new ExpenseCategoryComparator();
       return CatComp;
    }
    else if(key.equals("date"))
    {
       Comparator<Expense> DateComp = new ExpenseDateComparator();
       return DateComp;
    }
    else
    {
       Comparator<Expense> PayeeComp = new ExpensePayeeComparator();
       return PayeeComp;
    }
  }
  public static void checkKey(String key)
  {
    if(!(key.equals("amount")||key.equals("category")||
           key.equals("date")||key.equals("payee")))
    {
      System.out.println("Error: Invalid key");
      System.exit(-1);
    }
  }
  public static void doSave(List<Expense> expenses)
  {
     PrintWriter pw = null;
     try
     {
       File out = new File("StoredExpenses");
       pw = new PrintWriter(out);
     }
     catch(FileNotFoundException w)
     {
       System.out.println("ERROR: Could not write to file!");
       System.exit(-1);
     }
     for(int i = 0; i < expenses.size(); i++)
     {
       Expense E = expenses.get(i);
       pw.println(E.getType());
       pw.println(E.getDate());
       pw.println(E.getCategory());
       pw.println(E.getPaidTo());
       pw.println(E.getAmt());
       pw.println(E.getAmtDue());
     }
     pw.close();
  }
  public static void main(String [] args)
  {   
    Scanner sc = null;
    boolean fileFound = true;
    try
    {
     File in = new File("StoredExpenses");
     sc = new Scanner(in);
    }
    catch(FileNotFoundException e)
    {
      System.out.println("Warning: Save file not found");
      fileFound = false;
    }
    List<Expense> expenses = new ArrayList<Expense>(); 
    if(fileFound == true)
    {//creating list of expenses from loaded file in this while loop
      while(sc.hasNextLine())
      {
        String type = sc.nextLine();
        String date = sc.nextLine();
        String category = sc.nextLine();
        String PaidTo = sc.nextLine();
        String amt = sc.nextLine();
        String amtRem = sc.nextLine();
        //getting the month, day, and year...
        Scanner dateScan = new Scanner(date);
        dateScan.useDelimiter("/");
        int month = dateScan.nextInt()-1;
        int day = dateScan.nextInt();
        int year = dateScan.nextInt();
        dateScan.close();
        //getting amount paid...
        int PTindex = amt.indexOf(".");
        String d = amt.substring(0,PTindex);
        String c = amt.substring(PTindex+1,amt.length());
        int dollars = Integer.parseInt(d);
        int cents = Integer.parseInt(c);        
        //getting amount due...
        int PT1index = amtRem.indexOf(".");
        String d1 = amtRem.substring(0,PT1index);
        String c1 = amtRem.substring(PT1index+1,amtRem.length());
        int dollRem = Integer.parseInt(d1);
        int centRem = Integer.parseInt(c1);
        GregorianCalendar GC = new GregorianCalendar(year, month, day);
        //creating the expense and adding it to the list of expenses
        if(type.equals("partial"))
        {
          Expense PE = new PartialExpense(GC, dollars, cents, dollRem, centRem,
                                          PaidTo, category);
          expenses.add(PE);
        }
        else
        {
          Expense FE = new InFullExpense(GC, dollars, cents, PaidTo, category);
          expenses.add(FE);
        }
      }

      System.out.println("File Loaded");
      sc.close();
    }
    else
    {//create a new empty list of expenses
      System.out.println("Warning: Could not read file, creating new file...");
    }    
    //initializing the user interface...
    Scanner sF = new Scanner(System.in);
    while(0<1)
    {
     System.out.println("1. Display");
     System.out.println("2. Add Expense");
     System.out.println("3. Sort");
     System.out.println("4. Save");
     System.out.println("5. Quit");
     System.out.println("");
     System.out.println("Enter choice: ");
     int i = sF.nextInt();
     if(i<1 || i>5)
     {
       System.out.println("ERROR: Invalid number");
     }
     if(i == 1)
     {
       doDisplay(expenses);
     }
     if(i == 2)
     {
       String str = sF.nextLine();
       doAddExpense(sF, expenses);
     }
     if(i == 3)
     {  
       doSort(expenses, sF);
     }
     if(i == 4)
     {
       doSave(expenses);
     }
     if(i == 5)
     {
       System.exit(-1);
     }
    }
  }
}
