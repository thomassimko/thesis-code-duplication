import java.util.Scanner;
import java.io.PrintWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.Date;
import java.util.Calendar;
import java.util.List;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Collections;
import java.util.NoSuchElementException;

public class ExpenseTracker
{
	public static void main(String[]args)
	{
		File read = new File("StoredExpenses.txt");
		readFile(read);
	}
	public static List<Payment> createList(Scanner reader)
	{
		List<Payment>list = new ArrayList<Payment>();
		Payment payment;
		int dollars, cents, remdollar, remcents;
		Paid money, remmoney;
		String s, cat, payee, moneyString, remainString, dollarString, centString;
		String remDollarString, remCentString;
		Date temp;
		DateFormat date = new SimpleDateFormat("MM/dd/yyyy");
		while (reader.hasNextLine())
		{
			try
			{
				s = reader.nextLine();
				
				temp = date.parse(reader.nextLine());
				Calendar calendar = Calendar.getInstance();
				calendar.setTime(temp);
								
				cat = reader.nextLine();
				
				payee = reader.nextLine();
				
				moneyString = reader.nextLine();
				String[] m = moneyString.split("\\.");
				dollars = java.lang.Integer.parseInt(m[0]);
				cents = java.lang.Integer.parseInt(m[1]);
				money = new Paid(dollars, cents);
				
			   remainString = reader.nextLine();
			   m = remainString.split("\\.");
				remdollar = java.lang.Integer.parseInt(m[0]);
				remcents = java.lang.Integer.parseInt(m[1]);
				remmoney = new Paid(remdollar, remcents);
				
				if (s.equals("in-full")||s.equals("In-full"))
				{
					payment = new InFull(money, cat, temp, payee);
					list.add(0, payment);
				}
				else if (s.equals("partial")||s.equals("Partial"))
				{
					payment = new Partial(money, cat, temp, payee, remmoney);
					list.add(0, payment);
				}
			}
			catch (ParseException e)
			{
				System.out.println("Invalid date. Loaded list might be incomplete.");
			}
			catch (NumberFormatException c)
			{
				System.out.println("Error while reading file. Loaded list might be incomplete.");
			}
			catch (NoSuchElementException b)
			{
				System.out.println("Missing data. Loaded list might be incomplete.");
			}
		}
		return list;
	}
	public static void readFile(File read)
	{
		try
		{
			Scanner scan = new Scanner(read);
			List<Payment> list = createList(scan);
			System.out.println("File loaded");
			userPrompt(list);
		}
		catch (FileNotFoundException e)
		{
			System.out.println("No file found");
			List<Payment>list = new ArrayList<Payment>();
			userPrompt(list);
		}

	}
	public static void userPrompt(List<Payment> list)
	{
		int choice = 0;
		Scanner c = new Scanner(System.in);
		System.out.println();
		while (choice!=5)
		{
			System.out.println("1. Display");
			System.out.println("2. Add Expense");
			System.out.println("3. Sort");
			System.out.println("4. Save");
			System.out.println("5. Quit");
			System.out.println();
			System.out.print("Enter choice: ");
			choice = c.nextInt();
			if (choice==1)
			{
				displayChoice(list);
			}
			else if (choice==2)
			{
				addChoice(list);
			}
			else if (choice==3)
			{
				sortChoice(list);
			}
			else if (choice==4)
			{
				saveChoice(list);
			}
		}
	}
	//Choice 1 - Display
	public static void displayChoice(List<Payment> list)
	{
		int size = list.size();
		System.out.println();
		for (int i=0; i<size; i++)
		{
			System.out.println(list.get(i).toString());
		}
		System.out.println();
	}
	//Choice 2 - Add Expenses
	public static void addChoice(List<Payment> list)
	{
		Scanner c = new Scanner(System.in);
		Payment payment;
		int dollars, cents, remdollar, remcents;
		Paid money, remmoney;
		String type, cat, payee, temp;
		String moneyString, dollarString, centString;
		String remainString, remDollarString, remCentString;
		Date d;
		DateFormat date = new SimpleDateFormat("MM/dd/yyyy");
		try
		{
			System.out.print("Expense type (in-full, partial)? ");
			type = c.nextLine();
			if (type.equals("in-full")||type.equals("In-full"))
			{
				System.out.print("Payment date: ");
				temp = c.nextLine();
				d = date.parse(temp);
				Calendar calendar = Calendar.getInstance();
				calendar.setTime(d);
				
				System.out.print("Expense Amount: ");
				moneyString = c.nextLine();
				String[] m = moneyString.split("\\.");
				dollars = java.lang.Integer.parseInt(m[0]);
				cents = java.lang.Integer.parseInt(m[1]);
				money = new Paid(dollars, cents);
									
				System.out.print("Who was this expense paid to? ");
				payee = c.nextLine();
							
				System.out.print("Expense category: ");
				cat = c.nextLine();
				
				payment = new InFull(money, cat, d, payee);
				list.add(0, payment);
			}
			else if (type.equals("partial")||type.equals("Partial"))
			{
				System.out.print("Payment date: ");
				temp = c.nextLine();
				d = date.parse(temp);
				Calendar calendar = Calendar.getInstance();
				calendar.setTime(d);
				
				System.out.print("Expense Amount: ");
				moneyString = c.nextLine();
				String[] m = moneyString.split("\\.");
				dollars = java.lang.Integer.parseInt(m[0]);
				cents = java.lang.Integer.parseInt(m[1]);
				money = new Paid(dollars, cents);
									
				System.out.print("Who was this expense paid to? ");
				payee = c.nextLine();
							
				System.out.print("Expense category: ");
				cat = c.nextLine();
				
				System.out.print("Expense Balance: ");
			   remainString = c.nextLine();
			   m = remainString.split("\\.");
				remdollar = java.lang.Integer.parseInt(m[0]);
				remcents = java.lang.Integer.parseInt(m[1]);
				remmoney = new Paid(remdollar, remcents);
				
				payment = new Partial(money, cat, d, payee, remmoney);
				list.add(0, payment);
			}
		}
		catch(ParseException e)
		{
			System.err.println("Invalid date");
		}
		System.out.println();
	}
	//Choice 3 - Sort
	public static void sortChoice(List<Payment> list)
	{
		Comparator<Payment> comp;
		Scanner c = new Scanner(System.in);
		int count = 0;
		String keys;
		System.out.print("Keys to sort by: ");
		keys = c.nextLine();
		System.out.println();
		String[]m = keys.split(" ");
		count = m.length;
		comp = sortHelper(m, 0, count);
		Collections.sort(list, comp);
	}
	public static Comparator<Payment> sortHelper(String[] m, int index, int size)
	{
		Comparator<Payment>comp = new ExpenseAmountComparator<Payment>();
		if (index < size)
		{
			if (m[index].equals("amount"))
			{
				comp = new ExpenseAmountDelegateComparator<Payment>(sortHelper(m, index+1, size));
			}
			else if (m[index].equals("date"))
			{
				comp = new ExpenseDateDelegateComparator<Payment>(sortHelper(m, index+1, size));
			}
			else if (m[index].equals("payee"))
			{
				comp = new ExpensePayeeDelegateComparator<Payment>(sortHelper(m, index+1, size));
			}
			else if (m[index].equals("category"))
			{
				comp = new ExpenseCategoryDelegateComparator<Payment>(sortHelper(m, index+1, size));
			}
			else
			{
				System.err.println("Invalid key\n");
			}
		}
		else
		{
			if (m[index-1].equals("amount"))
			{
				comp = new ExpenseAmountComparator<Payment>();
			}
			else if (m[index-1].equals("date"))
			{
				comp = new ExpenseDateComparator<Payment>();
			}
			else if (m[index-1].equals("payee"))
			{
				comp = new ExpensePayeeComparator<Payment>();
			}
			else if (m[index-1].equals("category"))
			{
				comp = new ExpenseCategoryComparator<Payment>();
			}
			else
			{
				System.err.println("Invalid key\n");
			}
		}
		return comp;
	}
	//Choice 4 - Save to File
	public static void saveChoice(List<Payment> list)
	{
		int size = list.size();
		Payment pay;
		File target = new File("StoredExpenses.txt");
		DateFormat formatted = new SimpleDateFormat("MM/dd/yyyy");
		System.out.println();
		try
		{
			PrintWriter w = new PrintWriter(target);
			for (int i=0; i<size; i++)
			{
				pay = list.get(i);
				w.println(pay.getType());
				w.println(formatted.format(pay.getDate()));
				w.println(pay.getCategory());
				w.println(pay.getPayee());
				w.println(pay.getPay().toString());
				w.println(pay.getRemaining().toString());
			}
			w.close();
			System.out.println("Expenses Saved");
			System.out.println();
		}
		catch (FileNotFoundException e)
		{
		}
	}
}
				
		
		