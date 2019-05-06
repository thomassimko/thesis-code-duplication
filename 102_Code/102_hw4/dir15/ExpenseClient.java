import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
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
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.PatternSyntaxException;


public class ExpenseClient 
{
	private static List<Expense> MasterList = new ArrayList<Expense>();
	private static Scanner userInput = new Scanner(System.in);
	
	public static void main(String args[])
	{
		fileLoader();
		clientBegin();
	}
	
	private static void fileLoader() 
	{
		try
		{
			Scanner fileScan = new Scanner(new File("StoredExpenses"));
			int i=0;
			List<String> dataStore = new ArrayList<String>();
			
			while(fileScan.hasNextLine())
			{
					String temp = fileScan.nextLine();
					dataStore.add(temp);
			}
			
			int size = dataStore.size();

			while(i<size)
			{
				if(dataStore.get(i).equals("in-full"))
				{
					String dateStrTmp = dataStore.get(i+1);
					Date dateTmp = addDate(dateStrTmp);
					String inFullCatTmp = dataStore.get(i+2);
					String payeeTmp = dataStore.get(i+3);
					String moneyStringTmp = dataStore.get(i+4);
					int dollarValTmp = convDollar(moneyStringTmp);
					int centValTmp = convCent(moneyStringTmp);
					
					MasterList.add(new inFull(dateStrTmp, dateTmp, dollarValTmp, centValTmp, payeeTmp, inFullCatTmp));
					
					i+=5;
				}
				else if(dataStore.get(i).equals("partial"))
				{
					String dateStrTmp = dataStore.get(i+1);
					Date dateTmp = addDate(dateStrTmp);
					String pCatTmp = dataStore.get(i+2);
					String payeeTmp = dataStore.get(i+3);
					String moneyStringTmp = dataStore.get(i+4);
					int dollarValTmp = convDollar(moneyStringTmp);
					int centValTmp = convCent(moneyStringTmp);
					String partialMoneyStrTmp = dataStore.get(i+5);
					int dollarBalTmp = convDollar(partialMoneyStrTmp);
					int centBalTmp = convCent(partialMoneyStrTmp);
					
					MasterList.add(new partial(dateStrTmp, dateTmp, dollarValTmp, centValTmp, payeeTmp, pCatTmp, dollarBalTmp, centBalTmp));
					
					i+=6;
				}
				else
				{
					System.err.println("Type error. Skipping rest of list.");
					clientBegin();
				}
			}
			System.out.println("File Loaded");
			
			
		}
		catch(FileNotFoundException e)
		{
			System.err.println("File not found, writing new file.");
		} 
		catch (ParseException e) 
		{
			System.err.println("Error parsing date. Skipping rest of list.");
			clientBegin();
		}
		catch(NumberFormatException e)
		{
			System.err.println("One or more digits in payment are invalid. Skipping rest of list.");
			clientBegin();	
		}
		catch(ArrayIndexOutOfBoundsException e)
		{
			System.err.println("One or more digits in payment are invalid. Skipping rest of list.");
			clientBegin();
		}
		catch(PatternSyntaxException e)
		{
			System.err.println("Parse error, please retype payment amount. Skipping rest of list.");
			clientBegin();
		}
	}

	public static void clientBegin()
	{
		System.out.println("");
		System.out.println("");
		System.out.println("1. Display");
		System.out.println("2. Add Expense");
		System.out.println("3. Sort");
		System.out.println("4. Save");
		System.out.println("5. Quit");
		System.out.println("");
		System.out.println("Enter choice: ");
		
		try
		{
			String numInput = userInput.nextLine();
			
			if(numInput.equals("1"))
			{
				display();
			}
			if(numInput.equals("2"))
			{
				expenseAdd();
			}
			if(numInput.equals("3"))
			{
				expenseSort();
			}
			if(numInput.equals("4"))
			{
				expenseSave();
			}
			if(numInput.equals("5"))
			{
				System.exit(1);
			}
			else
			{
				throw new InputMismatchException();
			}
		}
		catch(InputMismatchException e)
		{
			System.err.println("Please type a valid number between 1 and 5.");
			clientBegin();
		}
		
	}

	private static void expenseSort() 
	{
		List<String> getKeys = getKeys();
		
		Comparator<Expense> comp = null;
		
		int keySizeIndex = getKeys.size()-1;
		String getAtStart = getKeys.get(keySizeIndex);
		
		if(getAtStart.equals("amount"))
		{
			comp = new ExpenseAmountComparator();
		}
		else if(getAtStart.equals("category"))
		{
			comp = new ExpenseCategoryComparator();
		}
		else if(getAtStart.equals("date"))
		{
			comp = new ExpenseDateComparator();
		}
		else if(getAtStart.equals("payee"))
		{
			comp = new ExpensePayeeComparator();
		}
		else
		{
			System.err.println("Invalid key entry.");
			clientBegin();
		}
		
		for(int i = keySizeIndex-1; i>=0; i--)
		{
			String getAt = getKeys.get(i);
			
			if(getAt.equals("amount"))
			{
				comp = new ExpenseAmountDelegateComparator(comp);
			}
			else if(getAt.equals("category"))
			{
				comp = new ExpenseCategoryDelegateComparator(comp);
			}
			else if(getAt.equals("date"))
			{
				comp = new ExpenseDateDelegateComparator(comp);
			}
			else if(getAt.equals("payee"))
			{
				comp = new ExpensePayeeDelegateComparator(comp);
			}
			else
			{
				System.err.println("Invalid key entry.");
				clientBegin();
			}
		}
		Collections.sort(MasterList, comp);
		clientBegin();
	}

