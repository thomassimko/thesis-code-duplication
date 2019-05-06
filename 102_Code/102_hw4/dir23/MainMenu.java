import java.util.*;
import java.io.*;
import java.text.*;
import java.lang.*;


public class MainMenu {
	public static void main(String[] args) throws ParseException, FileNotFoundException {
		List<Expense> expenses = new LinkedList<Expense>();
		File input = new File("StoredExpenses.txt");
		Scanner fileScanner = new Scanner(input);
		
		//reads expenses from .txt
		readFile(fileScanner, expenses);
		
		//start of regular program
		Scanner sc = new Scanner(System.in);
		int x = 0;
		printMenu();
		while(x != 1) {
			int i = sc.nextInt();
			int j = 0;
			sc.nextLine();
			int size = expenses.size();
			
			if(i == 1) {
				choiceOne(j, size, expenses);
			}
			if(i == 2) {
				choiceTwo(sc, expenses, fileScanner);
			}
			if(i == 3) {
				choiceThree(sc, i, expenses);
			}
			if(i == 4) {
				choiceFour(j, size, input, expenses);
			}
			if(i == 5) {
				sc.close();
				x = 1;
				System.out.println("Peace out homie.");
			}
		}
	}
	
	public static Comparator<Expense> recursiveSortHelper(List<String> sortList) {
		String temp = sortList.get(0);
		if(sortList.size() <= 1) {
			if(temp.equals("amount")) {
				return new ExpenseAmountComparator();
			}
			else if(temp.equals("category")) {
				return new ExpenseCategoryComparator();
			}
			else if(temp.equals("date")) {
				return new ExpenseDateComparator();
			}
			else if(temp.equals("payee")){
				return new ExpensePayeeComparator();
			}
			else {
				System.err.println("Invalid key. Please input valid key.");
				printMenu();
			}
		}
		else {
			sortList.remove(0);
			if(temp.equals("amount")) {
				return new ExpenseAmountDelegateComparator(recursiveSortHelper(sortList));
			}
			else if(temp.equals("category")) {
				return new ExpenseCategoryDelegateComparator(recursiveSortHelper(sortList));
			}
			else if(temp.equals("date")) {
				return new ExpenseDateDelegateComparator(recursiveSortHelper(sortList));
			}
			else if(temp.equals("payee")){
				return new ExpensePayeeDelegateComparator(recursiveSortHelper(sortList));
			}
			else {
				System.err.println("Invalid key. Please input valid key.");
				printMenu();
			}
		}
		throw new IndexOutOfBoundsException();
	}
	
	public static void printMenu() {
		System.out.println("1. Display");
		System.out.println("2. Add Expense");
		System.out.println("3. Sort");
		System.out.println("4. Save");
		System.out.println("5. Quit");
		System.out.println("");
		System.out.print("Enter Choice: ");
	}
	
	public static void readFile(Scanner fileScanner, List<Expense> expenses) {
		while(fileScanner.hasNextLine()) {
			String s = fileScanner.nextLine();
			if(s.equals("in-full")) {
				String date = fileScanner.nextLine(); /* string to be converted */
				try {
					DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
					Date d = df.parse(date);
					Calendar c = GregorianCalendar.getInstance();
					c.setTime(d);
					String category = fileScanner.nextLine();
					String payee = fileScanner.nextLine();
					String paid = fileScanner.nextLine();
					String[] paidSplit = paid.split("\\.");
					int paidDollars = Integer.parseInt(paidSplit[0]);
					int paidCents = Integer.parseInt(paidSplit[1]);
					InFull inFullExpense = new InFull(c, paidDollars, paidCents, payee, category);
					expenses.add(inFullExpense);
				}
				catch(ParseException e) {
					date = fileScanner.nextLine(); /* string to be converted */
				}
			}
			else if(s.equals("partial")) {
				String date = fileScanner.nextLine(); /* string to be converted */
				try {
					DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
					Date d = df.parse(date);
					Calendar c = GregorianCalendar.getInstance();
					c.setTime(d);
					String category = fileScanner.nextLine();
					String payee = fileScanner.nextLine();
					String paid = fileScanner.nextLine();
					String[] paidSplit = paid.split("\\.");
					int paidDollars = Integer.parseInt(paidSplit[0]);
					int paidCents = Integer.parseInt(paidSplit[1]);
					String remain = fileScanner.nextLine();
					String[] remainSplit = remain.split("\\.");
					int remainDollars = Integer.parseInt(remainSplit[0]);
					int remainCents = Integer.parseInt(remainSplit[1]);
					Partial partialExpense = new Partial(c, paidDollars, paidCents, payee, category, remainDollars, remainCents);
					expenses.add(partialExpense);
				}
				catch(ParseException e) {
					date = fileScanner.nextLine(); /* string to be converted */
				}
			}
			else {
				System.out.println("");
				System.err.print("Error occured in reading file. File not completely read.");
				System.out.println("");
			}
		}
		fileScanner.close();
		System.out.println("File loaded.");
		System.out.println("");
	}
	
