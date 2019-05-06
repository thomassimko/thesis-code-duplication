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
import java.util.List;
import java.util.Scanner;


public class ExpenseTracker 
{
	static Scanner userInput = new Scanner(System.in);
	public static void main(String[] args)
	{
		
		
		List<Expenses> list = new ArrayList<Expenses>();
		int x = 0;
		try {
			makeList(list);
		} catch (Exception e) {
			System.out.println("An error has occurred when reading. A partial list has been created.");
		}
		
		System.out.println("File Loaded");
		
		while(x == 0)
			input(list);
	}
		
	public static void input(List<Expenses> list)
	{

		String response = "";
		int value = 0;
			System.out.println("");
			System.out.println("1. Display");
			System.out.println("2. AddExpense");
			System.out.println("3. Sort");
			System.out.println("4. Save");
			System.out.println("5. Quit");
			System.out.println("");

			System.out.print("Enter choice: ");
			userInput.hasNextLine();
			response = userInput.nextLine();
			try{
				value = Integer.parseInt(response);
			}catch(NumberFormatException e){}
			
			if(value == 1)
			{
				System.out.println("");
				display(list);
			}
			else if(value == 2)
			{
				try {
					addExpense(list);
				} catch (ExpenseReadException e) {}
			}
			else if(value == 3)
			{
				sort(list);
			}
			else if(value == 4)
			{
				System.out.println("");
				saveExpenses(list);
				System.out.println("Expenses Saved");
			}
			else if(value == 5)
			{
				System.exit(0);
			}
			else System.out.println("Invalid operation number, please try again");
		}
	
	public static void sort(List<Expenses> list)
	{
		System.out.print("Keys to sort by: ");
		userInput.hasNextLine();
		List<String> keyHolder = new ArrayList<String>();
		String keys = userInput.nextLine() + " ";
		int size = keys.length();
		int j = 0;
		
		for(int i = 0; i < size; i++)
		{
			if(keys.charAt(i) == ' ')
			{
				keyHolder.add(keys.substring(j, i).trim());	
				j = i+1;
			}
		}
		try {
			if(keyHolder.size() > 0)
			{
				Comparator<Expenses> comp = sortHelper(keyHolder, 0);
				Collections.sort(list, comp);
			}
					} catch (ExpenseReadException e) 
		{
			System.out.println("Invalid key entry. Please try again");
		} 
		
		
	}
	
	public static Comparator<Expenses> sortHelper(List<String> keys, int index) throws ExpenseReadException
	{
		if(keys.size()-1 == index)	
		{
			if(keys.get(index).equals("category"))
			{
				Comparator<Expenses> comp = new ExpenseDelegateComparator(new ExpenseCategoryComparator(), new ExpenseCategoryComparator());
				return comp;
			}
			if(keys.get(index).equals("date"))
			{
				Comparator<Expenses> comp = new ExpenseDelegateComparator(new ExpenseDateComparator(), new ExpenseDateComparator());
				return comp;
			}
			if(keys.get(index).equals("amount"))
			{
				Comparator<Expenses> comp = new ExpenseDelegateComparator(new ExpenseAmountComparator(), new ExpenseAmountComparator());
				return comp;
			}
			if(keys.get(index).equals("payee"))
			{
				Comparator<Expenses> comp = new ExpenseDelegateComparator(new ExpensePayeeComparator(), new ExpensePayeeComparator());
				return comp;
			}
		}
		
			if(keys.get(index).equals("category"))
			{
				Comparator<Expenses> comp = new ExpenseDelegateComparator(new ExpenseCategoryComparator(), sortHelper(keys, index+1));
				return comp;
			}
			if(keys.get(index).equals("date"))
			{
				Comparator<Expenses> comp = new ExpenseDelegateComparator(new ExpenseDateComparator(), sortHelper(keys, index+1));
				return comp;
			}
			if(keys.get(index).equals("amount"))
			{
				Comparator<Expenses> comp = new ExpenseDelegateComparator(new ExpenseAmountComparator(), sortHelper(keys, index+1));
				return comp;
			}
			if(keys.get(index).equals("payee"))
			{
				Comparator<Expenses> comp = new ExpenseDelegateComparator(new ExpensePayeeComparator(), sortHelper(keys, index+1));
				return comp;
			}
			else 
			{
				throw new ExpenseReadException();
			}
		
		
	}
	
	
	public static void saveExpenses(List<Expenses> list)
	{
		File out = new File("StoredExpenses.txt");
		try {
			PrintWriter writer = new PrintWriter(out);
			int size = list.size();
			for(int i = 0; i < size; i++)
			{
				list.get(i).save(writer);
			}
			writer.close();
			
		} catch (FileNotFoundException e) {
			System.out.println("The file cannot be found");
		}
	}
	
	
	
