import java.io.*;
import java.text.*;
import java.util.*;


public class Tracker
{
	static ArrayList<Expenses> list = new ArrayList<Expenses>();
	public static Calendar datemaker(Scanner scanner) throws ParseException
	{
		DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
		String date;
		date=scanner.nextLine();
		Date d = df.parse(date);
		Calendar c = Calendar.getInstance();
		c.setTime(d);
		return c;
	}
	public static void fileLoader() throws FileNotFoundException, ParseException
	{
		String category, payee, stramt, balamt;
		String type=null;
		int amtDollars, amtCents, balDollars, balCents;
		Scanner scanner = new Scanner(new File("StoredExpenses.txt"));
		while (scanner.hasNextLine())
		{
			type=scanner.nextLine();
			Calendar cal=null;
			try
			{
				cal=datemaker(scanner);
			}
			catch (ParseException e)
			{
				return;
			}
			
			category=scanner.nextLine();
			
			payee=scanner.nextLine();
			
			stramt=scanner.nextLine();
			String[] sc=stramt.split("[.]");
			amtDollars= Integer.parseInt(sc[0]);
			amtCents= Integer.parseInt(sc[1]);
			
			if (type.equals("Partial"))
			{
				balamt=scanner.nextLine();
				String[] sd=balamt.split("[.]");
				balDollars= Integer.parseInt(sd[0]);
				balCents= Integer.parseInt(sd[1]);
					
				list.add(new Partial(cal, amtDollars, amtCents, payee, category, balDollars, balCents));
			}
			
			else 
			{
				list.add(new InFull(cal, amtDollars, amtCents, payee, category));
			}
		}
	}
	public static void filesaver() throws FileNotFoundException
	{
		PrintWriter printer= new PrintWriter(new File("StoredExpenses.txt"));
		String type;
		for(int i=0;i<list.size();i++)
		{
			
			if((list.get(i) instanceof InFull))
			{
				type="InFull";
			}
			else
			{
				type="Partial";
			}
			
			printer.println(type);
			printer.println(String.format("%1$2tm/%<2td/%<tY ", list.get(i).getDate()));
			printer.println(list.get(i).getCategory());
			printer.println(list.get(i).getPayee());
			printer.println(list.get(i).getAmtString());
			if(type.equals("Partial"))
			{
				printer.println(list.get(i).getBalString());
			}
		}
		printer.close();

	}
	public static void display()
	{
		for(int j=0; j<list.size(); j++)
		{
			if ((list.get(j) instanceof InFull))
			{
				System.out.println(String.format("%1$2tm/%<2td/%<tY ", list.get(j).getDate()) 
					+ String.format("%-15.15s %10s [%s]", list.get(j).getPayee(), list.get(j).getAmtString(), list.get(j).getCategory()));
			}
			
			else
			{
				System.out.println(String.format("%1$2tm/%<2td/%<tY ", list.get(j).getDate())
						+ String.format("%-15.15s %10s (%s) [%s]",
								list.get(j).getPayee(), list.get(j).getAmtString(), list.get(j).getBalString(), list.get(j).getCategory()));
			}
		
		}
	}
	public static void addExpense() throws ParseException
	{
		Scanner input = new Scanner( System.in );
		String type, stramt, payee, category, balamt;
		int amtDollars, amtCents, balDollars, balCents;
		System.out.print("Expense type (In-Full, Partial)?");
		type=input.nextLine();
		
		System.out.print("Payment date: ");
		Calendar cal=null;
		try
		{
		cal=datemaker(input);
		}
		catch(ParseException e)
		{
			return;
		}
		System.out.print("Expense Amount: ");
		stramt=input.nextLine();
		String[] sa=stramt.split("[.]");
		amtDollars= Integer.parseInt(sa[0]);
		amtCents= Integer.parseInt(sa[1]);
			
		System.out.print("Who was this expense paid to? ");
		payee=input.nextLine();
			
		System.out.print("Expense category: ");
		category=input.nextLine();
			
		if (type.equals("Partial"))
		{
			System.out.print("Expense Balance: ");
			balamt=input.nextLine();
			String[] sb=balamt.split("[.]");
			balDollars= Integer.parseInt(sb[0]);
			balCents= Integer.parseInt(sb[1]);
				
			list.add(new Partial(cal, amtDollars, amtCents, payee, category, balDollars, balCents));
		}
		else 
		{
			list.add(new InFull(cal, amtDollars, amtCents, payee, category));
		}		
	}
	public static void sort()
	{
		String input, stype;
		Scanner scanner = new Scanner( System.in );
		System.out.print("Keys to sort by: ");
		input=scanner.nextLine();
		String[] sorts=input.split("\\s+");
		Comparator<Expenses> check=null;
		for(int i=sorts.length-1;i>=0;i--)
		{
			stype=sorts[i];
			if(stype.equals("date"))
			{
				if(check==null)
					check=new DateComparator();
				else
					check=new ExpenseDateDelegateComparator(check);
			}
			if(stype.equals("amount"))
			{
				if(check==null)
					check=new AmountComparator();
				else
					check=new ExpenseAmountDelegateComparator(check);
			}
			if(stype.equals("payee"))
			{
				if(check==null)
					check=new PayeeComparator();
				else
					check=new ExpensePayeeDelegateComparator(check);
			}
			if(stype.equals("category"))
			{
				if(check==null)
					check=new CategoryComparator();
				else
					check=new ExpenseCategoryDelegateComparator(check);
			}
			else
			{
				System.out.println("Keyword does not exist!");
				return;
			}
		}
		if(check != null)
			Collections.sort(list, check);
		else
			System.out.println("Error!");
		
	}
	public static void main(String args[]) throws ParseException, FileNotFoundException
	{
		Scanner input = new Scanner( System.in );
		int i=0;
		fileLoader();
		while (i != 5)
		{
			System.out.println("1. Display");
			System.out.println("2. Add Expense");
			System.out.println("3. Sort");
			System.out.println("4. Save");
			System.out.println("5. Quit");

			System.out.print("Enter choice: ");
			i = input.nextInt();

			if(i==1)
			{
				display();
			}

			if(i==2)
			{
				addExpense();
			}

			if(i==3)
			{
				sort();
			}
			
			if(i==4)
			{
				filesaver();
			}


		}
	}
}
