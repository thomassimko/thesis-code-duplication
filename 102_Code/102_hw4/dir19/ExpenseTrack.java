import java.io.FileNotFoundException;
import java.io.File;
import java.text.ParseException;
import java.util.Date;
import java.util.Calendar;
import java.text.SimpleDateFormat;
import java.text.DateFormat;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Collections;
import java.lang.NumberFormatException;
import java.util.InputMismatchException;


public class ExpenseTrack
{
	@SuppressWarnings("unchecked")
	public static void main(String [] args)
	{
		Calendar date;
		String category;
		String paidTo;
		String key;
		Money amount;
		Money remain;
		int choice;
		Scanner scan = new Scanner(System.in);
		ArrayList<Expense> list = new ArrayList<Expense>();
		boolean hasFile = false;
		boolean exit = false;
		boolean check = false;
		try
		{
			File input = new File("StoredExpenses");
			Scanner sc = new Scanner(input);
			while(sc.hasNext())
			{
				hasFile = true;
				String next = sc.next();
				if (next.equals("in-full"))
				{
					date = dateRead(sc.next());
					category = sc.next();
					paidTo = sc.next();
					amount = toMoney(sc.next());
					Infull exp = new Infull(date,amount,paidTo,category);
					list.add(exp);
				}
				else if (next.equals("partial"))
				{
					date = dateRead(sc.next());
					category = sc.next();
					paidTo = sc.next();
					amount = toMoney(sc.next());
					remain = toMoney(sc.next());
					Partial exp = new Partial(date,amount,paidTo,category,remain);
					list.add(exp);
				}
				else
				{
					check = true;
				}
			}
			if (check)
			{
				hasFile = false;
				System.out.println("Incorrect file format");
			}
			if (hasFile ==  true)
			{
				System.out.println("File Loaded");
				System.out.println("");
			}
		}
		catch (FileNotFoundException e)
		{
			System.err.println("No file exists");
		}
		catch (ParseException e)
		{
			System.err.println("Parse Exception");
		}
		catch (NumberFormatException e)
		{
			System.err.println("Not an amount");
		}
		try
		{
			while(true)
			{
				System.out.println("1. Display");
				System.out.println("2. Add Expense");
				System.out.println("3. Sort");
				System.out.println("4. Save");
				System.out.println("5. Quit");
				System.out.println("");
				System.out.print("Enter choice: ");

				choice = scan.nextInt();
				System.out.println("");
				switch (choice)
				{
					case 1:
						for (int i = 0; i < list.size(); i++)
						{
							System.out.println(list.get(i).print());
						}
						System.out.println("");
						break;
					case 2:
						try
						{
							addExp(list,scan);
							System.out.println("");
						}
						catch (NumberFormatException e)
						{
							System.err.println("Not a number");
						}
						catch (ParseException e)
						{
							System.err.println("Parse Exception");
						}
						break;
					case 3:
						list = sort(list,scan);	
						break;
					case 4:
						try
						{
							PrintWriter printer = new PrintWriter("StoredExpenses");
							for (int i = 0; i < list.size(); i++)
							{
								if (list.get(i).getBal().equals("0"))
								{
									printer.write("in-full" + "\n");
								}
								else
								{
									printer.write("partial" + "\n");
								}
								printer.write(String.format("%1$2tm/%<2td/%<tY ",list.get(i).getDate()) + "\n");
								printer.write(list.get(i).getDesc() + "\n");
								printer.write(list.get(i).paidTo() + "\n");
								printer.write(list.get(i).paidAmount() + "\n");
								printer.write(list.get(i).getBal() + "\n");
							}
							printer.close();
							System.out.println("Expenses Saved");
						}
						catch (FileNotFoundException e)
						{
							System.out.print("No file exists");
						}
						break;
					case 5:
						exit = true;
						break;
				}
				if (exit)
				{
					break;
				}
			}
		}
		catch (InputMismatchException e)
		{
			System.err.println("Not an option!");
		}
	}
	
	public static Calendar dateRead(String s)
		throws ParseException
	{
		DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
		Date d = df.parse(s);
		Calendar c = Calendar.getInstance();
		c.setTime(d);
		return c;
	}
	
	public static Money toMoney(String dollars)
		throws NumberFormatException
	{
		String [] money = dollars.split("\\.");
		int bills = Integer.parseInt(money[0]);
		int cents = Integer.parseInt(money[1]);
		return new Money(bills,cents);
	}
	
	public static void addExp(ArrayList<Expense> list, Scanner scan)
		throws ParseException
	{
		Calendar date;
		String category;
		String paidTo;
		Money amount;
		Money remain;
		boolean bob = true;

		while (bob == true)
		{
			System.out.print("Expense type (in-full, partial)? ");
			String type = scan.next();
			if (type.equals("in-full"))
			{
				System.out.print("Payment date: ");
				date = dateRead(scan.next());
				System.out.print("Expense Amount: ");
				amount = toMoney(scan.next());
				System.out.print("Who was this expense paid to? ");
				paidTo = scan.next();
				System.out.print("Expense category: ");
				category = scan.next();
				list.add(0,new Infull(date,amount,paidTo,category));
				bob = false;
			}
			else if (type.equals("partial"))
			{
				System.out.print("Payment date: ");
				date = dateRead(scan.next());
				System.out.print("Expense Amount: ");
				amount = toMoney(scan.next());
				System.out.print("Who was this expense paid to? ");
				paidTo = scan.next();
				System.out.print("Expense category: ");
				category = scan.next();
				System.out.print("Expense Balance: ");
				remain = toMoney(scan.next());
				list.add(0,new Partial(date,amount,paidTo,category,remain));
				bob = false;
			}
		}
	}

	public static ArrayList sort(ArrayList<Expense> list, Scanner scan)
	{				
		System.out.print("Keys to sort by: ");
		scan.nextLine();
		String key = scan.nextLine();
		System.out.println("");
		String [] words = key.split(" ");
		int size = words.length - 1;
		Comparator<Expense> comp = null;
		if (words[size].equals("date"))
		{
			comp = new ExpenseDateComparator();
		}
		else if (words[size].equals("amount"))
		{
			comp = new ExpenseAmountComparator();
		}
		else if (words[size].equals("payee"))
		{
			comp = new ExpensePayeeComparator();
		}
		else if (words[size].equals("category"))
		{
			comp = new ExpenseCategoryComparator();
		}
		for (int i = size - 1; i >= 0; i--)
		{
			if (words[i].equals("date"))
			{
				comp = new ExpenseDelegateComparator(new ExpenseDateComparator(),comp);
			}
			else if (words[i].equals("amount"))
			{
				comp = new ExpenseDelegateComparator(new ExpenseAmountComparator(),comp);
			}
			else if (words[i].equals("payee"))
			{
				comp = new ExpenseDelegateComparator(new ExpensePayeeComparator(),comp);
			}
			else if (words[i].equals("category"))
			{
				comp = new ExpenseDelegateComparator(new ExpenseCategoryComparator(),comp);
			}
		}
		Collections.sort(list,comp);
		return list;
	}
}

