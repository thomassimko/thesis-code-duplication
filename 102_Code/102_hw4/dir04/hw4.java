import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Comparator;
import java.util.Date;
import java.util.Scanner;

public class hw4 
{
	private static ArrayList<Expense> storedExpensesList = new ArrayList<Expense>();
	
	private static Comparator<Expense> chooseComp(Scanner fileScan, String [] keys, int ind)
	{
		String key = keys[ind];
		if(ind > 0)
		{
			if(key.equals("amount"))
			{
				Comparator<Expense> comp = new ExpenseAmountDelegateComparator(chooseComp(fileScan, keys, ind - 1));
				return comp;
			}
			else if(key.equals("category"))
			{
				Comparator<Expense> comp = new ExpenseCategoryDelegateComparator(chooseComp(fileScan, keys, ind - 1));
				return comp;
			}
			else if(key.equals("date"))
			{
				Comparator<Expense> comp = new ExpenseDateDelegateComparator(chooseComp(fileScan, keys, ind - 1));
				return comp;
			}
			else if(key.equals("payee"))
			{
				Comparator<Expense> comp = new ExpensePayeeDelegateComparator(chooseComp(fileScan, keys, ind - 1));
				return comp;
			}
			else
			{
				System.err.println("Invalid key input!");
				menu(fileScan);
			}
		}
		else
		{
			if(key.equals("amount"))
			{
				Comparator<Expense> comp = new ExpenseAmountComparator();
				return comp;
			}
			else if(key.equals("category"))
			{
				Comparator<Expense> comp = new ExpenseCategoryComparator();
				return comp;
			}
			else if(key.equals("date"))
			{
				Comparator<Expense> comp = new ExpenseDateComparator();
				return comp;
			}
			else if(key.equals("payee"))
			{
				Comparator<Expense> comp = new ExpensePayeeComparator();
				return comp;
			}
			else
			{
				System.err.println("Invalid key input!");
				menu(fileScan);
			}
		}
		return null;
	}
	
	public static void changeList(Comparator<Expense> comp)
	{
		InsertionSort<Expense> sort = new InsertionSort<Expense>();
		ArrayList<Expense> sortedList = sort.Sort(storedExpensesList, comp);
		storedExpensesList = sortedList;
	}
	
	public static void sort(Scanner scan, Scanner fileScan)
	{	
		String wholeKeyLine;
		
		System.out.print("Keys to sort by: ");
		scan.nextLine(); //get rid of newline
		wholeKeyLine = scan.nextLine();
		
		String [] keys = wholeKeyLine.split(" "); //stores keys in same order typed
		
		int ind = keys.length - 1;
		Comparator<Expense> comp = chooseComp(fileScan, keys, ind);		
		changeList(comp);		
	}
	
	public static void printFile(Scanner scans) throws FileNotFoundException
	{
		PrintWriter printFile = null;
		printFile = new PrintWriter("StoredExpenses.txt");
		for(int i = 0; i < storedExpensesList.size(); i++)
		{
			printFile.println(storedExpensesList.get(i).getType());
			printFile.println(storedExpensesList.get(i).getDate());
			printFile.println(storedExpensesList.get(i).getCat());
			printFile.println(storedExpensesList.get(i).getPaidTo());
			printFile.println(storedExpensesList.get(i).getAmount());
			
			if(storedExpensesList.get(i) instanceof partialExpense)
			{
				printFile.println(storedExpensesList.get(i).getBalance());
			}
		}
		printFile.close();
	}
	
	public static void display()
	{
		System.out.println();
		
		for(int i = 0; i < storedExpensesList.size(); i++)
		{
			if(storedExpensesList.get(i) instanceof partialExpense)
			{
				System.out.println(storedExpensesList.get(i).getDate() + " "
									+ String.format("%-15.15s %s (%s) [%s]",
											storedExpensesList.get(i).getPaidTo() ,
											storedExpensesList.get(i).getAmount() , 
											storedExpensesList.get(i).getBalance(),  
											storedExpensesList.get(i).getCat()));
			}
			else if(storedExpensesList.get(i) instanceof infullExpense)
			{
				System.out.println(storedExpensesList.get(i).getDate() + " "
									+ String.format("%-15.15s %s [%s]",
											storedExpensesList.get(i).getPaidTo(),
											storedExpensesList.get(i).getAmount(), 
											storedExpensesList.get(i).getCat()));
			}
			else
			{
				System.err.println("Invalid Input");
			}
		}
	}
	
