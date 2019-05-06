import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;


public class Expenses {
	Scanner in = new Scanner(System.in);
	ArrayList<Expense> expenses = new ArrayList<Expense>();
	
	public void start() throws IOException, ParseException {
		File file = new File("StoredExpenses");
		if (file.exists()) {
			load(file);
			System.out.println("File Loaded");
		}
		supermenu();
	}
	
	private void supermenu() throws IOException {
		System.out.println();
		int choice = 1; //just a value that's not out of bounds
		do {
			if (choice < 1 || choice > 5)
				System.out.println("Your choice was invalid. Try again.");
			choice = menu();
		} while (choice < 1 || choice > 5);
		
		switch (choice) {
			case 1: display(); break;
			case 2: addExpense(); break;
			case 3: sort(); break;
			case 4: save(); break;
			case 5: System.exit(0); break;
			default: System.err.println("something went wrong."); break;
		}
		supermenu();
	}
	
	private int menu() {
		System.out.println("1. Display\n2. Add Expense\n3. Sort\n4. Save\n5. Quit");
		System.out.print("\nEnter choice: ");
		return Integer.parseInt(in.nextLine());
	}
	
	private void save() throws IOException {
		File file = new File("StoredExpenses");
		file.delete();
		file.createNewFile();
		FileWriter writer = new FileWriter(file);
		String write = "";
		for (Expense e: expenses) {
			write = write + (e.type() ? "in-full" : "partial") + "\n";
			write = write + String.format("%1$2tm/%<2td/%<tY\n", e.getDate());
			write = write + e.getCategory() + "\n";
			write = write + e.getPayee() + "\n";
			write = write + e.getPaid() + "\n";
			if (!e.type())
				write = write + e.getRemaining() + "\n";
		}
		writer.write(write);
		writer.close();
		System.out.println("\nExpenses Saved");
	}

	private void sort() {
		System.out.print("Keys to sort by (separate by spaces): ");
		String list = in.nextLine();
		Scanner listparse = new Scanner(list);
		ArrayList<String> sortlist = new ArrayList<String>();
		while (listparse.hasNext()) {
			String sort = listparse.next().toLowerCase();
			if (sort.equals("amount") || sort.equals("category") || sort.equals("date") || sort.equals("payee"))
				sortlist.add(sort);
		}
		Comparator<Expense> sorter;
		if (sortlist.size() == 1)
			sorter = makeComparator(sortlist.remove(0));
		else
			sorter = makeDelegator(sortlist.remove(0), sortlist);
		Collections.sort(expenses, sorter);
	}
	
	private ExpenseDelegateComparator makeDelegator(String sort, ArrayList<String> list) {
		switch (sort) {
			case "amount": 
				if (list.size() == 1)
					return new ExpenseDelegateComparator(new ExpenseAmountComparator(), makeComparator(list.remove(0)));
				return new ExpenseDelegateComparator(new ExpenseAmountComparator(), makeDelegator(list.remove(0),list));
			case "category": 
				if (list.size() == 1)
					return new ExpenseDelegateComparator(new ExpenseCategoryComparator(), makeComparator(list.remove(0)));
				return new ExpenseDelegateComparator(new ExpenseCategoryComparator(), makeDelegator(list.remove(0),list));
			case "date": 
				if (list.size() == 1)
					return new ExpenseDelegateComparator(new ExpenseDateComparator(), makeComparator(list.remove(0)));
				return new ExpenseDelegateComparator(new ExpenseDateComparator(), makeDelegator(list.remove(0),list));
			case "payee": 
				if (list.size() == 1)
					return new ExpenseDelegateComparator(new ExpensePayeeComparator(), makeComparator(list.remove(0)));
				return new ExpenseDelegateComparator(new ExpensePayeeComparator(), makeDelegator(list.remove(0),list));
		}
		return null;
	}
	
	private Comparator<Expense> makeComparator(String sort) {
		switch (sort) {
			case "amount": return new ExpenseAmountComparator();
			case "category": return new ExpenseCategoryComparator();
			case "date": return new ExpenseDateComparator();
			case "payee": return new ExpensePayeeComparator();
		}
		return null;
	}