	private static List<String> getKeys() 
	{
		System.out.println("Keys to sort by: ");
		List<String> stringarr = new ArrayList<String>();
		
		String line = userInput.nextLine();
		
		Scanner lineScan = new Scanner(line);
		
		while(lineScan.hasNext())
		{
			stringarr.add(lineScan.next());
		}
		
		return stringarr;
	}

	private static void expenseSave() 
	{
		try 
		{
			PrintWriter out = new PrintWriter(new FileWriter("StoredExpenses"));
			
			for(Expense cur: MasterList)
			{
				out.println(cur.getType());
				out.println(cur.getStringDate());
				out.println(cur.getCat());
				out.println(cur.getPayee());
				out.println(cur.paidToString());
				if(cur instanceof partial)
				{
					out.println(cur.remainToString());
				}	
			}
			
			System.out.println("");
			System.out.println("Expenses saved");
			out.close();
			clientBegin();
		} 
		catch (IOException e) 
		{
			System.err.println("File StoredExpenses.txt not found.");
			clientBegin();
		}
	}

	private static void display() 
	{
		int size = MasterList.size();
		
		for(int i=0; i<size; i++)
		{
			System.out.println(displayHelper(MasterList.get(i)));
		}
		clientBegin();
		
	}

	private static String displayHelper(Expense expense) 
	{
		if(expense instanceof inFull)
		{
			return String.format("%1$2tm/%<2td/%<tY ", expense.getDate()) + String.format("%-15.15s %s [%s]", expense.getPayee(), expense.paidToString(), expense.getCat());
		}
		if(expense instanceof partial)
		{
			return String.format("%1$2tm/%<2td/%<tY ", expense.getDate()) + String.format("%-15.15s %s (%s) [%s]",
					expense.getPayee(), expense.paidToString(), expense.remainToString(), expense.getCat());
		}
		else
		{
			return null;
		}
		
	}

	private static void expenseAdd() 
	{
		System.out.println("Expense type (in-full, partial)?");
		
    	String expenseTypeInput = userInput.nextLine();
		System.out.println(expenseTypeInput);
			
		if(expenseTypeInput.equals("in-full"))
		{
			inFullAdd();
		}
		if(expenseTypeInput.equals("partial"))
		{
			partialAdd();
		}
		else
		{
			System.err.println("Please type either 'in-full' or 'partial'");
			expenseAdd();
		}
	}		

	private static void inFullAdd()
	{
		try
		{
			System.out.println("Payment date: ");
			String stringDate = userInput.nextLine();
			Date date = addDate(stringDate);
			
			System.out.println("Expense amount: ");
			String paid = userInput.nextLine();
			
			int dollar = convDollar(paid);
			
			int cent = convCent(paid);
			
			System.out.println("Who was this expense paid to? ");
			String payee = userInput.nextLine();
			
			System.out.println("Expense category: ");
			String cat = userInput.nextLine();
			
			MasterList.add(0, new inFull(stringDate, date, dollar, cent, payee, cat));
			
			clientBegin();
		}
		catch(ParseException e)
		{
			System.err.println("Error parsing date. Returning to start screen.");
			clientBegin();
		}
		catch(NumberFormatException e)
		{
			System.err.println("One or more digits in payment are invalid. Returning to start screen.");
			clientBegin();	
		}
		catch(ArrayIndexOutOfBoundsException e)
		{
			System.err.println("One or more digits in payment are invalid. Returning to start screen.");
			clientBegin();
		}
		catch(PatternSyntaxException e)
		{
			System.err.println("Parse error, please retype payment amount. Returning to start screen.");
			clientBegin();
		}
		
	}
	
	private static void partialAdd()
	{
		try
		{
			System.out.println("Payment date: ");
			String stringDate = userInput.nextLine();
			Date date = addDate(stringDate);
			
			System.out.println("Expense amount: ");
			String paid = userInput.nextLine();
			
			int dollar = convDollar(paid);
			
			int cent = convCent(paid);
			
			System.out.println("Who was this expense paid to? ");
			String payee = userInput.nextLine();
			
			System.out.println("Expense category: ");
			String cat = userInput.nextLine();
			
			System.out.println("Expense balance: ");
			String balance = userInput.nextLine();
			
			int dollarBal = convDollar(balance);
			
			int centBal = convCent(balance);
			
			MasterList.add(0, new partial(stringDate, date, dollar, cent, payee, cat, dollarBal, centBal));
			
			clientBegin();
		}
		catch(ParseException e)
		{
			System.err.println("Error parsing date. Returning to start screen.");
			clientBegin();
		}
		catch(NumberFormatException e)
		{
			System.err.println("One or more digits in payment are invalid. Returning to start screen.");
			clientBegin();
			
		}
		catch(ArrayIndexOutOfBoundsException e)
		{
			System.err.println("One or more digits in payment are invalid. Returning to start screen.");
			clientBegin();
		}
		catch(PatternSyntaxException e)
		{
			System.err.println("Parse error, please retype payment amount. Returning to start screen.");
			clientBegin();
		}
		
	}

	private static Date addDate(String stringDate) throws ParseException 
	{
		Date date;
		
		DateFormat df = new SimpleDateFormat("MM/dd/yyyy"); 
		Date d = df.parse(stringDate);
		Calendar c = Calendar.getInstance();
		c.setTime(d);
		date = d;
		return date;
	}
	
	private static int convDollar(String paid) 
	{	
		String priceArr[] = paid.split("\\.", 2);
		String dollars = priceArr[0];
		int dollar = Integer.parseInt(dollars);
		return dollar;
	}
	
	private static int convCent(String paid)
	{	
		String priceArr[] = paid.split("\\.", 2);
		String cents = priceArr[1];
		int cent = Integer.parseInt(cents);
		int fixCent = cent%100;
		return fixCent;
	}
}
