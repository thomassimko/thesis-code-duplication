import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Expensify {

	public static void main(String[] args) throws IOException, ParseException {
		Scanner s = null;
		FileWriter out = null;
		Scanner scan = new Scanner(System.in);
		List<FullExpense> expenseList = new ArrayList<FullExpense>();
		boolean error = false;

		try {
			Date date;
			String category;
			String payee;
			double amount;
			double remainingAmount;

			s = new Scanner(
					new BufferedReader(new FileReader("StoredExpenses")));

			while (s.hasNextLine()) {
				String str = s.nextLine();
				if (str.equals("in-full")) {
					DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
					date = df.parse(s.nextLine());
					category = s.nextLine();
					payee = s.nextLine();
					amount = Double.parseDouble(s.nextLine());

					expenseList.add(new FullExpense(date, category, payee,amount));

				} else if (str.equals("partial")) {
					DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
					date = df.parse(s.nextLine());
					category = s.nextLine();
					payee = s.nextLine();
					amount = Double.parseDouble(s.nextLine());
					remainingAmount = Double.parseDouble(s.nextLine());
					
					expenseList.add(new PartialExpense(date, category, payee,amount, remainingAmount));

				}

			}
		} catch (NoSuchElementException e) {
			System.out.print("File Not Completely Loaded\n");
			error = true;
		}catch(ParseException e){
			System.out.print("File Not Completely Loaded\n");
			error = true;
		}
		if(!error){
			System.out.print("File Loaded\n");
		}
		
		int choice = 0;
		while (true) {
			System.out.println("\n1. Display");
			System.out.println("2. Add Expense");
			System.out.println("3. Sort");
			System.out.println("4. Save");
			System.out.println("5. Quit");
			System.out.print("\nEnter choice: ");
			choice = Integer.parseInt(scan.next());

			if (choice == 5)
				break;

			switch (choice) {
			case 1:
				for (FullExpense exp : expenseList) {
					String strOut;
					Date expDate = exp.getDate();
					String expPayee = exp.getPayee();
					Double expAmount = exp.getAmountPaid();
					String expCategory = exp.getCategory();

					if (exp instanceof PartialExpense) {
						Double expRemaining = ((PartialExpense) exp)
								.getRemainingAmount();
						strOut = String.format("%1$2tm/%<2td/%<tY ", expDate)
								+ String.format("%-15.15s %10s (%s) [%s]",
										expPayee, expAmount.toString(),
										expRemaining.toString(), expCategory);
					} else {
						strOut = String.format("%1$2tm/%<2td/%<tY ", expDate)
								+ String.format("%-15.15s %10s [%s]", expPayee,
										expAmount.toString(), expCategory);

					}
					System.out.print("\n" + strOut);
				}
				System.out.print("\n");
				break;
			case 2:
				System.out.print("Expense type (in-full, partial)? ");
				String type = scan.next();
				System.out.print("Payment date: ");
				String dateString = scan.next();
				DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
				Date date = df.parse(dateString);
				System.out.print("Expense Amount: ");
				Double amount = Double.parseDouble(scan.next());
				System.out.print("Who was this expense paid to? ");
				scan.nextLine();
				String payee = scan.nextLine();
				System.out.print("Expense category: ");
				String category = scan.nextLine();
				if (type.equals("in-full")) {
					ArrayList<FullExpense> listNew = new ArrayList<FullExpense>();

					listNew.add(new FullExpense(date, category, payee,amount));    
					listNew.addAll(expenseList);
					
					expenseList = listNew;
				} else {
					System.out.print("Expense Balance: ");
					Double remainingAmount = Double.parseDouble(scan.next());
					ArrayList<FullExpense> listNew = new ArrayList<FullExpense>();

					listNew.add(new PartialExpense(date, category, payee,amount, remainingAmount));    
					listNew.addAll(expenseList);
					
					expenseList = listNew;
				}
				break;
			case 3:
				System.out.print("Keys to sort by: ");
				scan.nextLine();
				String compType = scan.nextLine();
				String[] compArr = compType.split(" ");
				Comparator<FullExpense> listComp = recursiveComparator(compArr,0);
				Collections.sort(expenseList, listComp);
				break;
			case 4:
				try {
					out = new FileWriter("StoredExpenses");
					for (FullExpense exp : expenseList) {

						if (exp instanceof PartialExpense) {
							out.write("partial\r\n");
							out.write(new SimpleDateFormat("MM/dd/yyyy",
									Locale.US).format(exp.getDate()) + "\r\n");
							out.write(exp.getCategory() + "\r\n");
							out.write(exp.getPayee() + "\r\n");
							out.write(Double.toString(exp.getAmountPaid())
									+ "\r\n");
							out.write(Double.toString(((PartialExpense) exp)
									.getRemainingAmount()) + "\r\n");

						} else {
							out.write("in-full\r\n");
							out.write(new SimpleDateFormat("MM/dd/yyyy",
									Locale.US).format(exp.getDate()) + "\r\n");
							out.write(exp.getCategory() + "\r\n");
							out.write(exp.getPayee() + "\r\n");
							out.write(Double.toString(exp.getAmountPaid())
									+ "\r\n");
						}
					}

					out.flush();

				} catch (IOException e) {
					if (out != null) {
						out.close();
					}
				}
				break;
			}
		}

	}
	
	public static Comparator<FullExpense> comparatorBuilder(String comp){
		if(comp.equals("date")){
			Comparator<FullExpense> c = new ExpenseDateComparator();
			return c;
		}else if(comp.equals("amount")){
			Comparator<FullExpense> c = new ExpenseAmountComparator();
			return c;
		}else if(comp.equals("category")){
			Comparator<FullExpense> c = new ExpenseCategoryComparator();
			return c;
		}else if(comp.equals("payee")){
			Comparator<FullExpense> c = new ExpensePayeeComparator();
			return c;
		}
		return null;
	}
	
	public static Comparator<FullExpense> recursiveComparator(String[] compArr, int i){
		Comparator<FullExpense> comp = comparatorBuilder(compArr[i]);
		if(i == compArr.length - 1){
			return comp;
		}
		return new ExpenseDelegateComparator(comp,recursiveComparator(compArr,i + 1));	
	}

}