	private void addExpense() {
		String type = "";
		boolean marker = false;
		do {
			if (marker)
				System.err.println("Wrong expense type. Try again");
			System.out.print("Expense type (in-full, partial)? ");
			type = in.nextLine();
			marker = true;
		} while (!type.equals("in-full")&&!type.equals("partial"));
		
		Calendar cal = Calendar.getInstance();
		do {
			try {
				System.out.print("Payment Date: ");
				cal.setTime(new SimpleDateFormat("MM/dd/yyyy").parse(in.nextLine()));
				marker = true;
			} catch (ParseException e) {
				System.err.println("Wrong date format. Try again.");
			}
		} while (!marker);
		String dollars = "";
		marker = false;
		int edollars = 0;
		int ecents = 0;
		do {
			try {
				System.out.print("Expense Amount: ");
				dollars = in.nextLine();
				Double.parseDouble(dollars);
				int endat;
				if (!dollars.contains("."))
					edollars = Integer.parseInt(dollars);
				else if(dollars.charAt(0) == '.') {
					ecents = Integer.parseInt(dollars.substring(1));
				}
				else {
					for (endat = 0; dollars.charAt(endat) != '.'; endat++){}
					edollars = Integer.parseInt(dollars.substring(0,endat));
					ecents = Integer.parseInt(dollars.substring(endat+1));
				}
				marker = true;
			} catch (NumberFormatException e) {
				System.err.println("Wrong money format. Try again.");
			}
		} while (!marker);
		System.out.print("Who was this expense paid to? ");
		String paidTo = in.nextLine();
		System.out.print("Expense category: ");
		String category = in.nextLine();
		String balance;
		int bdollars = 0;
		int bcents = 0;
		marker = false;
		if (type.equals("partial")) {
			do {
				try {
					System.out.print("Expense balance: ");
					balance = in.nextLine();
					Double.parseDouble(balance);
					int endat;
					if (!balance.contains("."))
						bdollars = Integer.parseInt(balance);
					else if(balance.charAt(0) == '.') {
						bcents = Integer.parseInt(balance.substring(1));
					}
					else {
						for (endat = 0; balance.charAt(endat) != '.'; endat++){}
						bdollars = Integer.parseInt(balance.substring(0,endat));
						bcents = Integer.parseInt(balance.substring(endat+1));
					}
					marker = true;
				} catch (NumberFormatException e) {
					System.err.println("Wrong money format. Try again.");
				}
			} while (!marker);
			expenses.add(0, new PartialExpense(cal, edollars, ecents, paidTo, category, bdollars, bcents));
		}
		else
			expenses.add(0, new InFullExpense(cal, edollars, ecents, paidTo, category));
	}
	
	private void display() {
		for (Expense e: expenses)
			System.out.println(e.type() ? String.format("%1$2tm/%<2td/%<tY ", e.getDate())
								+ String.format("%-15.15s %10s [%s]", e.getPayee(),
								e.getPaid().toString(), e.getCategory()):
								String.format("%1$2tm/%<2td/%<tY ", e.getDate()) +
								String.format("%-15.15s %10s (%s) [%s]", e.getPayee(),
								e.getPaid().toString(), e.getRemaining().toString(),
								e.getCategory()));
	}
	
	private void load(File file) throws ParseException {
		Scanner loader = null;
		try {
			loader = new Scanner(file);
		} catch (FileNotFoundException e) {
			System.err.println("File not found");
		}
		
		while (loader.hasNext()) {
			String type = loader.nextLine();
			String date = loader.nextLine();
			String category = loader.nextLine();
			String paidTo = loader.nextLine();
			String amount = loader.nextLine();
			String remaining;
			int endat;
			for (endat = 0; amount.charAt(endat) != '.'; endat++) {}
			int amountd = Integer.parseInt(amount.substring(0, endat));
			int amountc = Integer.parseInt(amount.substring(endat+1));
			Calendar cal = Calendar.getInstance();
			cal.setTime(new SimpleDateFormat("MM/dd/yyyy").parse(date));
			if (type.equals("partial")) {
				remaining = loader.nextLine();
				for (endat = 0; remaining.charAt(endat) != '.'; endat++) {}
				int remainingd = Integer.parseInt(remaining.substring(0, endat));
				int remainingc = Integer.parseInt(remaining.substring(endat+1));
				expenses.add(new PartialExpense(cal, amountd,amountc, 
						paidTo, category, remainingd, remainingc));
			} else
			expenses.add(new InFullExpense(cal, amountd, amountc, 
					paidTo, category));
		}
	}
	
	public static void main(String[] args) throws IOException, ParseException {
		Expenses program = new Expenses();
		program.start();
	}
}
