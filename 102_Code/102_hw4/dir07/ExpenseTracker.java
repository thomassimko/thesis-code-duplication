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
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;


public class ExpenseTracker
{
	static List<Expense> expenseList = new LinkedList<Expense>();
	
	public static void main(String[] args)
	{
		expenseList = readInFile();
		Scanner scan = new Scanner(System.in);
		int choice;
		while((choice = userInputChoice(scan)) != 5)
		{
			inputAction(scan, choice);
		}
	}

	private static List<Expense> readInFile()
	{
		List<Expense> readInExpenses = new LinkedList<Expense>();
		try
		{
			Scanner scan = new Scanner(new File("StoredExpenses"));

			while(scan.hasNextLine())
			{
				String type = scan.nextLine();
				if(type.equals("In-Full") || type.equals("in-full"))
				{
					Date date = null;
					try
					{
						date = convertDate(scan.nextLine());
					}
					catch(ParseException pe)
					{
						return readInExpenses;
					}
					Expense inFullExpense = new InFull(date, scan.nextLine(), scan.nextLine(), scan.nextLine());
					readInExpenses.add(inFullExpense);
				}
				else if(type.equals("Partial") || type.equals("partial"))
				{
					Date date = null;
					try
					{
						date = convertDate(scan.nextLine());
					}
					catch(ParseException pe)
					{
						return readInExpenses;
					}
					Expense partialExpense = new Partial(date, scan.nextLine(), scan.nextLine(),
																		scan.nextLine(), scan.nextLine());
					readInExpenses.add(partialExpense);
				}
			}
			System.out.println("File Loaded");
		}
		catch(FileNotFoundException e)
		{
		}
		return readInExpenses;
	}
	
	private static int userInputChoice(Scanner scan)
	{
		int choice = 5;
		try
		{
			System.out.println("");
			System.out.println("1. Display");
			System.out.println("2. Add Expense");
			System.out.println("3. Sort");
			System.out.println("4. Save");
			System.out.println("5. Quit");
			System.out.println("");
			System.out.print("Enter Choice: ");
			choice = scan.nextInt();
		}
		catch(Exception e)
		{
			System.err.println("Not a valid input ---> Terminating...");
		}
		return choice;
	}
	
	private static void inputAction(Scanner scan, int choice)
	{
		if(choice==1)
		{
			display();
		}
		if(choice==2)
		{
			addExpense(scan);
		}
		if(choice==3)
		{
			sort(scan);
		}
		if(choice==4)
		{
			saveExpenses();
		}
	}
	
	private static void display()
	{
		System.out.println("");
		
		for(int i=0; i<expenseList.size(); i++)
		{
			Expense expense = expenseList.get(i);
			if(expense instanceof InFull)
			{
				System.out.println(expense.toString());	
			}
			if(expense instanceof Partial)
			{
				System.out.println(expense.toString());
			}
		}
	}
	
	private static void addExpense(Scanner scan)
	{
		System.out.print("Expense type (in-full, partial)? ");
		String type = scan.next();
		if(type.equals("in-full"))
		{
			System.out.print("Payment date: ");
			Date date = null;
			try
			{
				date = convertDate(scan.next());
			}
			catch(ParseException pe)
			{
				return;
			}
			System.out.print("Expense Amount: ");
			String paid = scan.next();
			System.out.print("Who was this expense paid to? ");
			String payee = scan.next();
			System.out.print("Expense category: ");
			String category = scan.next();
			
			Expense expense = new InFull(date, category, payee, paid);
			expenseList.add(expense);
		}
		else if(type.equals("partial"))
		{
			System.out.print("Payment date: ");
			Date date = null;
			try
			{
				date = convertDate(scan.next());
			}
			catch(ParseException pe)
			{
				return;
			}
			System.out.print("Expense Amount: ");
			String paid = scan.next();
			System.out.print("Who was this expense paid to? ");
			String payee = scan.next();
			System.out.print("Expense category: ");
			String category = scan.next();
			System.out.print("Expense Balance: ");
			String remaining = scan.next();
			
			Expense expense = new Partial(date, category, payee, paid, remaining);
			expenseList.add(expense);
		}
	}
	
	private static void sort(Scanner scan)
	{
		scan.nextLine();
		System.out.print("Keys to sort by: ");
		List<String> keysList = new ArrayList<String>();
		Scanner keyScanner = new Scanner(scan.nextLine());
		while(keyScanner.hasNext())
		{
			keysList.add(keyScanner.next());
		}
		keysList = reverseList(keysList);
		
		Comparator<Expense> comp = null;		
		for(int i=0; i<keysList.size(); i++)
		{
			String key = keysList.get(i);
			if(key.equals("amount"))
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
			else if(key.equals("category"))
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
			else if(key.equals("date"))
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
			else if(key.equals("payee"))
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
				System.out.println("Invalid key");
				return;
			}
		}
		if(comp != null)
		{
			Collections.sort(expenseList, comp);
		}
		else 
		{
			System.err.println("Null Comparator");
		}
	}
		
	private static List<String> reverseList(List<String> list)
	{
		List<String> tempList = new ArrayList<String>();
		for(int i=list.size()-1; i>=0; i--)
		{
			tempList.add(list.get(i));
		}
		return tempList;
	}
	
	private static void saveExpenses()
	{
		try
		{
			PrintWriter writer = new PrintWriter(new File("StoredExpenses"));
			for(int i=0; i<expenseList.size(); i++)
				{
					Expense expense = expenseList.get(i);
					if(expense instanceof InFull)
					{
						writer.println("In-Full");
					}
					if(expense instanceof Partial)
					{
						writer.println("Partial");
					}
					Date date = expense.getDate();
					String dateString = String.format("%1$2tm/%<2td/%<tY ", date);
					writer.println(dateString);
					writer.println(expense.getCategory());
					writer.println(expense.getPayee());
					writer.println(expense.getPaidDollars() + "." 
										+ expense.getPaidCents());
					if(expense instanceof Partial)
					{
						writer.println(expense.getRemainingDollars() + "." 
										+ expense.getRemainingCents());
					}	
				}
			writer.close();
		}
		catch(Exception e)
		{
			System.err.println("Could not finish saving to file...");
		}
	}
 
	private static Date convertDate(String dateString) 
		throws ParseException
	{			
		DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
		Date date = df.parse(dateString);
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		return date;
	}
	
}
