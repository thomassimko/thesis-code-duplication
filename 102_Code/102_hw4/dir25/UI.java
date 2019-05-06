import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
public class UI {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		List<Expenses> list = new ArrayList<Expenses>();
		Scanner scanner = new Scanner(System.in);
		int choice = 0;
		
		boolean loaded = loadFile(list);
		if ( loaded == true)
		{
			System.out.println("File Loaded");
		}
		else
		{
			System.err.println("File wasn't loaded, something is wrong");
		}
		try
		{
			while ( choice != 5)
			{
				System.out.println("");
				System.out.println("1. Display");
				System.out.println("2. Add Expense");
				System.out.println("3. Sort");
				System.out.println("4. Save");
				System.out.println("5. Quit");
				System.out.println("");
				System.out.print("Enter Choice: ");
				choice = scanner.nextInt();
				System.out.println("");
				
				if ( choice == 1)
				{
					display(list);
				}
				
				if ( choice == 2)
				{
					addExpense(list);
				}
				
				if ( choice == 3)
				{
					sort(list);
				}
				
				if ( choice == 4)
				{
					save(list);
				}
				
				if ( choice == 5)
				{
					scanner.close();
					System.exit(0);
				}
			}
		}
		catch (InputMismatchException e)
		{
			System.err.println("Input mismatch");
			choice = 0;
		}
	}
	
	public static boolean loadFile(List<Expenses> list)
	{
		try
		{
 			File input = new File("StoredExpenses.txt");
			Scanner scanner = new Scanner(input);
			Expenses expense = new infull();
			while (scanner.hasNextLine())
			{

					String type = scanner.nextLine();
					if (type.equals("in-full"))
					{
						expense = new infull();
					}
					else if ( type.equals("partial"))
					{
						expense = new partial();
					}
					String line = scanner.nextLine();
					DateFormat format = new SimpleDateFormat("MM/dd/yyyy");
					Date date = format.parse(line);
					expense.setDate(date);
					expense.setCategory(scanner.nextLine());
					expense.setPayee(scanner.nextLine());
					String temp = scanner.nextLine();
					Money amount = new Money(Integer.parseInt(temp.split("\\.")[0]), Integer.parseInt(temp.split("\\.")[1]));
					expense.setAmount(amount);
					String temp2 = scanner.nextLine();
					Money remaining = new Money(Integer.parseInt(temp2.split("\\.")[0]), Integer.parseInt(temp2.split("\\.")[1]));
					expense.setRemaining(remaining);
					list.add(expense);
	
					
			}
			return true;
		}
		catch ( FileNotFoundException e)
		{
			return false;
		}
		catch ( ParseException e)
		{
			return false;
		}
		catch ( NumberFormatException e)
		{
			return false;
		}
	}
	
	public static void display(List<Expenses> list)
	{
		for ( int i = 0; i < list.size(); i++)
		{
			System.out.println(list.get(i).getExpense());
		}
	}
	
	public static void addExpense(List<Expenses> list)
	{
		try
		{
			Scanner scanner = new Scanner(System.in);
			System.out.print("Expense type (in-full, partial)? ");
			String type = scanner.nextLine();
			if ( type.equals("in-full"))
			{
				infull add = new infull();
				System.out.print("Payment date: ");
				String line = scanner.nextLine();
				DateFormat format = new SimpleDateFormat("MM/dd/yyyy");
				Date date = format.parse(line);
				add.setDate(date);
				System.out.print("Expense Amount: ");
				String temp = scanner.nextLine();
				Money amount = new Money(Integer.parseInt(temp.split("\\.")[0]), Integer.parseInt(temp.split("\\.")[1]));
				add.setAmount(amount);
				System.out.print("Who was this expense paid to? ");
				add.setPayee(scanner.nextLine());
				System.out.print("Expense category: ");
				add.setCategory(scanner.nextLine());
				Money remaining = new Money(0, 00);
				add.setRemaining(remaining);
				list.add(0, add);
			}
			else if ( type.equals("partial"))
			{
				partial add = new partial();
				System.out.print("Payment date: ");
				String line = scanner.nextLine();
				DateFormat format = new SimpleDateFormat("MM/dd/yyyy");
				Date date = format.parse(line);
				add.setDate(date);
				System.out.print("Expense Amount: ");
				String temp = scanner.nextLine();
				Money amount = new Money(Integer.parseInt(temp.split("\\.")[0]), Integer.parseInt(temp.split("\\.")[1]));
				add.setAmount(amount);
				System.out.print("Who was this epxense paid to? ");
				add.setPayee(scanner.nextLine());
				System.out.print("Expense category: ");
				add.setCategory(scanner.nextLine());
				System.out.print("Expense Balance: ");
				temp = scanner.nextLine();
				Money remaining = new Money(Integer.parseInt(temp.split("\\.")[0]), Integer.parseInt(temp.split("\\.")[1]));
				add.setRemaining(remaining);
				list.add(0, add);
			}
		}
		catch ( ParseException e)
		{
			System.err.println("Something went terribly wrong, the world will explodeeeeeeeeeeeeeeeee");
		}
	}
	public static void save(List<Expenses> list)
	{
		try
		{
			File file = new File("StoredExpenses.txt");
			PrintWriter out = new PrintWriter(file);
			DateFormat format = new SimpleDateFormat("MM/dd/yyyy");
			for ( int i = 0 ; i < list.size(); i++)
			{
				out.println(list.get(i).getType());
				Date date = list.get(i).getDate();
				out.println(format.format(date));
				out.println(list.get(i).getCategory());
				out.println(list.get(i).getPayee());
				out.println(list.get(i).getAmount().getMoney());
				out.println(list.get(i).getRemaining().getMoney());
			}
			out.close();
		}
		catch ( FileNotFoundException e)
		{
			System.err.println("zzsdfsdfffffffffff can't find file");
		}
	}
	public static void sort(List<Expenses> list)
	{
		Scanner scanner = new Scanner(System.in);
		System.out.print("Keys to sort by: ");
		String line = scanner.nextLine();
		String[] temp;
		temp = line.split(" ");  
		List<String> param = new ArrayList<String>();
		for ( int i = 0 ; i < temp.length; i++)
		{
			param.add(temp[i]);
		}
		

		
		Collections.sort(list, recursiveHelper(param));
	
	}
	
	public static Comparator<Expenses> recursiveHelper(List<String> list)
	{
		String temp = list.get(0);
		if ( list.size() <= 1 )
		{
			if (temp.equals("amount"))
			{
				return new ExpenseAmountComparator();
			}
			else if ( temp.equals("category"))
			{
				return new ExpenseCategoryComparator();
			}
			else if ( temp.equals("payee"))
			{
				return new ExpensePayeeComparator();
			}
			else if  ( temp.equals("date"))
			{
				return new ExpenseDateComparator();
			}
		}
		else
		{
			list.remove(0);
			if (temp.equals("amount"))
			{
				return new ExpenseAmountDelegateComparator(recursiveHelper(list));
			}
			else if ( temp.equals("category"))
			{
				return new ExpenseCategoryDelegateComparator(recursiveHelper(list));
			}
			else if ( temp.equals("payee"))
			{
				return new ExpensePayeeDelegateComparator(recursiveHelper(list));
			}
			else if  ( temp.equals("date"))
			{
				return new ExpenseDateDelegateComparator(recursiveHelper(list));
			}
		}
		throw new IndexOutOfBoundsException();
	}
}
