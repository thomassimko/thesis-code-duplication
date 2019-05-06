import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

//TODO SORTS, If date does not parse correctly end reading
public class IO
{
	public static void main(String [] args)
	{
		List<Expense> expenses;
		File input = new File(args[0]);
		Scanner s = null;
		Scanner user = new Scanner(System.in);
		int option = 0;
		
		try
		{
			s = new Scanner(input);
		}
		catch(FileNotFoundException e)
		{
			System.err.println("File not found!");
			e.printStackTrace();
		}

		expenses = readFile(s);

		System.out.println("File Loaded\n");
		
		while(option != 5)
		{
			options();
			try
			{
				option = user.nextInt();
			}
			catch(InputMismatchException e)
			{
				System.out.println("Invalid input");
				user.nextLine();
			}
			expenses = optionsInput(s, expenses, input, option);
		}
	}
	
	private static void options()
	{
		System.out.println("1. Display");
		System.out.println("2. Add Expense");
		System.out.println("3. Sort");
		System.out.println("4. Save");
		System.out.println("5. Quit\n");
		System.out.print("Enter Choice: ");
	}
	
	private static List<Expense> optionsInput(Scanner s, List<Expense> expenses, File input, int choice)
	{	
		Scanner user = new Scanner(System.in);
		
			switch(choice)
			{
			case 1:
				
				displayOption(expenses);
				
				break;

			case 2:
				
				addOption(user, expenses);
				
				break;
				
			case 3:
				
				return sortOption(user, expenses);
				
			case 4:
				
				saveOption(expenses, input);
				
				break;
				
			case 5:
				s.close();
				break;
				
			default:
				break;
			}
			System.out.println("");
			return expenses;
	}
	
	private static LinkedList<Expense> readFile(Scanner s)
	{
		List<Expense> e = new LinkedList<Expense>(); 
		while(s.hasNextLine())
		{
			//System.err.println("HAS NEXT");
			String typeStr = s.nextLine();

			if(typeStr.equals("in-full") && s.hasNextLine())
			{
				//System.err.println("READING DATE");
				Calendar c;
				try
				{
					c = makeCalendar(s);
				}
				catch(DateParseException dP)
				{
					System.err.println("Error in parsing. Continuing with read expenses");
					break;
				}
				//System.err.println("READING DESCRIPTION");
				String d = s.nextLine();
				//System.err.println("READING PAYEE");
				String p = s.nextLine();
				//System.err.println("READING MONEY");
				Money a = new Money(s.nextLine());
				e.add(new FullPayment(c, a, p, d));
				//System.err.println(e.get(i++));
			}
			else
			{
				if(s.hasNextLine())
				{
					Calendar c;
					try
					{
						c = makeCalendar(s);
					}
					catch(DateParseException dP)
					{
						System.err.println("Error in parsing. Continuing with read expenses");
						break;
					}
					String d = s.nextLine();
					String p = s.nextLine();
					Money a = new Money(s.nextLine());
					Money r = new Money(s.nextLine());
					e.add(new PartialPayment(c, a, p, d, r));
				}
			}
		}
		return (LinkedList<Expense>) e;
	}
	
	private static Calendar makeCalendar(Scanner s) throws DateParseException
	{
		String str = s.nextLine();
		DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
		Date d = null;
		try
		{
			d = df.parse(str);
		}
		catch (ParseException e)
		{
			System.err.println("Parse Exception");
			throw new DateParseException();
		}
		Calendar c = Calendar.getInstance();
		c.setTime(d);
		return c;
	}
	
	private static Calendar makeCalendar(String str) throws DateParseException
	{
		DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
		Date d = null;
		try
		{
			d = df.parse(str);
		}
		catch (ParseException e)
		{
			System.err.println("Parse Exception");
			throw new DateParseException();
		}
		Calendar c = Calendar.getInstance();
		c.setTime(d);
		return c;
	}
	
	private static String dateToString(Calendar c)
	{
		return String.format("%1$2tm/%<2td/%<tY ", c);
	}
	
	private static String printFormat(Calendar c, String p, Money a, String d)
	{
		return String.format("%1$2tm/%<2td/%<tY ", c)
				+ String.format("%-15.15s %s [%s]", p, a.toString(), d);
	}
	
	private static String printFormat(Calendar c, String p, Money a, String d, Money r)
	{
		return String.format("%1$2tm/%<2td/%<tY ", c)
				+ String.format("%-15.15s %s (%s) [%s]", p, a.toString(),
						r.toString(), d);
	}
	
	private static void displayOption(List<Expense> expenses)
	{
		int size = expenses.size();
		
		System.out.println("");
		for(int i = 0; i < size; i++)
		{
			Expense e = expenses.get(i);
			if(e.getType().equals("in-full"))
			{
				System.out.println(printFormat(e.getDate(), e.getPayee(),
					e.getAmount(), e.getDescription()));
			}
			else
			{
				System.out.println(printFormat(e.getDate(), e.getPayee(),
						e.getAmount(), e.getDescription(), e.getRemaining()));
			}
		}
	}

