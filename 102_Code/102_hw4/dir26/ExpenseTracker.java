import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class ExpenseTracker {
	private static SimpleDateFormat df;

	public static void main(String[] args) {
		ArrayList<Expense> expenses = new ArrayList<Expense>();
		Scanner fileScanner = null, inputScanner = new Scanner(System.in);
		df = new SimpleDateFormat("MM/dd/yyyy");
		File file = new File("StoredExpenses");
		if (file.exists()) {

			try {
				fileScanner = new Scanner(file);
				while (fileScanner.hasNext()) {
					expenses.add(parseExpense(fileScanner));
				}
				System.out.println("File Loaded\n");

			} catch (FileNotFoundException e) {
			} catch (ParseException e) {
				System.out
						.println("Error reading file: not all expenses were read.\n"
								+ e.getMessage() + "\n");
			}
			fileScanner.close();
		}
		while (true) {
			System.out
					.print("1. Display\n2. Add Expense\n3. Sort\n4. Save\n5. Quit\n\nEnter Choice: ");
			int choice = 0;
			try {
				choice = Integer.parseInt(inputScanner.nextLine());
			} catch (Exception e) {
				System.out.println("\nInvalid input.\n");
			}
			switch (choice) {
			case 1:
				System.out.println();
				for (Expense e : expenses)
					System.out.println(displayExpense(e));
				System.out.println("");
				break;
			case 2:
				System.out.println();
				System.out.print("Expense type (in-full, partial)? ");
				String type = inputScanner.nextLine();
				System.out.print("Payment date: ");
				String date = inputScanner.nextLine();
				System.out.print("Expense Amount: ");
				String amount = inputScanner.nextLine();
				System.out.print("Who was this expense paid to? ");
				String payee = inputScanner.nextLine();
				System.out.print("Expense category: ");
				String category = inputScanner.nextLine();
				Expense expense;
				try {
					if (type.equals("partial")) {
						System.out.print("Expense Balance: ");

						expense = new PartialExpense(df.parse(date), category,
								payee, new BigDecimal(amount), new BigDecimal(
										inputScanner.nextLine()));
						expenses.add(expense);
					} else if (type.equals("in-full")) {
						expense = new FullExpense(df.parse(date), category,
								payee, new BigDecimal(amount));
						expenses.add(expense);
					} else {
						throw new ParseException(null, 0);
					}
					System.out.println();
				} catch (Exception e) {
					System.out.println("\nInvalid Input\n");
				}
				break;
			case 3:
				System.out.print("\nKeys to sort by: ");
				String[] orderArray = inputScanner.nextLine().split(" ");
				ArrayList<String> order = new ArrayList<String>();
				for (String s : orderArray)
					order.add(s);
				Comparator<Expense> c;
				try {
					c = recursiveSortOrder(order);
					Collections.sort(expenses, c);
				} catch (ParseException e2) {
					System.out.println(e2.getMessage());
				}
				System.out.println();
				for (Expense e : expenses)
					System.out.println(displayExpense(e));
				System.out.println("");
				break;
			case 4:
				System.out.println();
				File out = new File("StoredExpenses");
				try {
					if (!out.exists())
						out.createNewFile();
					PrintWriter pw = new PrintWriter(out);
					for (Expense e : expenses) {
						pw.println(e.getType());
						pw.println(String.format("%1$2tm/%<2td/%<tY ",
								e.getDate()));
						pw.println(e.getCategory());
						pw.println(e.getPaidTo());
						pw.println(e.getAmount());
						if (e instanceof PartialExpense)
							pw.println(e.getBalance());
					}
					pw.flush();
					System.out.println("Expenses Saved\n");
				} catch (IOException e1) {
					System.out.println("Error writing file.\n");
				}
				break;
			case 5:
				return;
			default:
				System.out.println("\nInvalid choice number.\n");
			}
		}
	}

	private static String displayExpense(Expense e) {
		if (e instanceof FullExpense)
			return String.format("%1$2tm/%<2td/%<tY ", e.getDate())
					+ String.format("%-15.15s %s [%s]", e.getPaidTo(), e
							.getAmount().toString(), e.getCategory());
		else
			return String.format("%1$2tm/%<2td/%<tY ", e.getDate())
					+ String.format("%-15.15s %s (%s) [%s]", e.getPaidTo(),
							e.getAmount(), e.getBalance(), e.getCategory());
	}

	private static Expense parseExpense(Scanner scanner) throws ParseException {
		Expense expense;
		String type = scanner.nextLine();
		try {
			if (type.equals("in-full"))
				expense = new FullExpense(df.parse(scanner.nextLine()),
						scanner.nextLine(), scanner.nextLine(), new BigDecimal(
								scanner.nextLine()));
			else if (type.equals("partial"))
				expense = new PartialExpense(df.parse(scanner.nextLine()),
						scanner.nextLine(), scanner.nextLine(), new BigDecimal(
								scanner.nextLine()), new BigDecimal(
								scanner.nextLine()));
			else
				throw new ParseException("unrecognized type", 0);
		} catch (Exception e) {
			throw new ParseException("date/amount parse error "
					+ e.getMessage(), 0);
		}
		return expense;
	}

	private static Comparator<Expense> recursiveSortOrder(
			ArrayList<String> order) throws ParseException {
		String current = order.get(0);
		if (order.size() <= 1) {
			if (current.equals("amount")) {
				return new ExpenseAmountComparator();
			} else if (current.equals("category")) {
				return new ExpenseCategoryComparator();
			} else if (current.equals("date")) {
				return new ExpenseDateComparator();
			} else if (current.equals("payee")) {
				return new ExpensePayeeComparator();
			} else {
				throw new ParseException("Invalid sort parameter.", 0);
			}
		} else {
			order.remove(0);
			if (current.equals("amount")) {
				return new ExpenseDelegateComparator(
						new ExpenseAmountComparator(),
						recursiveSortOrder(order));
			} else if (current.equals("category")) {
				return new ExpenseDelegateComparator(
						new ExpenseCategoryComparator(),
						recursiveSortOrder(order));
			} else if (current.equals("date")) {
				return new ExpenseDelegateComparator(
						new ExpenseDateComparator(), recursiveSortOrder(order));
			} else if (current.equals("payee")) {
				return new ExpenseDelegateComparator(
						new ExpensePayeeComparator(), recursiveSortOrder(order));
			} else {
				throw new ParseException("Invalid sort parameter.", 0);
			}
		}
	}
}
