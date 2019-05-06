import java.util.*;
import java.io.*;
import java.text.*;

public class ExpenseProgram
{
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		List<Expense> expenses = new LinkedList<Expense>();
		expenses = fileIO();
		programRun(input, expenses);
	}
	
	//method that loops until the program exits; this method controls the menu screen
	public static void programRun(Scanner input, List<Expense> expenses)
	{
		int choice = -1;
		while(choice != 5)
		{
			choice = firstInput(input);
			optionSelection(input, choice, expenses);
		}
	}
	
	//option method that takes care of the options 
	public static void optionSelection(Scanner input, int choice, List<Expense> expenses)
	{	
		switch(choice)
		{
			case 1:
				for(int i = 0; i < expenses.size(); i++)
				{
					System.out.println(display(expenses, i));
				}
				break;
			case 2:
				expenses.add(secondInput(input, expenses));
				break;
			case 3:
				List<String> keys = sortIO(input);
				if(keys.size() > 0)
				{
					sort(input, expenses, keys);
				}
				else
				{
					System.err.println("No keys found, select another operation");
					programRun(input, expenses);
				}
				break;
			case 4:
				save(expenses);
				break;
			case 5:
				System.exit(1);
				break;
			default:
				System.err.println("Invalid selection");
				programRun(input, expenses);
				break;
		}
	}
	
	//method that saves the expenses to the "StoredExpenses" file
	public static void save(List<Expense> expenses)
	{
		PrintWriter write = null;
		int size = expenses.size();
		try 
		{
			write = new PrintWriter(new File("StoredExpenses"));
			for(int i = 0; i < size; i++)
			{
				write.println(expenses.get(i).getType());
				write.println(expenses.get(i).stringDate());
				write.println(expenses.get(i).getCategory());
				write.println(expenses.get(i).getPaidTo());
				write.println(expenses.get(i).getAmount());
				write.println(expenses.get(i).getRemainingAmount());
			}
		} 
		catch (FileNotFoundException e) 
		{
			System.err.println("No file called StoredExpenses");
			//File file = new File("StoredExpenses");
		}
		write.close();
	} 
	
	public static List<String> sortIO(Scanner input)
	{
		List<String> keys = new ArrayList<String>();
		System.out.print("Keys to sort by: ");
		Scanner scan = new Scanner(input.nextLine());
		while(scan.hasNext())
		{
			keys.add(0, scan.next());
		}
		return keys;
	}
	
	//method that sorts the expenses by what the user specifies 
	public static void sort(Scanner input, List<Expense> expenses, List<String> keys)
	{
		Comparator<Expense> comp = null;
		
		if(keys.get(0).equals("amount"))
		{
			comp = new ExpenseAmountComparator();
		}
		else if(keys.get(0).equals("date"))
		{
			comp = new ExpenseDateComparator();
		}
		else if(keys.get(0).equals("payee"))
		{
			comp = new ExpensePayeeComparator();
		}
		else if(keys.get(0).equals("category"))
		{
			comp = new ExpenseCategoryComparator();
		}
		else
		{
			System.err.println("Invalid choice. Please enter your keys again.");
			programRun(input, expenses);
		}
		
		for(int i = 0; i < keys.size(); i++)
		{
			if(keys.get(i).equals("amount"))
			{
				comp = new ExpenseAmountDelegateComparator(comp);
			}
			else if(keys.get(i).equals("date"))
			{
				comp = new ExpenseDateDelegateComparator(comp);
			}
			else if(keys.get(i).equals("payee"))
			{
				comp = new ExpensePayeeDelegateComparator(comp);
			}
			else if(keys.get(i).equals("category"))
			{
				comp = new ExpenseCategoryDelegateComparator(comp);
			}
			else
			{
				System.err.println("Invalid choice. Please enter your keys again.");
				programRun(input, expenses);
			}
		}
		Collections.sort(expenses, comp);
	}
	
	//method that prints out the expenses that have been entered 
	public static String display(List<Expense> expenses, int i)
	{
		return expenses.get(i).toString();
	}

	public static List<Expense> fileIO()
	{
		List<Expense> expenses = new LinkedList<Expense>();
		try
		{
			Scanner read = new Scanner(new File("StoredExpenses"));
			DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
			
			while(read.hasNextLine())
			{
				try
				{
					//read in the type of expense (partial or in-full)
					String type = read.nextLine();
	
					//read in the date from the file and parse it to the correct format
					String date = read.nextLine();
					Date currentDate = dateFormat.parse(date);
				
					//read in the category
					String category = read.nextLine();
					
					//read in the payee
					String paidTo = read.nextLine();

					//read in the amount paid and split the dollars and cents up
					String amount = read.nextLine();
					//find the index of the period and break the dollars and cents into substrings 
					int index1 = amount.indexOf(".");
					String dollarBuffer = amount.substring(0, index1);
					String centBuffer = amount.substring(index1 + 1);
					int dollars = Integer.parseInt(dollarBuffer);
					int cents = Integer.parseInt(centBuffer);

					//read in the remaining amount and split up the dollars and cents 
					String remainingAmount = read.nextLine();
					//find the index of the period and break the dollars and cents into substrings
					int index2 = remainingAmount.indexOf(".");
					String remainingDollarBuffer = remainingAmount.substring(0, index2);
					String remainingCentBuffer = remainingAmount.substring(index2 + 1);
					int remainingDollars = Integer.parseInt(remainingDollarBuffer);
					int remainingCents = Integer.parseInt(remainingCentBuffer);
	
					//create the new expense either partial or in-full depending on if the remaining dollars and cents are 0 or not
					if(remainingDollars != 0 && remainingCents != 0)
					{
						Expense expense = new PartialExpense(category, paidTo, date, currentDate, dollars, cents, remainingDollars, remainingCents);
						expenses.add(expense);
					}
					else
					{
						Expense expense = new InFullExpense(category, paidTo, date, currentDate, dollars, cents);
						expenses.add(expense);
					}
				}
				//error handling
				catch(ParseException e)
				{
					System.err.println("An error occured while reading in the date");
				}
				catch(Exception e)
				{
					System.err.println("An error occured while reading in data");
				}
			}
			System.out.print("File loaded\n");
		}
		catch(FileNotFoundException e)
		{
			System.err.println("No file called StoredExpenses");
		}
		return expenses;
	}
	
	//firstInput prints out the options menu and returns the option chosen
	public static int firstInput(Scanner input)
	{
		System.out.println("");
		System.out.println("1.  Display");
		System.out.println("2.  Add Expense");
		System.out.println("3.  Sort");
		System.out.println("4.  Save");
		System.out.println("5.  Quit");
		System.out.println("");
		
		System.out.print("Enter choice: ");
		int choice = input.nextInt();

		input.nextLine();
		
		return choice;
	}
	
	//secondInput is only used if the user adds an expense (option 2), it returns an Expense which is added to the list of expenses
	public static Expense secondInput(Scanner input, List<Expense> expenses)
	{
		Expense expense = null;
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		String s = null;
		
		System.out.print("Expense type (in-full, partial)? ");
		String type = input.nextLine();
		
		System.out.print("Payment date: ");
		String date = input.nextLine();
		Date currentDate = null;
		try 
		{
			currentDate = dateFormat.parse(date);
		} 
		catch (ParseException e) 
		{
			programRun(input, expenses);
		}
		
		System.out.print("Expense Amount: ");
		String amount = input.nextLine();
		int index1 = amount.indexOf(".");
		String dollarBuffer = amount.substring(0, index1);
		String centBuffer = amount.substring(index1 + 1);
		int dollars = Integer.parseInt(dollarBuffer);
		int cents = Integer.parseInt(centBuffer);
		
		System.out.print("Who was this expense paid to? ");
		String paidTo = input.nextLine();
		
		System.out.print("Expense category: ");
		String category = input.nextLine();
		
		if(type.equals("partial"))
		{
			System.out.print("Expense balance: ");
			String remainingAmount = input.nextLine();
			int index2 = remainingAmount.indexOf(".");
			String remainingDollarBuffer = remainingAmount.substring(0, index2);
			String remainingCentBuffer = remainingAmount.substring(index2 + 1);
			int remainingDollars = Integer.parseInt(remainingDollarBuffer);
			int remainingCents = Integer.parseInt(remainingCentBuffer);
			
			expense = new PartialExpense(category, paidTo, date, currentDate, dollars, cents, remainingDollars, remainingCents);
		}
		else
		{
			expense = new InFullExpense(category, paidTo, date, currentDate, dollars, cents);
		}
			
		return expense;
	}
}
