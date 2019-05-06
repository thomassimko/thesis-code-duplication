import java.io.*;
import java.text.*;
import java.util.*;

public class TrackExpenses
{
	private static final int
		CHOICE_DISPLAY = 1,
		CHOICE_ADD_EXPENSE = 2,
		CHOICE_SORT = 3,
		CHOICE_SAVE = 4,
		CHOICE_QUIT = 5;

	private static final String
		KEY_AMOUNT = "amount",
		KEY_CATEGORY = "category",
		KEY_DATE = "date",
		KEY_PAYEE = "payee";

	private static boolean isPartial(String str)
		throws InvalidTypeException
	{
		if(str.equals("partial"))
		{
			return true;
		}
		else if(str.equals("in-full"))
		{
			return false;
		}
		else
		{
			throw new InvalidTypeException();
		}
	}

	private static Calendar strToDate(String str)
		throws InvalidFormatException
	{
		DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
		Calendar date = Calendar.getInstance();
		try
		{
			date.setTime(df.parse(str));
		}
		catch(ParseException e)
		{
			throw new InvalidFormatException("Invalid Date");
		}

		return date;
	}

	private static void display(List<Expense> expenses)
	{
		System.out.println();
		
		for(Expense entry : expenses)
		{
			System.out.println(entry.toString());
		}
	}

	private static void addExpense(List<Expense> expenses, Scanner input)
	{
		try
		{
			System.out.print("Expense type (in-full, partial)? ");
			String type = input.nextLine();

			boolean isPartial = isPartial(type); // if type is valid, continue

			System.out.print("Payment date: ");
			String d = input.nextLine();
			Calendar date = strToDate(d);

			System.out.print("Expense Amount: ");
			String p = input.nextLine();
			Amount paid = Amount.parseAmount(p);

			System.out.print("Who was this expense paid to? ");
			String payee = input.nextLine();

			System.out.print("Expense category: ");
			String category = input.nextLine();


			if(isPartial) // if type is partial, ask for balance
			{
				System.out.print("Expense Balance: ");
				String r = input.nextLine();

				Amount remaining = Amount.parseAmount(r);

				expenses.add(new PartialExpense(date, category, payee, paid, remaining));
			}
			else
			{
				expenses.add(new InFullExpense(date, category, payee, paid));
			}
		}
		catch(InvalidTypeException e)
		{
			System.err.println();
			System.err.println("Invalid Type");
		}
		catch(InvalidFormatException e)
		{
			System.err.println();
			System.err.println(e.getMessage());
		}
	}

	private static void sort(List<Expense> expenses, Scanner input)
	{
		List<Comparator<Expense>> compList = new ArrayList<Comparator<Expense>>();

		System.out.print("Keys to sort by: ");
		String str = input.nextLine();

		Scanner read = new Scanner(str);

		while(read.hasNext())
		{
			String key = read.next();

			try
			{
				compList.add(keyToComp(key));
			}
			catch(InvalidKeyException e)
			{
				System.err.println("Invalid key '" + e.getMessage() + "' was ignored.");
			}
		}

		read.close();

		try
		{
			int lastIndex = compList.size() - 1;
			Collections.sort(expenses, comp(lastIndex, compList));
		}
		catch(IndexOutOfBoundsException e)
		{
			// if no valid keys were given, don't sort anything
		}
	}

	private static Comparator<Expense> keyToComp(String key)
		throws InvalidKeyException
	{
		if(key.equals(KEY_AMOUNT))
		{
			return new ExpenseAmountComparator();
		}
		else if(key.equals(KEY_CATEGORY))
		{
			return new ExpenseCategoryComparator();
		}
		else if(key.equals(KEY_DATE))
		{
			return new ExpenseDateComparator();
		}
		else if(key.equals(KEY_PAYEE))
		{
			return new ExpensePayeeComparator();
		}
		else
		{
			throw new InvalidKeyException(key);
		}
	}

	private static Comparator<Expense> comp(int curIndex, List<Comparator<Expense>> compList)
	{
		Comparator<Expense> cur = compList.get(curIndex);

		if(curIndex == 0)
		{
			return cur;
		}

		return new ExpenseDelegateComparator(comp(curIndex-1, compList), cur);
	}

	private static void save(List<Expense> expenses)
	{
		try
		{
			PrintWriter file = new PrintWriter(new File("StoredExpenses"));

			for(Expense entry : expenses)
			{
				file.println(entry.getType());
				file.println(entry.getDateString());
				file.println(entry.getCategory());
				file.println(entry.getPayee());
				file.println(entry.getPaidString());
				file.println(entry.getRemainingString());
			}

			file.close();
			
			System.out.println();
			System.out.println("Expenses Saved");
		}
		catch(FileNotFoundException e)
		{
			System.err.println("Save Failed");
		}
	}

	private static void open(List<Expense> expenses, Scanner file)
		throws InvalidTypeException, InvalidFormatException
	{
		while(file.hasNextLine())
		{
			String type = file.nextLine();
			String d = file.nextLine();
			String category = file.nextLine();
			String payee = file.nextLine();
			String p = file.nextLine();
			String r = file.nextLine();

			Calendar date = strToDate(d);
			Amount paid = Amount.parseAmount(p);
			Amount remaining = Amount.parseAmount(r);

			if(isPartial(type))
			{
				expenses.add(new PartialExpense(date, category, payee, paid, remaining));
			}
			else
			{
				expenses.add(new InFullExpense(date, category, payee, paid));
			}
		}
	}

	private static void operations(List<Expense> expenses, int choice, Scanner input)
		throws InvalidChoiceException
	{
		if(choice == CHOICE_DISPLAY)
		{
			display(expenses);
		}
		else if(choice == CHOICE_ADD_EXPENSE)
		{
			addExpense(expenses, input);
		}
		else if(choice == CHOICE_SORT)
		{
			sort(expenses, input);
		}
		else if(choice == CHOICE_SAVE)
		{
			save(expenses);
		}
		else if(choice == CHOICE_QUIT)
		{
			input.close();
			System.exit(0);
		}
		else
		{
			throw new InvalidChoiceException();
		}
	}

	private static int menu(Scanner input)
		throws InvalidChoiceException
	{
		System.out.println();
		System.out.println("1. Display");
		System.out.println("2. Add Expense");
		System.out.println("3. Sort");
		System.out.println("4. Save");
		System.out.println("5. Quit");
		System.out.println();

		System.out.print("Enter choice: ");

		try
		{
			String c = input.nextLine();
			return Integer.parseInt(c);
		}
		catch(NumberFormatException e)
		{
			throw new InvalidChoiceException();
		}
	}

	private static void UI(List<Expense> expenses, Scanner input)
	{
		try
		{
			operations(expenses, menu(input), input);
		}
		catch(InvalidChoiceException e)
		{
			System.err.println();
			System.err.println("Invalid Menu Choice");
		}
		finally
		{
			UI(expenses, input);
		}
	}

	public static void main(String [] args)
	{
		List<Expense> expenses = new ArrayList<Expense>();

		Scanner file = null;

		try
		{
			file = new Scanner(new File("StoredExpenses"));
			open(expenses, file);
			System.out.println("File Loaded");
			file.close();
		}
		catch(FileNotFoundException e)
		{
		}
		catch(Exception e)
		{
			System.err.println("Not all entries were read.");
			file.close();
		}

		UI(expenses, new Scanner(System.in));
	}
}