	public static void menu(Scanner scans)
	{	
		int choice;
		
		Scanner scan = new Scanner(System.in); //Input Scanner
		
		System.out.println("\n1. Display");
		System.out.println("2. Add Expense");
		System.out.println("3. Sort");
		System.out.println("4. Save");
		System.out.println("5. Quit\n");
		
		System.out.print("Enter choice: ");
		choice = scan.nextInt();
		
		if(choice == 1)
		{ 
			display();
			menu(scans);
		}
		else if(choice == 2)
		{
			input(scan);
			menu(scans);
		}
		else if(choice == 3)
		{
			sort(scan, scans);
			menu(scans);
		}
		else if(choice == 4)
		{
			try
			{
				printFile(scans);
			}
			catch(FileNotFoundException e)
			{
				System.err.println("Output file not found.");
			}
			menu(scans);
		}
		else if(choice == 5)
		{
			System.exit(0);
		}
		else
		{
			try 
			{
				throw new IOException();
			} 
			catch (IOException e) 
			{
				System.err.println("\nInvalid command!");
				menu(scans);
			}
		}
	}
	
	public static void input(Scanner scans)
	{
		String expenseType;
		String date;
		String category;
		String paidTo;
		String amount;
		String remainingAmt = null;
		
		Scanner scan = scans;
		
		System.out.print("Expense type (in-full, partial)? ");
		scan.nextLine();
		expenseType = scan.nextLine();
		
		System.out.print("Payment date: ");
		date = scan.nextLine();
		
		System.out.print("Expense Amount: ");
		amount = scan.nextLine();
		
		System.out.print("Who was this expense paid to? ");
		paidTo = scan.nextLine();
		
		System.out.print("Expense category: ");
		category = scan.nextLine();
		
		if(expenseType.equals("partial"))
		{
			System.out.print("Expense Balance: ");
			remainingAmt = scan.nextLine();
		}
		
		try 
		{
			date = parseDate(date);
		} 
		catch (ParseException e1) 
		{
			System.err.println("Parse error, yo.");
		}
		Expense add;
		
		if(expenseType.equals("partial"))
		{	
			add = new partialExpense(date, category, paidTo, amount, remainingAmt);
		}
		else if(expenseType.equals("in-full"))
		{
			add = new infullExpense(date, category, paidTo, amount, remainingAmt);
		}
		else
		{
			System.err.println("Input error, not a valid type of expense");
			menu(scans);
			add = null;
		}
		storedExpensesList.add(0, add);
	}
	
	public static String parseDate(String date) throws ParseException
	{
		String s = date;
		DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
		Date d = null; 
		d = df.parse(s);
		Calendar c = Calendar.getInstance();
		c.setTime(d);
		String k = String.format("%1$2tm/%<2td/%<tY", c);
		return k;		
	}
	
	
	public static Scanner readFile() throws FileNotFoundException
	{
		Scanner scans = null;
		
		String expenseType;
		String date;
		String category;
		String paidTo;
		String amount;
		String remainingAmt = null;
		
		Expense add;
		
		try
		{
			scans = new Scanner(new File("StoredExpenses.txt")); 
			
			while(scans.hasNext())
			{				
				expenseType = scans.nextLine();
				date = scans.nextLine();	
				category = scans.nextLine();
				paidTo = scans.nextLine();
				amount = scans.nextLine();
				if(expenseType.contains("partial"))
				{
					remainingAmt = scans.nextLine();
				}
				
				try 
				{
					date = parseDate(date);
				} 
				catch (ParseException e1) 
				{
					System.err.println("Parse error, yo.");
				}
				
				if(expenseType.contains("partial"))
				{
					add = new partialExpense(date, category, paidTo, amount, remainingAmt);
				}
				else
				{
					add = new infullExpense(date, category, paidTo, amount, remainingAmt);
				}
				storedExpensesList.add(add);
			}
		}
		catch(FileNotFoundException e)
		{
			storedExpensesList.clear();
		}
		return scans;
	}

	public static void main(String[] args) throws FileNotFoundException 
	{
		Scanner scans = null;
		try 
		{
			scans = readFile(); //File Scanner
			System.out.println("File Loaded");
		} 
		catch (FileNotFoundException e) 
		{
			storedExpensesList.clear();
			System.out.println("File Loaded");
		}
		menu(scans);	
	}

}
