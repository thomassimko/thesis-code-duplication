import java.awt.List;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class ExpenseTrackingProgram {
	
	
	protected static Calendar convertDateType (String date) {
		try {
			DateFormat df = new SimpleDateFormat("MM/dd/yyyy"); 
			Date d = df.parse(date);
			Calendar c = Calendar.getInstance();
			c.setTime(d);
			return c;
		}
		catch (ParseException e) {
			System.out.println("Problem reading in data, specifically the date.");
			return null;
		}
	}
	
	protected static int convertToDollars (String amountPaid) {
		try {
			int decimalIndex = amountPaid.indexOf(".");
			//System.err.println("stream got to here.");
			String dollarPortion = amountPaid.substring(0, decimalIndex);
			//System.err.println("stream got to here too.");
			int dollarPortionInt = Integer.parseInt( dollarPortion );
			return dollarPortionInt;
		}
		catch (StringIndexOutOfBoundsException e) {
			System.out.println("Problem reading in data, specifically the expense amount or balance.");
			return -2;
		}
		catch (NumberFormatException e) {
			System.out.println("Problem reading in data, specifically the expense amount or balance.");
			return -2;
		}
	}
	
	protected static int convertToCents (String amountPaid) {
		try {
			int decimalIndex = amountPaid.indexOf(".");
			String centPortion = amountPaid.substring(decimalIndex+1, amountPaid.length());
			int centPortionInt = Integer.parseInt(centPortion);
			return centPortionInt;
		}
		catch (StringIndexOutOfBoundsException e){
			System.out.println("Problem reading in data, specifically the expense amount or balance.");
			return -2;
		}
		catch (NumberFormatException e) {
			System.out.println("Problem reading in data, specifically the expense amount or balance.");
			return -2;
		}
	}
	
	protected static LinkedList<Expense> putFileContenttoList() {
		LinkedList<Expense> expenseList = new LinkedList<Expense>();
		try {
			File storedExpenses = new File("StoredExpenses");
			Scanner scan = new Scanner(storedExpenses);
			int flag = 0;
			while (scan.hasNext() && flag != 1) {
				String type = scan.nextLine();
				String date = scan.nextLine();
				Calendar newDate = convertDateType(date);
				String category = scan.nextLine();
				String payee = scan.nextLine();
				String amountPaid = scan.nextLine();
				int paidDollars = convertToDollars(amountPaid);
				int paidCents = convertToCents(amountPaid);
				String remainingAmt = scan.nextLine();
				int remainingAmtDollars = convertToDollars(remainingAmt);
				int remainingAmtCents = convertToCents(remainingAmt);
				if (type == null || date == null || amountPaid == null || payee == null || category == null || remainingAmt == null || paidDollars == -2 || paidCents == -2 || remainingAmtDollars == -2 || remainingAmtCents == -2) {
					break;
				}
				if (type.equals("in-full")) {
					Expense newExpense = new InFullExpense(newDate, paidDollars, paidCents, payee, category);
					expenseList.addLast(newExpense);
				}
				else if (type.equals("partial")) {
					Expense newExpense = new PartialExpense(newDate, paidDollars, paidCents, payee, category, remainingAmtDollars, remainingAmtCents);
					expenseList.addLast(newExpense);
				}
				else {
					flag = 1;
				}
			}
			System.out.println("File Loaded");
			System.out.println("");
			scan.close();
			return expenseList;
		}
		catch (FileNotFoundException e) {
			System.out.println("Sorry, no valid file to read from.");
			return expenseList;
		}
		catch (NoSuchElementException e) {
			System.out.println("Problem reading in all of data. File partially loaded.");
			return expenseList;
		}
		catch (StringIndexOutOfBoundsException e) {
			System.out.println("Problem reading in all of data. File partially loaded.");
			return expenseList;
		}
	}
	
	private static void displayChoice (LinkedList<Expense> expenseList) {
		for (int i = 0; i < expenseList.size(); i++) {
			if (expenseList.get(i) instanceof InFullExpense) {
				System.out.println(expenseList.get(i).printExpense());
			}
			else {
				System.out.println(expenseList.get(i).printExpense());
			}
		}
	}
	private static LinkedList<Expense> addExpenseChoice (LinkedList<Expense> expenseList, Scanner scan) {
		System.out.print("Expense type (in-full, partial)? ");
		String expenseChoice = scan.next();
		String date, amount, payee, category, balance;
		int dollars, cents;
		if (expenseChoice.toLowerCase().equals("in-full")) {
			System.out.print("Payment date: ");
			date = scan.next();
			System.out.print("Expense Amount: ");
			amount = scan.next();
			System.out.print("Who was this expense paid to? ");
			payee = scan.next();
			System.out.print("Expense category: ");
			category = scan.next();
			Calendar dateCal = convertDateType(date);
			dollars = convertToDollars(amount);
			cents = convertToCents(amount);
			if (dateCal == null || dollars == -2 || cents == -2 || payee == null || category == null) {
				return expenseList;
			}
			Expense newInFullExpense = new InFullExpense(dateCal, dollars, cents, payee, category);
			expenseList.addFirst(newInFullExpense);
			return expenseList;
		}
		else if (expenseChoice.toLowerCase().equals("partial")) {
			int balDollars, balCents;
			System.out.print("Payment date: ");
			date = scan.next();
			System.out.print("Expense Amount: ");
			amount = scan.next();
			System.out.print("Who was this expense paid to? ");
			payee = scan.next();
			System.out.print("Expense category: ");
			category = scan.next();
			System.out.print("Expense Balance: ");
			balance = scan.next();
			Calendar dateCal = convertDateType(date);
			dollars = convertToDollars(amount);
			cents = convertToCents(amount);
			balDollars = convertToDollars(balance);
			balCents = convertToCents(balance);
			if (dateCal == null || dollars == -2 || cents == -2 || payee == null || category == null || balDollars == -2 || balCents == -2) {
				return expenseList;
			}
			Expense newPartialExpense = new PartialExpense(dateCal, dollars, cents, payee, category, balDollars, balCents);
			expenseList.addFirst(newPartialExpense);
			return expenseList;
		}
		else {
			System.out.println("Invalid expense type, please try again.");
			return expenseList;
		}
	}
	
	private static void saveChoice(LinkedList<Expense> expenseList) {
		try {
			File output = new File("StoredExpenses");
			PrintWriter writer = new PrintWriter(output);
			for (int i=0; i < expenseList.size(); i++) {
				String dateString = String.format("%1$2tm/%<2td/%<tY ", expenseList.get(i).getDate());
				writer.println(expenseList.get(i).getType());
				writer.println(dateString);
				writer.println(expenseList.get(i).getCategory());
				writer.println(expenseList.get(i).getPayee());
				writer.println(expenseList.get(i).getPaidAmount());
				writer.println(expenseList.get(i).getRemainingBal());
			}
			writer.close();
		}
		catch (FileNotFoundException e) {
			System.out.println("Did not save to file because could not find file 'StoredExpenses'");
		}
	}
	private static Comparator<Expense> sortChoiceComparatorBuilder(LinkedList<String> validKeys, int cur) {
		String lastKey = validKeys.get(validKeys.size()-1);
		Comparator<Expense> finalComparator;
		if (cur == validKeys.size()-1) {
			if (lastKey.equals("amount")) {
				return new ExpenseAmountComparator();
			}
			else if (lastKey.equals("payee")) {
				return new ExpensePayeeComparator();
			}
			else if (lastKey.equals("category")) {
				return new ExpenseCategoryComparator();
			}
			else {
				return new ExpenseDateComparator();
			}
		}
		else {
			if (validKeys.get(cur).equals("amount")) {
				finalComparator = new ExpenseAmountDelegateComparator(sortChoiceComparatorBuilder(validKeys, cur+1));
				return finalComparator;
			}
			else if (validKeys.get(cur).equals("payee")) {
				finalComparator = new ExpensePayeeDelegateComparator(sortChoiceComparatorBuilder(validKeys, cur+1));
				return finalComparator;
			}
			else if (validKeys.get(cur).equals("category")) {
				finalComparator = new ExpenseCategoryDelegateComparator(sortChoiceComparatorBuilder(validKeys, cur+1));
				return finalComparator;
			}
			else {
				finalComparator = new ExpenseDateDelegateComparator(sortChoiceComparatorBuilder(validKeys, cur+1));
				return finalComparator;
			}
		}
	}
	
	private static void sortChoice (LinkedList <Expense> expenseList, Scanner scan) {
		System.out.print("Keys to sort by: ");
		String multiWords = scan.nextLine();
		//System.out.println(multiWords);
		String keys[] = multiWords.split(" ");
		LinkedList<String> validKeys = new LinkedList<String>();
		for (int i = 0; i < keys.length; i++) {
			if (keys[i].toLowerCase().equals("amount") || keys[i].toLowerCase().equals("payee") || keys[i].toLowerCase().equals("category") || keys[i].toLowerCase().equals("date")) {
				validKeys.addLast(keys[i]);
			}
			else {
				System.out.println("Invalid key, unable to sort.");
				//System.out.println("Problematic key: " + keys[i]);
				return;
			}
		}
		Comparator<Expense> finalComparator = sortChoiceComparatorBuilder(validKeys, 0);
		Collections.sort(expenseList, finalComparator);
		/*for (int i = 0; i < validKeys.size(); i++) {
			System.out.println(validKeys.get(i));
		}*/
	}
	
	private static void menuLoadOut (LinkedList<Expense> expenseList) {
		int choice = 2;
		Scanner scan = new Scanner(System.in);
		System.out.println("1. Display");
		System.out.println("2. Add Expense");
		System.out.println("3. Sort");
		System.out.println("4. Save");
		System.out.println("5. Quit");
		System.out.println("");
		System.out.print("Enter choice: ");
		try {
		choice = scan.nextInt();
		}
		catch (InputMismatchException e) {
			System.out.println("You must enter your choice in integer form (1,2,3, or 4)");
			menuLoadOut(expenseList);
		}
		while (choice != 5) {
			switch (choice) {
				case 1: choice = 1;
				System.out.println("");
				displayChoice(expenseList);
				break;
				case 2: choice = 2;
				expenseList = addExpenseChoice(expenseList, scan);
				break;
				case 3: choice = 3;
				scan.nextLine();
				sortChoice(expenseList, scan);
				break;
				case 4: choice = 4;
				saveChoice(expenseList);
				break;
				case 5: choice = 5;
				System.exit(0);
				break;
				default:
				System.out.println("You must enter your choice in integer form (1,2,3, or 4).");
				break;
			}
			System.out.println("");
			System.out.println("1. Display");
			System.out.println("2. Add Expense");
			System.out.println("3. Sort");
			System.out.println("4. Save");
			System.out.println("5. Quit");
			System.out.println("");
			System.out.print("Enter choice: ");
			try {
				choice = scan.nextInt();
				}
				catch (InputMismatchException e) {
					System.out.println("You must enter your choice in integer form (1,2,3, or 4).");
					menuLoadOut(expenseList);
				}
		}
		
	}
	public static void main (String [] args) {
		LinkedList<Expense> expenseList = putFileContenttoList();
		menuLoadOut(expenseList);
	}
}