	private static void addOption(Scanner user, List<Expense> expenses)
	{
		System.out.print("Expense type (in-full, partial)? ");
		String type = user.nextLine();
		if(type.equals("in-full"))
		{
			System.out.print("Payment date: ");
			Calendar c = null;
			try
			{
				c = makeCalendar(user.nextLine());
			} catch (DateParseException e)
			{
				System.err.println("Error in parsing. Continuing with read expenses");
			}
			System.out.print("Expense Amount: ");
			Money a = new Money(user.nextLine());
			System.out.print("Who was this expense paid to? ");
//			user.nextLine();
			String payee = user.nextLine();
			System.out.print("Expense category: ");
			String descrip = user.nextLine();
			expenses.add(0, new FullPayment(c, a, payee, descrip));
		}	
		else if(type.equals("partial"))
		{
			System.out.print("Payment date: ");
			Calendar c = null;
			try
			{
				c = makeCalendar(user.nextLine());
			} catch (DateParseException e)
			{
				System.err.println("Error in parsing. Continuing with read expenses");
			}
			System.out.print("Expense Amount: ");
			Money a = new Money(user.nextLine());
			System.out.print("Who was this expense paid to? ");
//			user.nextLine();
			String payee = user.nextLine();
			System.out.print("Expense category: ");
			String descrip = user.nextLine();
			System.out.print("Expense Balance: ");
			Money r = new Money(user.nextLine());
			expenses.add(0, new PartialPayment(c, a, payee, descrip, r));
		}
		else
		{
			System.out.println("Not a valid entry");
		}
	}
	
	private static List<Expense> sortOption(Scanner user, List<Expense> expenses)
	{
		boolean amount;
		boolean category;
		boolean date;
		boolean payee;
		List<Expense> newList = new LinkedList<Expense>();
		
		System.out.print("Keys to sort by: ");
		String key = user.nextLine();
		Scanner keys = new Scanner(key);
		
		amount = key.contains("amount");
		category = key.contains("category");
		date = key.contains("date");
		payee = key.contains("payee");
		
		if(!amount && !category && !date && !payee)
		{
			System.out.println("No valid keys entered");
			return expenses;
		}
		else
		{
			List<String> keyList = new LinkedList<String>();
			
			while(keys.hasNext())
			{
				String keyCheck = keys.next();
				if(keyCheck.equals("amount") || keyCheck.equals("category") ||
						keyCheck.equals("date") ||keyCheck.equals("payee"))
				{
					if(!keyList.contains(keyCheck))
					{
						keyList.add(keyCheck);
					}
				}
				else
				{
					System.out.println("Invalid key entered");
					return expenses;
				}
			}
			
			int length = keyList.size() - 1;
			
			Comparator<Expense> c1 = null;
			
				if(keyList.get(length).equals("amount"))
				{
					c1 = new AmountComparator();
				}
				else if(keyList.get(length).equals("category"))
				{
					c1 = new CategoryComparator();
				}
				else if(keyList.get(length).equals("date"))
				{
					c1 = new DateComparator();
				}
				else if(keyList.get(length).equals("payee"))
				{
					c1 = new PayeeComparator();
				}

				for(int i = length - 1; i >= 0; i--)
				{
					String keyString = keyList.get(i);
					if(keyString.equals("amount"))
					{
						c1 = new ExpenseDelegateComparitor(new AmountComparator(), c1);
					}
					else if(keyString.equals("category"))
					{
						c1 = new ExpenseDelegateComparitor(new CategoryComparator(), c1);
					}
					else if(keyString.equals("date"))
					{
						c1 = new ExpenseDelegateComparitor(new DateComparator(), c1);
					}
					else if(keyString.equals("payee"))
					{
						c1 = new ExpenseDelegateComparitor(new PayeeComparator(), c1);
					} 
				}			
				
				int size = expenses.size();
				
				for(int i = 0; i < size; i++)
				{
					newList.add(expenses.get(i));
				}
				
				Collections.sort(newList, c1);
				
				}
				return (LinkedList<Expense>) newList;
			}
	
	
	private static void saveOption(List<Expense> expenses, File input)
	{
		PrintWriter p = null;
		try
		{
			p = new PrintWriter(input);
		}
		catch(FileNotFoundException e1)
		{
			System.err.println("File not found!");
			e1.printStackTrace();
		}
		int size = expenses.size();
		for(int i = 0; i < size; i++)
		{
			Expense exp = expenses.get(i);
			if(exp.getType().equals("in-full"))
			{
				p.println(exp.getType());
				p.println(dateToString(exp.getDate()));
				p.println(exp.getDescription());
				p.println(exp.getPayee());
				p.println(exp.getAmount().toString());
			}
			else
			{
				p.println(exp.getType());
				p.println(dateToString(exp.getDate()));
				p.println(exp.getDescription());
				p.println(exp.getPayee());
				p.println(exp.getAmount().toString());
				p.println(exp.getRemaining().toString());
			}

		}
		p.close();
		System.out.println("Expenses Saved");
	}
}