	public static void choiceOne(int j, int size, List<Expense> expenses) {
		System.out.println("");
		for(j=0; j<size; j++) {
			System.out.print(expenses.get(j).printDisplay());
			System.out.println("");
		}
		System.out.println("");
		printMenu();
	}
	
	public static void choiceTwo(Scanner sc, List<Expense> expenses, Scanner fileScanner) {
		System.out.print("Expense type (in-full, partial)? ");
		String s = sc.nextLine();
		if(s.equals("in-full")) {
			System.out.print("Payment date (MM/dd/yyyy): ");
			String date = sc.nextLine(); /* string to be converted */
			try {
				DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
				Date d = df.parse(date);
				Calendar c = GregorianCalendar.getInstance();
				c.setTime(d);
				System.out.print("Expense Amount (dd.cc): ");
				String amount = sc.nextLine();
				String[] amountSplit = amount.split("\\.");
				int amountDollars = Integer.parseInt(amountSplit[0]);
				int amountCents = Integer.parseInt(amountSplit[1]);
				System.out.print("Who was this expense paid to? ");
				String payee = sc.nextLine();
				System.out.print("Expense category: ");
				String category = sc.nextLine();
				InFull inFullExpense = new InFull(c, amountDollars, amountCents, payee, category);
				expenses.add(inFullExpense);
				System.out.println("Expense added.");
				System.out.println("");
				printMenu();
			}
			catch(ParseException e) {
				date = sc.nextLine(); /* string to be converted */
			}
		}
		else if(s.equals("partial")) {
			System.out.print("Payment date (MM/dd/yyyy): ");
			String date = sc.nextLine(); /* string to be converted */
			try {
				DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
				Date d = df.parse(date);
				Calendar c = GregorianCalendar.getInstance();
				c.setTime(d);
				System.out.print("Expense Amount (dd.cc): ");
				String amount = sc.nextLine();
				String[] amountSplit = amount.split("\\.");
				int amountDollars = Integer.parseInt(amountSplit[0]);
				int amountCents = Integer.parseInt(amountSplit[1]);
				System.out.print("Who was this expense paid to? ");
				String payee = sc.nextLine();
				System.out.print("Expense category: ");
				String category = sc.nextLine();
				System.out.print("Expense Balance: ");
				String balance = sc.nextLine();
				String[] balanceSplit = balance.split("\\.");
				int balanceDollars = Integer.parseInt(balanceSplit[0]);
				int balanceCents = Integer.parseInt(balanceSplit[1]);
				Partial partialExpense = new Partial(c, amountDollars, amountCents, payee, category, balanceDollars, balanceCents);
				expenses.add(partialExpense);
				System.out.println("Expense added.");
				System.out.println("");
				printMenu();
			}
			catch(ParseException e) {
				date = fileScanner.nextLine(); /* string to be converted */
			}
		}
	}
	
	public static void choiceThree(Scanner sc, int i, List<Expense> expenses) {
		System.out.print("Keys to sort by (amount, category, date, payee): ");
		String sort = sc.nextLine();
		String[] sortSplit = sort.split(" ");
		List<String> sortList = new ArrayList<String>();
		int length = sortSplit.length;
		for(i=0; i<length; i++) {
			sortList.add(sortSplit[i]);
		}
		Collections.sort(expenses, recursiveSortHelper(sortList));
		System.out.println("Sorting finished.");
		printMenu();
	}
	
	public static void choiceFour(int j, int size, File input, List<Expense> expenses) throws FileNotFoundException {
		PrintWriter printer = new PrintWriter(input);
		for(j=0; j<size; j++) {
			Expense a = expenses.get(j);
			if(a.getType().equals("in-full")) {
				Date date = a.getDate().getTime();
				DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
				String dateString = df.format(date);
				printer.println("in-full");
				printer.println(dateString);
				printer.println(a.getCategory());
				printer.println(a.getPayee());
				printer.println(a.getPaid());
			}
			else if(a.getType().equals("partial")) {
				Date date = a.getDate().getTime();
				DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
				String dateString = df.format(date);
				printer.println("partial");
				printer.println(dateString);
				printer.println(a.getCategory());
				printer.println(a.getPayee());
				printer.println(a.getPaid());
				printer.println(a.getRemaining());
			}
		}
		System.out.println("Expenses Saved");
		System.out.println("");
		printer.close();
		printMenu();
	}
}
