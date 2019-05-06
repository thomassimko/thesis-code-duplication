import java.io.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;



public class Main 
{
	public static void main(String[] args)
	{
		try
		{
			int userChoice = 0;
			Scanner inScan = new Scanner(System.in);
			File storedExpenses = loadFile();
			List<Expense> expensesList = readFile(storedExpenses);
			printMenu();
			userChoice = inScan.nextInt();
			inScan.nextLine();
			while (userChoice != 5)
			{
				switch (userChoice)
				{
					case 1:
						displayExpenses(expensesList);
						break;
					case 2:
						expensesList = addExpense(inScan, expensesList);
						break;
					case 3:
						expensesList = sortExpenses(inScan, expensesList);
						break;
					case 4:
						saveExpenses(expensesList, storedExpenses);
						break;
					case 5:
						break;
				}
				System.out.println();
				printMenu();
				userChoice = inScan.nextInt();
				inScan.nextLine();
			}
		}
		catch (FileNotFoundException e)
		{
			System.out.println("File not found");
		}
		catch (IOException e)
		{
			System.out.println("File was not loaded properly");
		}
	}
	
	public static void saveExpenses(List<Expense> expensesList, File saveTo)
	{
		try
		{
			PrintWriter saver = new PrintWriter(saveTo);
			for (int i = 0; i < expensesList.size(); i ++)
			{
				saver.println(expensesList.get(i).getType());
				saver.println(expensesList.get(i).getDateString());
				saver.println(expensesList.get(i).getCategory());
				saver.println(expensesList.get(i).getPaidTo());
				saver.println(expensesList.get(i).paidString());
				saver.println(expensesList.get(i).remainingString());
			}
			saver.close();
		}
		catch (FileNotFoundException e)
		{
			
		}
	}
	
	public static List<Expense> sortExpenses(Scanner s, List<Expense> expensesList)
	{
		List<String> sortChoice = getSortType(s);
		Comparator<Expense> c = createComparator(sortChoice, 0);
		Collections.sort(expensesList, c);
		return expensesList;
	}
	
	public static Comparator<Expense> createComparator(List<String> sortChoice, int i)
	{
		Comparator<Expense> comp;
		if (i == sortChoice.size() - 1)
		{
			if (sortChoice.get(i).toLowerCase().equals("amount"))
			{
				return new ExpenseAmountComparator();
			}
			else if (sortChoice.get(i).toLowerCase().equals("date"))
			{
				return new ExpenseDateComparator();
			}
			else if (sortChoice.get(i).toLowerCase().equals("payee"))
			{
				return new ExpensePayeeComparator();
			}
			else
			{
				return new ExpenseCategoryComparator();
			}
		}
		else
		{
			if (sortChoice.get(i).toLowerCase().equals("amount"))
			{
				comp =  new ExpenseAmountDelegateComparator(createComparator(sortChoice, i + 1));
				return comp;
			}
			else if (sortChoice.get(i).toLowerCase().equals("date"))
			{
				comp = new ExpenseDateDelegateComparator(createComparator(sortChoice, i + 1));
				return comp;
			}
			else if (sortChoice.get(i).toLowerCase().equals("payee"))
			{
				comp = new ExpensePayeeDelegateComparator(createComparator(sortChoice, i + 1));
				return comp;
			}
			else 
			{
				comp = new ExpenseCategoryDelegateComparator(createComparator(sortChoice, i + 1));
				return comp;
			}
		}
	}
	
	
	
	public static List<String> getSortType(Scanner s)
	{
		List<String> sortChoice = new ArrayList<String>();
		System.out.print("Keys to sort by: ");
		String input = s.nextLine();
		Scanner scan = new Scanner(input);
		while (scan.hasNext())
		{
			sortChoice.add(scan.next());
		}
		for (int i = 0; i < sortChoice.size(); i++)
		{
			String compare = sortChoice.get(i).toLowerCase();
			if (compare.equals("date") || compare.equals("category") || compare.equals("amount")
					|| compare.equals("payee"))
			{
				
			}
			else
			{
				System.out.println("Improper keys, please re-enter keys");
				return getSortType(s);
			}
		}
		return sortChoice;
	}
	
