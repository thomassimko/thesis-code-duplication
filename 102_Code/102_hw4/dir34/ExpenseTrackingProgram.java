import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Comparator;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;


public class ExpenseTrackingProgram {
	private static Scanner scan;
	
	public static <T> void main(String [] args)
	{
		List<Expenses> list;
		
		File input = new File("StoredExpenses.txt");
		list = importFile(input);
		
		scan = new Scanner(System.in);

		while (true)
		{    
			openingDisplay();
			String choice = scan.next();
			System.out.println("");
			
			//ADD EXPENSE
			if(choice.equals("2"))
			{
				try
				{
					Expenses e = addExpense(scan);
					list.add(0, e);
					System.out.println();
				}
				catch(InputMismatchException x)
				{
					scan.nextLine();
					System.out.println();
				}
			}
			//DISPLAY
			if(choice.equals("1"))
			{
				printList(list);
				System.out.println();
			}
			
			//SORT
			if(choice.equals("3"))
			{
				try
				{
					System.out.print("Keys to sort by: ");
					scan.nextLine();
					String key = scan.nextLine(); //split
					String[] r = key.split(" ");
					Comparator comp = findComparator(r);
					System.out.println();
				
					if(comp == null)
					{
						//printList(list);
						System.out.println();
					}
					else
					{
						ExpenseSort es = new ExpenseSort();
						list = es.sort(list,comp);
						//printList(list);
						System.out.println();

					}
				}
				catch(InputMismatchException e)
				{
					System.out.println();
				}
				
			}
			//SAVE
			if(choice.equals("4"))
			{
				save(list, input);
				System.out.println("List Saved!");
				System.out.println();
			}
			//QUIT
			if(choice.equals("5"))
			{
				System.out.println("GoodBye!");
				System.exit(0);
			}
		}
	}
	
	private static Comparator findComparator(String[] r)
	{
		int size = r.length;
		Comparator z = strToComp(r[size - 1]);
		if(z==(null))
		{
			return null;
		}
		for(int i = size-2; i>=0; i--)
		{
			z = new ExpenseDelegateComparator(strToComp(r[i]), z);
		}		
		return z;	
	}
	private static Comparator strToComp(String n)
	{
		if(n.equals("date"))
		{
			return new ExpenseDateComparator();
		}
		else if(n.equals("payee"))
		{
			return new ExpensePayeeComparator();
		}
		else if(n.equals("category"))
		{
			return new ExpenseCategoryComparator();
		}
		else if(n.equals("amount"))
		{
			return new ExpenseAmountComparator();
		}
		throw new InputMismatchException();
	}

