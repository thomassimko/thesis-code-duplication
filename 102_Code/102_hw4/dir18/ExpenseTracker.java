import java.util.*;
import java.text.*;
import java.io.*;

public class ExpenseTracker
{
    public static void main(String [] args)
    {
	optionScreen();
    }
    private static void optionScreen()
    {
	int choice = 0;
	Scanner scannerInput = new Scanner(System.in);
	List<Expense> list = new ArrayList<Expense>();
	loadFile(list);

	try{
	    while(choice != 5){
		System.out.println("1. Display\n2. Add Expense\n3. Sort\n4. Save\n5. Quit\n");
		System.out.print("Enter your choice: ");
		choice = scannerInput.nextInt();
		System.out.println("");
		switch (choice){
		case 1: 
		   displayExpenses(list);
		   break;
		case 2: 
		   addExpense(list, scannerInput);
		   break;
		case 3: 
		   sortExpenses(list, scannerInput);
		   break;
		case 4: 
		   saveChanges(list);
		   break;		}
	    }
	}
	catch(InputMismatchException e){
	    System.out.println("Invalid choice");
	    optionScreen();
	}
    }
    private static void loadFile(List<Expense> list)
    {
	try{
	    Calendar d = null;
	    Scanner scanner = new Scanner(new File("StoredExpenses"));
	    Scanner scanner2;
	    String type, str, strDate, payee, amount, amountLeft, category;
	    int dollars, cents, dollarsLeft, centsLeft;
	    while(scanner.hasNextLine()){
		type = scanner.nextLine();
		strDate = scanner.nextLine();
		category = scanner.nextLine();
		payee = scanner.nextLine();
		amount = scanner.nextLine();
		
		d = dateConverter(strDate);
		dollars = strToDollar(amount);
		cents = strToCents(amount);
		if(type.equals("in-full")){
		    Expense expense = new inFull(d, payee, dollars, cents, category);
		    list.add(expense);
		}
		else if(type.equals("partial")){
		    amountLeft = scanner.nextLine();
		    dollarsLeft = strToDollar(amountLeft);
		    centsLeft = strToCents(amountLeft);
		    Expense expense = new inPart(d, payee, dollars, cents, dollarsLeft, centsLeft, category);
		    list.add(expense);
		}
	    }
	    System.out.println("File Loaded\n");
	}
	catch(FileNotFoundException e){
	    System.out.println("File not found\n");
	}
    }
    private static void displayExpenses(List<Expense> list)
    {
	int size = list.size();
	for(int i = 0; i < size; i++){
	    System.out.println(list.get(i).toString());
	}
	System.out.println("");
    }
    private static void addExpense(List<Expense> list, Scanner scanner)
    {
	String expenseType, dateStr, amountStr, category, payee, amountLeft;
	int dollarsPaid, centsPaid, dollarsLeft, centsLeft;
	Calendar date;
	System.out.print("Expense type (in-full, partial)? ");
	expenseType = scanner.next();
	System.out.print("Payment date: ");
	dateStr = scanner.next();
	date = dateConverter(dateStr);
	System.out.print("Expense Amount: ");
	amountStr = scanner.next();
	dollarsPaid = strToDollar(amountStr);
	centsPaid = strToCents(amountStr);
	System.out.print("Who was this expense paid to? ");
	payee = scanner.next();
	System.out.print("Expense category: ");
	category = scanner.next();
	if(expenseType.equals("in-full")){
	    System.out.println("");
	    Expense newExpense = new inFull(date, payee, dollarsPaid, centsPaid, category);
	    list.add(newExpense);
	}
	else if(expenseType.equals("partial")){
	    System.out.print("Expense balance: ");
	    amountLeft = scanner.next();
	    System.out.println("");
	    dollarsLeft = strToDollar(amountLeft);
	    centsLeft = strToCents(amountLeft);
	    Expense newExpense = new inPart(date, payee, dollarsPaid, centsPaid, dollarsLeft, centsLeft, category);
	    list.add(newExpense);
	}
	else{
	    System.err.println("Invalid type of expense");
	}
    }
    private static void sortExpenses(List<Expense> list, Scanner scanner)
    {
	List<String> keyList = new ArrayList<String>();
	int counter = 0, i = 0;
	Comparator<Expense> cur = null;
	System.out.print("Keys to sort by: ");
	String str = scanner.nextLine();
	Scanner scannerSplitter = new Scanner(scanner.nextLine());
	while(scannerSplitter.hasNext()){
	    keyList.add(0, scannerSplitter.next());
	    System.err.println(keyList.get(0));
	}
 	counter = keyList.size();
	while(i < counter){
	    if(keyList.get(i).equals("amount")){
		if(cur == null){
		    cur = new ExpenseAmountComparator();
		    System.err.println("amount");
		}
		else{
		    cur = new ExpenseAmountDelegateComparator(cur);
		    System.err.println("amountdelegator");
		}
	    }
	    else if(keyList.get(i).equals("category")){
		if(cur == null){
		    cur = new ExpenseCategoryComparator();
		    System.err.println("category");
		}
		else{
		    cur = new ExpenseCategoryDelegateComparator(cur);
		    System.err.println("categorydelegator");
		}
	    }
	    else if(keyList.get(i).equals("date")){
		if(cur == null){
		    cur = new ExpenseDateComparator();
		    System.err.println("date");
		}
		else{
		    cur = new ExpenseDateDelegateComparator(cur);
		    System.err.println("datedelegator");
		}
	    }
	    else if(keyList.get(i).equals("payee")){
		if(cur == null){
		    cur = new ExpensePayeeComparator();
		    System.err.println("payee");
		}
		else{
		    cur = new ExpensePayeeDelegateComparator(cur);
		    System.err.println("payeedelegator");
		}
	    }
	    else{
		System.err.println("Invalid key");
		return;
	    }
	    i++;
	}
	Collections.sort(list, cur);
    }
    private static void saveChanges(List<Expense> list)
    {
	try{
	    PrintWriter writer = new PrintWriter(new File("StoredExpenses"));
	    int size = list.size();
	    for(int i = 0; i < size; i++){
		writer.println(list.get(i).toFileString());
	    }
	    writer.close();
	}
	 catch(FileNotFoundException e){
	     System.err.println("File not found to override.");
	 }
    }
    private static Calendar dateConverter(String str)
    {
	Calendar c = null;
	try{
	   DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
	   Date d = df.parse(str);
	   c = Calendar.getInstance();
	   c.setTime(d);
	}
	catch(ParseException e){
	    System.out.println("Incorrect format for date");
	}
	return c;
    }
    private static int strToDollar(String amount)
    {
	int index = amount.indexOf(".");
	String dollars = amount.substring(0, index);
	return Integer.parseInt(dollars);
    }
    private static int strToCents(String amount)
    {
	int index = amount.indexOf(".");
	String cents = amount.substring(index+1);
	return Integer.parseInt(cents);
    }
}