import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.Collections;

public class Assignment4 {
	
	public static void main(String[] args) {
		List<Payment> pays = new ArrayList<Payment>();
		File f = new File("StoredExpenses");
		Scanner in = new Scanner(System.in);
		try {
			Scanner s = new Scanner(f);
			if (s.hasNextLine()) {
				Payment p = loadnext(s);
				while (p != null) {
					pays.add(p);
					//System.out.println(1);
					p = loadnext(s);
				}
			}
			s.close();
		} catch (FileNotFoundException e) {
			//e.printStackTrace();
			try {
				f.createNewFile();
			} catch (IOException e1) {
				e1.printStackTrace();
				System.out.println("failed to make new file");
				System.exit(1);
			}
		}
		menu(pays,f,in);
	}
	public  static Payment loadnext(Scanner s)
	{
		try{
			if (!s.hasNextLine())
			{
				return null;
			}
			String line = s.nextLine();
			if (line.trim().compareTo("") == 0)
			{
				return null;
			}
			if (line.compareTo("in-full")==0||line.compareTo("partial")==0)
			{
				String type = line;
				
				DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
				Date d = df.parse(s.nextLine());
				Calendar day =  Calendar.getInstance();
				day.setTime(d);
				
				String catagory = s.nextLine();
				
				String payee = s.nextLine();
				
				String amount = s.nextLine();

				String ramount = s.nextLine();
				
				int loc = amount.indexOf('.');
				Integer payed[] = {Integer.parseInt(amount.substring(0, loc)),Integer.parseInt(amount.substring(loc+1))};
				loc = ramount.indexOf('.');
				Integer rpayed[] = {Integer.parseInt(ramount.substring(0, loc)),Integer.parseInt(ramount.substring(loc+1))};
				
				
				if(type.compareTo("in-full")==0)
				{
					return new InFull(day, payed, payee, catagory);
				}
				else if(type.compareTo("partial")==0)
				{
					return new Partial(day, payee, payed, rpayed, catagory);
				}
			}
			System.out.println("payment type not recognised, continuing with partial load");
			return null;
			}
		catch(Exception e)
		{
			e.printStackTrace();
			System.out.println("file incorectly formated, proceding with partial load");
			return null;
		}
	}
	public static void menu(List<Payment> pays, File f,Scanner in)
	{
		try {
			System.out.println("File loaded");
			System.out.println();
			int current = select(in);
			while (current != 5)
			{
				if(current == 1)
				{
					System.out.println();
					for(Payment p:pays)
					{
						p.display();
					}
					System.out.println();
				}
				else  if (current == 2)
				{
					System.out.print("Expence type (in-full, partial)? ");
					in.hasNextLine();
					String type = in.nextLine();
					if (type.compareTo("in-full")==0)
					{
						try {
							System.out.print("Payment date: ");
							in.hasNextLine();
							String date = in.nextLine();
							
							DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
							Date d;
								
							d = df.parse(date);
							Calendar day =  Calendar.getInstance();
							day.setTime(d);
							
							System.out.print("Expense Amount: ");
							in.hasNextLine();
							String amount = in.nextLine();
							
							int loc = amount.indexOf('.');
							Integer payed[] = {Integer.parseInt(amount.substring(0, loc)),Integer.parseInt(amount.substring(loc+1))};
						
							System.out.print("Who was the expense paid to? ");
							in.hasNextLine();
							String payee = in.nextLine();
							System.out.print("Expense category: ");
							in.hasNextLine();
							String catagory = in.nextLine();
						
							
							
							
							//Integer payed[] = {Integer.parseInt(amount.split(".")[0]),Integer.parseInt(amount.split(".")[1])};
							
							pays.add(new InFull(day, payed, payee, catagory));
						} catch (ParseException e) {
							System.out.println("Payment date in form of MM/dd/yyyy");
						} catch (Exception e)
						{
							System.out.println("Incorect representation of Curency unit (#.# ie: 5.3 or 32.05)");
						}
					}
					else if (type.compareTo("partial")== 0)
					{
						try {
							System.out.print("Payment date: ");
							in.hasNextLine();
							String date = in.nextLine();
							
							DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
							Date d;
							d = df.parse(date);
							Calendar day =  Calendar.getInstance();
							day.setTime(d);
							
							System.out.print("Expense Amount: ");
							in.hasNextLine();
							String amount = in.nextLine();
							
							int loc = amount.indexOf('.');
							Integer payed[] = {Integer.parseInt(amount.substring(0, loc)),Integer.parseInt(amount.substring(loc+1))};
							
							System.out.print("Who was the expense paid to? ");
							in.hasNextLine();
							String payee = in.nextLine();
							System.out.print("Expense category: ");
							in.hasNextLine();
							String catagory = in.nextLine();
							System.out.print("Expense Balance: ");
							in.hasNextLine();
							String ramount = in.nextLine();
							
							loc = ramount.indexOf('.');
							Integer rpayed[] = {Integer.parseInt(ramount.substring(0, loc)),Integer.parseInt(ramount.substring(loc+1))};
						
							/*DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
							Date d;
							d = df.parse(date);
							Calendar day =  Calendar.getInstance();
							day.setTime(d);*/

							/*Integer payed[] = {Integer.parseInt(amount.split(".")[0]),Integer.parseInt(amount.split(".")[1])};
							Integer rpayed[] = {Integer.parseInt(ramount.split(".")[0]),Integer.parseInt(ramount.split(".")[1])};*/
							
							pays.add(new Partial(day,payee,payed,rpayed,catagory));
						} catch (ParseException e) {
							System.out.println("Payment date in form of MM/dd/yyyy");
						} catch (Exception e)
						{
							System.out.println("Incorect representation of Curency unit (#.# ie: 5.3 or 32.05)");
						}
					}
					else
					{
						System.out.println("Unknown payment type");
					}
					System.out.println();
				}
				else if (current == 3)
				{
					System.out.print("Keys to sort by: ");
					in.hasNextLine();
					String keys = in.nextLine();
					pays = sortwithkeys(pays,keys);
					System.out.println();
				}
				else if (current == 4)
				{
					int size = pays.size();
					PrintWriter out;
					try {
						out = new PrintWriter(f);
						for(int i = 0; i<size;i++)
						{
							pays.get(i).save(out);
						}
						out.close();
					} catch (FileNotFoundException e) {
						e.printStackTrace();
						System.out.println("canot write to file");
					}
					System.out.println();
				}
				else if (current != 5)
				{
					System.out.println("invalid input,  try again");
					System.out.println();
				}
				current = select(in);
			}
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			in.close();
		}
	}
	private static List<Payment> sortwithkeys(List<Payment> pays, String keys) {
		String KeyArr[] = keys.split(" ");
		Comparator<Payment> comp = null;
		if(keys.trim().isEmpty())
		{
			System.out.println("Invalid keys (date, catagory,amount,payee)");
			return pays;
		}
		for (int i = KeyArr.length-1;i>=0;i = i-1)
		{
			if(KeyArr[i].compareTo("date")==0)
			{
				comp = new ExpenseDelegateComparator(new ExpenseDateComparator(),comp);
			}
			else if(KeyArr[i].compareTo("catagory")==0)
			{
				comp = new ExpenseDelegateComparator(new ExpenseCategoryComparator(),comp);
			}
			else if(KeyArr[i].compareTo("amount")==0)
			{
				comp = new ExpenseDelegateComparator(new ExpenseAmountComparator(),comp);
			}
			else if(KeyArr[i].compareTo("payee")==0)
			{
				comp = new ExpenseDelegateComparator(new ExpensePayeeComparator(),comp);
			}
			else
			{
				System.out.println("Invalid keys (date, catagory,amount,payee)");
				return pays;
			}
		}
		Collections.sort(pays, comp);
		return pays;
	}
	public static int select(Scanner in)
	{
		System.out.println("1. Display");
		System.out.println("2. Add Expense");
		System.out.println("3. Sort");
		System.out.println("4. Save");
		System.out.println("5. Quit");
		System.out.println();
		System.out.print("Enter choice: ");
		try{
			int choice = in.nextInt();
			in.nextLine();
			return choice;
		}
		catch(Exception e){
			in.nextLine();
			return 6;
		}
	}
}