	public static void addExpense(List<Expenses> list)
		throws ExpenseReadException
	{
		String type = "", paidTo = "", amount = "", remaining = "", category = "";
		Calendar c = Calendar.getInstance();
		DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
		Date d;
		System.out.print("Expense type (in-full, partial)? ");
		userInput.hasNextLine();
		type = userInput.nextLine();
		if(type.compareTo("partial") != 0 && type.compareTo("in-full") != 0)
		{
			System.out.println("Not a compatible expense, please try again.");
			throw new ExpenseReadException();
		}

		System.out.print("Payment date: ");
		userInput.hasNextLine();
		String temp = userInput.nextLine();
		try {
			d = df.parse(temp);
			c.setTime(d);
		} catch (ParseException e) {
			System.out.println("The date was entered incorrectly");
			throw new ExpenseReadException();
		}
		System.out.print("Payment Amount: ");
		userInput.hasNextLine();
		amount = userInput.nextLine();
		System.out.print("Who was this expense paid to? ");
		userInput.hasNextLine();
		paidTo = userInput.nextLine();
		System.out.print("Expense category: ");
		userInput.hasNextLine();
		category = userInput.nextLine();
		if(type.equals("partial"))
		{
			System.out.print("Expense Balance: ");
			userInput.hasNextLine();
			remaining = userInput.nextLine();
			list.add(new PartialExpense(c, category, paidTo, amount, remaining));
		}
		else
		{
			list.add(new FullExpense(c, category, paidTo, amount));
		}
		
		
	}
	
	public static void display(List<Expenses> list)
	{
		int size = list.size();
		for(int i = 0; i < size; i++)
		{
			list.get(i).display(); 
		}
	}
	
	
	
	public static void makeList(List<Expenses> list) throws Exception
	{
		File in = new File("StoredExpenses.txt");
		try 
		{
			Scanner fileInput = new Scanner(in);

			String type = "";
			while(fileInput.hasNextLine())
			{
				type = fileInput.nextLine();
				String paidTo = "", amount = "", remaining = "", category = "";
				Calendar c = Calendar.getInstance();
				if(fileInput.hasNextLine())
				{
					DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
					Date d;
					try {
						d = df.parse(fileInput.nextLine());
						c.setTime(d);
					} catch (ParseException e) {
						throw new ExpenseReadException();
					}
					
				}
				else throw new ExpenseReadException();
				if(fileInput.hasNextLine())
				{
					category = fileInput.nextLine();
				}
				else throw new ExpenseReadException();
				if(fileInput.hasNextLine())
				{
					paidTo = fileInput.nextLine();
				}
				else throw new ExpenseReadException();
				if(fileInput.hasNextLine())
				{
					amount = fileInput.nextLine();
				}
				else throw new ExpenseReadException();
				if(fileInput.hasNextLine())
				{
					remaining = fileInput.nextLine();
				}
				else throw new ExpenseReadException();
				if(type.equals("partial"))
				{
					list.add(new PartialExpense(c, category, paidTo, amount, remaining));
				}
				else if (type.equals("in-full"))
				{
					list.add(new FullExpense(c, category, paidTo, amount));
				}
		
			}

		} catch (FileNotFoundException e) 
		{
			System.out.println("The stored expenses file cannot be found. A new one will be created when you save this session.");
		}
	}
	
		

		
	
	
	
	
	
}

