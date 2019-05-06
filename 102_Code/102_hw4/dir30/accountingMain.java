import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.security.InvalidKeyException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class accountingMain 
{
	private static File infile;
	private static Boolean fileDoesNotExist = true;
	private static List<expense> expenses;
	
	private static Comparator<expense> comp1;
	private static Comparator<expense> comp2;
	private static Comparator<expense> comp3;
	private static Comparator<expense> comp4;
	private static Comparator<expense> delegateComparator;
	private static int keys = 0;

	
	public static void main(String[] args) 
	{
		createFile();
		checkFile();
		
		expenses = new ArrayList<expense>();
		
		if(!fileDoesNotExist)
		{
			Scanner s = null;
			
			try 
			{
				s = new Scanner(infile);
			} 
			catch (FileNotFoundException e) 
			{
				
			}
			
			while(s.hasNext())
			{
				try
				{
					readFileExpenses(s);
				}
				catch (NoSuchElementException e)
				{
					System.out.println("Not all contents read from file");
				}
				catch (StringIndexOutOfBoundsException e)
				{
					
				}

				if(s.hasNext())
				{
					s.nextLine();
				}
			}
			
			System.out.println("File Loaded");
			System.out.println("");
		}
		
		Scanner s = null;
			
		s = new Scanner(System.in);
		
		userChoice(s);
	}

	private static void createFile() 
	{
		infile = new File("StoredExpenses");
	}
	
	private static void checkFile() 
	{
		try 
		{
			fileDoesNotExist = infile.createNewFile();
		} 
		catch (IOException e1) 
		{

		}
	}
	
	private static void readFileExpenses(Scanner s)
	{
		expenseFileReader fileReader = new expenseFileReader(s);
		
		if(fileReader.getType().equals("partial"))
		{
			String type = "partial";
			Date date = fileReader.getDate();
			String category = fileReader.getCategory();
			String paidTo = fileReader.getPaidTo();
			int amountPaidDollars = fileReader.getAmountDollars();
			int amountPaidCents = fileReader.getAmountCents();
			int amountRemainingDollars = fileReader.getAmountRemainingDollars();
			int amountRemainingCents = fileReader.getAmountRemainingCents();
			
			expense e = new partialExpense(type, date, category, paidTo, amountPaidDollars, amountPaidCents, 
					amountRemainingDollars, amountRemainingCents);
			
			expenses.add(e);
		}
		else
		{
			String type = "in-full";
			Date date = fileReader.getDate();
			String category = fileReader.getCategory();
			String paidTo = fileReader.getPaidTo();
			int amountPaidDollars = fileReader.getAmountDollars();
			int amountPaidCents = fileReader.getAmountCents();
			
			expense e = new inFullExpense(type, date, category, paidTo, amountPaidDollars, amountPaidCents);
			
			expenses.add(e);
		}
	}

	private static void userChoice(Scanner s)
	{
		int userChoice;
		
		System.out.println("1. Display");
		System.out.println("2. Add Expense");
		System.out.println("3. Sort");
		System.out.println("4. Save");
		System.out.println("5. Quit");
		System.out.println("");
		System.out.print("Enter choice: ");
		userChoice = s.nextInt();
		
		switch(userChoice)
		{
			case 1:
			{
				display(s);
				break;
			}
			case 2:
			{
				addExpense(s);
				break;
			}
			case 3:
			{
				sort(s);
				break;
			}
			case 4:
			{
				save(s);
				break;
			}
			case 5:
			{
				return;
			}
			default:
			{
				System.out.println("Invalid  input.");
				userChoice(s);
				break;
			}
		}
		userChoice(s);
	}

	private static void display(Scanner s) 
	{
		System.out.println("");
		
		for(int i = 0; i < expenses.size(); i++)
		{
			expense e = expenses.get(i);
			Date date = e.getDate();
			String paidTo = e.getPaidTo();
			String amountPaid = e.getAmountDollars() + "." + String.format("%02d", e.getAmountCents());
			String category = e.getCategory();
			
			if(e.getType().equals("in-full"))
			{
				System.out.println(String.format("%1$2tm/%<2td/%<tY ", date) + String.format("%-15.15s %10s [%s]", paidTo, amountPaid, category));
			}
			else
			{
				String amountRemaining = ((partialExpense) e).getRemainingDollars() + "." + String.format("%02d", ((partialExpense) e).getRemainingCents());
				System.out.println(String.format("%1$2tm/%<2td/%<tY ", date) + String.format("%-15.15s %10s (%s) [%s]",
						paidTo, amountPaid, amountRemaining, category));
			}
		}
		
		System.out.println("");
	}

	private static void addExpense(Scanner s) 
	{
		String type;
		String d;
		Date date;
		String amountPaid;
		String paidTo;
		String category;
		String amountRemaining;
		int amountDollars;
		int amountCents;
		int amountRemainingDollars;
		int amountRemainingCents;

		
		System.out.print("Expense type (in-full, partial)? ");
		type = s.next();
		
		System.out.print("Payment date: ");
		d = s.next();
		date = convertDate(d);
		
		System.out.print("Expense Amount: ");
		amountPaid = s.next();
		amountDollars = convertAmountDollars(amountPaid);
		amountCents = convertAmountCents(amountPaid);
		
		System.out.print("Who was this expense paid to? ");
		paidTo = s.next();
		
		System.out.print("Expense category: ");
		category = s.next();
		
		if(type.equals("partial"))
		{
			System.out.print("Expense Balance: ");
			amountRemaining = s.next();
			amountRemainingDollars = convertPartialAmountDollars(amountRemaining);
			amountRemainingCents = convertPartialAmountCents(amountRemaining);
			
			expense e = new partialExpense(type, date, category, paidTo, amountDollars, amountCents, amountRemainingDollars, amountRemainingCents);
			expenses.add(e);
		}
		else
		{
			expense e = new inFullExpense(type, date, category, paidTo, amountDollars, amountCents);
			expenses.add(e);
		}
		
		System.out.println("");
		
		userChoice(s);
	}
	
	private static Date convertDate(String d)
	{
		Date date = null;
		
		DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
		try 
		{
			date = df.parse(d);
		} 
		catch (ParseException e) 
		{
			System.out.println("Invalid date.");
		}
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		
		return date;
	}
	
	private static int convertAmountDollars(String s)
	{
		int decimalIndex;
		
		decimalIndex = s.indexOf('.');
		
		Integer i;
		
		i = new Integer(s.substring(0, decimalIndex));
		return i.intValue();
	}
	
	private static int convertAmountCents(String s)
	{
		int decimalIndex;
		
		decimalIndex = s.indexOf('.');
		
		Integer i;

		i = new Integer(s.substring(decimalIndex + 1, decimalIndex + 3));
		return i.intValue();
	}

	private static int convertPartialAmountDollars(String s)
	{
		int decimalIndex;
		
		decimalIndex = s.indexOf('.');
		
		Integer i;
		
		i = new Integer(s.substring(0, decimalIndex));
		return i.intValue();	
	}
	
	private static int convertPartialAmountCents(String s)
	{
		int decimalIndex;
		
		decimalIndex = s.indexOf('.');
		
		Integer i;
		
		i = new Integer(s.substring(decimalIndex + 1, decimalIndex + 3));
		return i.intValue();
	}

	private static void sort(Scanner s)
	{
		keys = 0;
		
		try 
		{
			sortKeyIdentifier(s);
		}
		catch (InvalidKeyException e)
		{
			System.out.println("");
			System.out.println("Invalid sort key.");
			System.out.println("");
			return;
		}

		if(keys == 1)
		{
			Collections.sort(expenses, comp1);
		}
		else
		{
			delegationAssignment();
		}
		
		System.out.println("");
	}

	private static void sortKeyIdentifier(Scanner s) throws InvalidKeyException
	{
		String key;
		
		System.out.print("Keys to sort by: ");

		s.nextLine();
		String keyInput = s.nextLine();
		String[] inputs = keyInput.split(" ");
		
		key = inputs[0];
		try
		{
			comparatorAssignment(key, 1);
		}
		catch(InvalidKeyException e)
		{
			throw new InvalidKeyException();
		}
		keys++;
		
		for(int i = 1; i < inputs.length; i++)
		{
			try
			{
				for(int j = i - 1; j >= 0; j--)
				{
					if(inputs[i].equals(inputs[j]))
					{
						throw new InvalidKeyException();
					}
				}
				
				key = inputs[i];
				keys++;
				try
				{
					comparatorAssignment(key, keys);
				}
				catch (InvalidKeyException e)
				{
					throw new InvalidKeyException();
				}
			}
			catch(InvalidKeyException e)
			{
				
			}
		}
	}
	
	private static void delegationAssignment() 
	{
		Comparator<expense> delegateComparator;
		
		if(keys == 2)
		{
			delegateComparator = new ExpenseDelegateComparator<expense>(comp1, comp2);
			Collections.sort(expenses, delegateComparator);
		}
		else
		{
			keys--;
			
			delegateComparator = new ExpenseDelegateComparator<expense>(comp2, comp3);
			comp2 = delegateComparator;
			comp3 = comp4;
			comp4 = null;
			delegationAssignment();
		}
	}

	private static void comparatorAssignment(String key, int keyNumber) throws InvalidKeyException
	{
		Comparator<expense> amountComp = new ExpenseAmountComparator();
		Comparator<expense> catComp = new ExpenseCategoryComparator();
		Comparator<expense> dateComp = new ExpenseDateComparator();
		Comparator<expense> payeeComp = new ExpensePayeeComparator();
		
		if(keyNumber == 1)
		{		
			if(key.equals("amount"))
			{
				comp1 = amountComp;
			}
			else if(key.equals("category"))
			{
				comp1 = catComp;
			}
			else if(key.equals("date"))
			{
				comp1 = dateComp;
			}
			else if(key.equals("payee"))
			{
				comp1 = payeeComp;
			}
			else
			{
				throw new InvalidKeyException();
			}
		}
		else if(keyNumber == 2)
		{		
			if(key.equals("amount"))
			{
				comp2 = amountComp;
			}
			else if(key.equals("category"))
			{
				comp2 = catComp;
			}
			else if(key.equals("date"))
			{
				comp2 = dateComp;
			}
			else if(key.equals("payee"))
			{
				comp2 = payeeComp;
			}
			else
			{
				throw new InvalidKeyException();
			}
		}
		else if(keyNumber == 3)
		{		
			if(key.equals("amount"))
			{
				comp3 = amountComp;
			}
			else if(key.equals("category"))
			{
				comp3 = catComp;
			}
			else if(key.equals("date"))
			{
				comp3 = dateComp;
			}
			else if(key.equals("payee"))
			{
				comp3 = payeeComp;
			}
			else
			{
				throw new InvalidKeyException();
			}
		}
		else if(keyNumber == 4)
		{		
			if(key.equals("amount"))
			{
				comp4 = amountComp;
			}
			else if(key.equals("category"))
			{
				comp4 = catComp;
			}
			else if(key.equals("date"))
			{
				comp4 = dateComp;
			}
			else if(key.equals("payee"))
			{
				comp4 = payeeComp;
			}
			else
			{
				throw new InvalidKeyException();
			}
		}
		else
		{
			System.out.println("you goofed");
		}
	}
	
	private static void save(Scanner s) 
	{
		PrintWriter p = null;
		
		try 
		{
			p = new PrintWriter(infile);
		} 
		catch (FileNotFoundException e) 
		{

		}
		
		for(int i = 0; i < expenses.size(); i++)
		{
			expense e = expenses.get(i);
			String type = e.getType();
			Date d = e.getDate();
			String date = String.format("%1$2tm/%<2td/%<tY", d);
			String category = e.getCategory();
			String paidTo = e.getPaidTo();
			String amountPaid = e.getAmountDollars() + "." + e.getAmountCents();
			
			p.println(type);
			p.println(date);
			p.println(category);
			p.println(paidTo);
			p.println(amountPaid);
			
			if(type.equals("partial"))
			{
				String amountRemaining = ((partialExpense) e).getRemainingDollars() + "." + ((partialExpense) e).getRemainingCents();
				p.println(amountRemaining);
			}
			
			p.println("");
		}
		
		p.close();
		
		System.out.println("");
	}
}