	public static void openingDisplay()
	{
		//System.out.println();
		System.out.println("1. Display");
		System.out.println("2. Add Expense");
		System.out.println("3. Sort");
		System.out.println("4. Save");
		System.out.println("5. Quit");
		System.out.println();
		System.out.print("Enter choice: ");
	}
	public static void printList(List<Expenses> list)
	{
		int size = list.size();
		for(int i = 0; i< size; i ++)
		{
			Expenses p = list.get(i);
			p.print();
		}
	}
	public static void save(List <Expenses> list, File input)
	{
		int size = list.size();
		PrintWriter p = null;
		try
		{
			p = new PrintWriter(input);
		}
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}
		for(int i=0; i<size; i++)
		{
			p.println(list.get(i).getType());
			Calendar c = list.get(i).getDate();
			Date d = c.getTime();
			p.println(String.format("%1$2tm/%<2td/%<tY ", d));
			p.println(list.get(i).getPayee());
			p.println(list.get(i).getCategory());
			p.println(list.get(i).getAmountPaid());
			p.println(list.get(i).getBalance());	
		}
		p.close();
	}
	public static Expenses addExpense(Scanner scan)
	{
		int cents = 0, dollars2 = 0, cents2 = 0, dollars = 0;
		BigDecimal dollarsTemp, amount = null , centsTemp;
		String paidTo = null, expCategory = null, expType=null, date=null;
		Expenses e1 = null;

		System.out.print("Expense type (in-full, partial)? ");
		scan.nextLine();
		expType = scan.nextLine();

		System.out.print("Payment date: ");
		date = scan.next();

		Calendar d1 = formatDate(date);

		System.out.print("Expense Amount: ");	
		amount = scan.nextBigDecimal();


		dollars = amount.intValue();
		dollarsTemp = new BigDecimal(dollars);
		centsTemp = amount.subtract(dollarsTemp);
		centsTemp = centsTemp.movePointRight(2);
		cents = centsTemp.intValue();

		System.out.print("Who was this expense paid to? ");
		scan.nextLine();
    	paidTo = scan.nextLine();

		System.out.print("Expense category: ");
	//	scan.nextLine();
		expCategory = scan.nextLine();

		if(expType.equals("in-full"))
		{
			cents2= 0;
			dollars2 = 0;
			e1 = new InFull(d1, dollars, cents , paidTo, expCategory, dollars2, cents2);
		}
		else if(expType.equals("partial"))
		{
			BigDecimal amount2, dollarsTemp2, cents2Temp;
			
			System.out.print("Expense Balance: ");
			
			amount2 = scan.nextBigDecimal();
			dollars2 = amount2.intValue();
			dollarsTemp2 = new BigDecimal(dollars2);
			cents2Temp = amount2.subtract(dollarsTemp2);
			cents2Temp = cents2Temp.movePointRight(2);
			cents2 = cents2Temp.intValue();
			scan.nextLine();
			e1 = new Partial(d1, dollars, cents, paidTo, expCategory, dollars2, cents2);
		}
		else
		{
			throw new InputMismatchException();
		}
	//	scan.nextLine();
		return e1;
	}
	public static Calendar formatDate(String date)
	{
		DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
		Date d1 = null;
		Calendar c =null;
		
		try
		{
			d1 = df.parse(date);
			c= GregorianCalendar.getInstance();
			c.setTime(d1);
		} 
		catch (ParseException e)
		{
			System.out.print("Payment date: ");
			String date2 = scan.next();
			formatDate(date2);
		}
		return c;
	}
	
	public static List importFile(File input)
	{
		int dollars, cents, dollars2, cents2;
		BigDecimal amount, dollarsTemp, amount2, dollarsTemp2, cents2Temp;
		
		List<Expenses> list = new LinkedList<Expenses>();

		Scanner s;
		try {
			s = new Scanner(input);
			while(s.hasNextLine())
			{
				String type = s.nextLine();
				if(type.equals("partial"))
				{
					try
					{
						String date = s.nextLine();
						//Calendar d1 = formatDate(date);
						DateFormat c = new SimpleDateFormat("MM/dd/yyyy");
						Date d = null;
						Calendar d1 =null;

						d = c.parse(date);
						d1= GregorianCalendar.getInstance();
						d1.setTime(d);
										
						String paidTo = s.nextLine();
						String category = s.nextLine();
						
						amount = s.nextBigDecimal();
						dollars = amount.intValue();
						dollarsTemp = new BigDecimal(dollars);
						BigDecimal centsTemp = amount.subtract(dollarsTemp);
						centsTemp = centsTemp.movePointRight(2);
						cents = centsTemp.intValue();
					
						s.nextLine();

						amount2 = s.nextBigDecimal();
						dollars2 = amount2.intValue();
						dollarsTemp2 = new BigDecimal(dollars2);
						cents2Temp = amount2.subtract(dollarsTemp2);
						cents2Temp = cents2Temp.movePointRight(2);
						cents2 = cents2Temp.intValue();

						s.nextLine();
					
						list.add(new Partial(d1, dollars, cents, paidTo, category, dollars2, cents2));
					}
					catch(ParseException e)
					{
						System.out.println("Expense not loaded");	
					}
				}
				if(type.equals("in-full"))
				{
					try
					{
						String date = s.nextLine();
					
						//Calendar d1 = formatDate(date);
						
						DateFormat c = new SimpleDateFormat("MM/dd/yyyy");
						Date d = null;
						Calendar d1 =null;

						d = c.parse(date);
						d1= GregorianCalendar.getInstance();
						d1.setTime(d);
					
						String paidTo = s.nextLine();
						String category = s.nextLine();
															
						amount = s.nextBigDecimal();
						dollars = amount.intValue();
						dollarsTemp = new BigDecimal(dollars);
						BigDecimal centsTemp = amount.subtract(dollarsTemp);
						centsTemp = centsTemp.movePointRight(2);
						cents = centsTemp.intValue();
					
						s.nextLine();
						
						amount2 = s.nextBigDecimal();
						dollars2 = amount2.intValue();
						dollarsTemp2 = new BigDecimal(dollars2);
						cents2Temp = amount2.subtract(dollarsTemp2);
						cents2Temp = cents2Temp.movePointRight(2);
						cents2 = cents2Temp.intValue();
					
						s.nextLine();
					
						list.add(new InFull(d1, dollars, cents, paidTo, category, dollars2, cents2));
					}
					catch(ParseException e)
					{
						System.out.println("Expense not loaded");	
					}
				}
			}		
		}
		catch (FileNotFoundException e1)
		{
		}
		System.out.println("File Loaded");
		System.out.println();
		return list;
	}
}