	public static List<Expense> addExpense(Scanner s, List<Expense> expensesList)
	{
		try
		{
			String type = null;
			String tempDate = null;
			Calendar date = null;
			String paidTo = null;
			String category = null;
			int dollarAmount = 0;
			int centAmount = 0;
			int remainingDollar = 0;
			int remainingCent = 0;
			String temp = null;
			
			System.out.print("Expense type (in-full, partial)? ");
			type = s.nextLine();
			type = type.toLowerCase();
			System.out.print("Payment date (MM/dd/yyyy): ");
			tempDate = s.nextLine();
			date = makeCalendar(tempDate);
			System.out.print("Expense Amount: ");
			temp = s.nextLine();
			dollarAmount = convertDollar(temp);
			centAmount = convertCent(temp);
			System.out.print("Who was this expense paid to? ");
			paidTo = s.nextLine();
			System.out.print("Expense category: ");
			category = s.nextLine();
			if (type.equals("partial"))
			{
				System.out.print("Expense Balance: ");
				temp = s.nextLine();
				remainingDollar = convertDollar(temp);
				remainingCent = convertCent(temp);
				Expense newExpense = new PartialExpense(date, dollarAmount, centAmount, 
										paidTo, category, remainingDollar, remainingCent);
				expensesList.add(newExpense);
			}
			else if(type.equals("in-full"))
			{
				Expense newExpense = new InFullExpense(date, dollarAmount, centAmount,
										paidTo, category);
				expensesList.add(newExpense);
			}
			else 
			{
				System.out.println("Please define in-full or partial expense.");
				return addExpense(s, expensesList);
			}
			return expensesList;
			
		}
		catch (ParseException e)
		{
			System.out.println("Invalid date. Please enter valid date.");
			return addExpense(s, expensesList);
		}
		catch (NoSuchElementException e)
		{
			System.out.println("Invalid amount. Please enter valid amount.");
			return addExpense(s, expensesList);
		}
	}
	
	public static void displayExpenses(List<Expense> expensesList)
	{
		for (int i = 0; i < expensesList.size(); i++)
		{
			System.out.println(expensesList.get(i).formatString());
		}
	}
	
	public static void printMenu()
	{
		System.out.println("1. Display");
		System.out.println("2. Add Expense");
		System.out.println("3. Sort");
		System.out.println("4. Save");
		System.out.println("5. Quit" + "\n");
		System.out.print("Enter choice: ");
	}
	public static File loadFile() throws IOException
	{
		File storedExpenses = new File("StoredExpenses");
		if (storedExpenses.exists())
		{
			return storedExpenses;
		}
		else 
		{
			storedExpenses.createNewFile();
			return storedExpenses;
		}
	}
	
	public static List<Expense> readFile(File storedExpenses) throws FileNotFoundException
	{
		try
		{
			Scanner s = new Scanner(storedExpenses);
			List<Expense> newList = new LinkedList<Expense>();
			while (s.hasNext())
			{
				String type = s.nextLine().toLowerCase();
				if (type.equals("in-full"))
				{
					try
					{
						Expense newInFull = readInExpense(s, type);
						newList.add(newInFull);
					}
					catch (ParseException e)
					{
						System.out.println("Date error");
					}
				}
				else if(type.equals("partial"))
				{
					try
					{
						Expense newPartial = readInExpense(s, type);
						newList.add(newPartial);
					}
					catch(ParseException e)
					{
						System.out.println("Date error");
					}
				}
				else
				{
					s.nextLine();
				}
			}
			System.out.println("File Loaded" + "\n");
			return newList;
			
		}
		catch (FileNotFoundException e)
		{
			System.out.println("File does not exist"); //should not get here
			throw e;
		}
		
	}
	
	public static Expense readInExpense(Scanner s, String type) throws ParseException
	{
		Calendar date = null;
		int dollarAmount = 0;
		int centAmount = 0;
		String paidTo = null;
		String category = null;
		int remainingDollar = 0;
		int remainingCent = 0;
		int flag = 0;
		while (s.hasNext() && flag <5)
		{
			switch (flag)
			{
				case 0:
					String temp = s.nextLine();
					try
					{
						date = makeCalendar(temp);
					}
					catch (ParseException e)
					{
						throw e;
					}
					flag ++;
					break;
				case 1:
					category = s.nextLine();
					flag ++;
					break;
				case 2:
					paidTo = s.nextLine();
					flag ++;
					break;
				case 3:
					String temp1 = s.nextLine();
					dollarAmount = convertDollar(temp1);
					centAmount = convertCent(temp1);
					flag ++;
					break;
				case 4:
					String temp2 = s.nextLine();
					remainingDollar = convertDollar(temp2);
					remainingCent = convertCent(temp2);
					flag ++;
					break;
			}
		}
		if (type.equals("in-full"))
		{
			return new InFullExpense(date, dollarAmount, centAmount, paidTo, category);
		}
		else 
		{
			return new PartialExpense(date, dollarAmount, centAmount, paidTo, category, 
									remainingDollar, remainingCent);
		}
	}
	
	
	public static Calendar makeCalendar(String s) throws ParseException
	{
		try
		{
			DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
			Date d = df.parse(s);
			Calendar c = Calendar.getInstance();
			c.setTime(d);
			return c;
		}
		catch(ParseException e)
		{
			throw e;
		}
	}
	
	public static int convertDollar(String s)
	{
		Scanner scan = new Scanner(s);
		if (scan.hasNextDouble())
		{
			double temp = scan.nextDouble();
			return (int)temp;
		}
		else throw new NoSuchElementException();
	}
	
	public static int convertCent(String s)
	{
		Scanner scan = new Scanner(s);
		if (scan.hasNextDouble())
		{
			double temp = scan.nextDouble();
			int dollar = (int)temp;
			return (int)((temp - dollar) * 100);
		}
		else throw new NoSuchElementException();
	}
}
