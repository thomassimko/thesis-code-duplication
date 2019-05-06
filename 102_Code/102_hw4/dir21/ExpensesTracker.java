import java.util.Date;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.*;
import java.lang.Integer;
import java.lang.String;

//main method in here, please disregard CategoryComparator.java AmountComparator.java DateComparator.java as they are not being used.

@SuppressWarnings("unchecked")
public class ExpensesTracker{
	private static List<Expense> StoredExpenses;
	private static Scanner s;
	private static int index;
	private static SimpleDateFormat dateFormat;
	
	private static void load(){
		BufferedReader inputStream=null;
		StoredExpenses=new ArrayList<Expense>();
		try{
			String tmp;
			int i=0;
			inputStream=new BufferedReader(new FileReader("StoredExpenses.txt"));
			tmp=inputStream.readLine();
			while(tmp!=null){
				Expense e=new Expense();
				e.setType(tmp);
				
				//parse date
				tmp=inputStream.readLine();//date
				
				Date d = dateFormat.parse(tmp);
				e.setDate(d);
				
				tmp=inputStream.readLine();//category
				e.setCategory(tmp);
				
				tmp=inputStream.readLine();//paid to
				e.setPaidTo(tmp);
				
				tmp=inputStream.readLine();//amount
				String [] money=tmp.split("[.]");//you said to assume correct user input, so not checking.
				e.setDollars(money[0]);
				e.setCents(money[1]);
				
				tmp=inputStream.readLine();//owed amount, saved as 0.0 for ones that are full
				money=tmp.split("[.]");
				e.setRemainingDollars(money[0]);
				e.setRemainingCents(money[1]);
				StoredExpenses.add(e);
				
				i++;
				tmp=inputStream.readLine();
			}
			index=i;
		}
		catch(IOException e){
			System.err.println("failed to load");
		}
		catch(ParseException e){
			System.err.println("failed to parse");
		}
		finally{
			try{
				inputStream.close();
			}
			catch(IOException e){
				System.err.println("failed to save");
			}
			System.out.println("File Loaded \n");
		}
	}
	private static void save(){
		PrintWriter outputStream=null;
		try{
			outputStream=new PrintWriter(new FileWriter("StoredExpenses.txt"));
			for(int i=0;i<index;i++){
				Expense e=StoredExpenses.get(i);
				outputStream.println(e.getType());
				outputStream.println(dateFormat.format(e.getDate()));
				outputStream.println(e.getCategory());
				outputStream.println(e.getPaidTo());
				outputStream.println(e.getDollars()+"."+e.getCents());
				outputStream.println(e.getRemainingDollars()+"."+e.getRemainingCents());
			}
		}
		catch(IOException e){
			System.err.println("failed to save");
		}
		finally{
			if(outputStream!=null){
				outputStream.close();
			}
		}
	}
	public static void displayExpenses(){
		for(int i=0;i<index;i++){
			
			Expense e=StoredExpenses.get(i);
			if(e.getType().equals("partial")){
				String date=dateFormat.format(e.getDate());
				String payee=e.getPaidTo();
				String payment=e.getDollars()+"."+e.getCents();
				String category=e.getCategory();
				String remaining=e.getRemainingDollars()+"."+e.getRemainingCents();
				System.out.println(date+" "+payee+"      "+payment+" ("+remaining+") ["+category+"]");
			}
			else{
				String date=dateFormat.format(e.getDate());
				String payee=e.getPaidTo();
				String payment=e.getDollars()+"."+e.getCents();
				String category=e.getCategory();
				System.out.println(date+" "+payee+"      "+payment+" ["+category+"]");
			}
		}
		System.out.print("\n");
	}
	public static void addExpense(){
		
		System.out.print("Expense type (in-full, partial)? ");
		String type=s.nextLine();
		Expense e=new Expense();
		e.setType(type);
		System.out.print("Payment date: ");
		String str=s.nextLine(); /* string to be converted */
		Date d=new Date();//make java stop complaining about "might be uninitialized"
		try{
			d = dateFormat.parse(str);
		}
		catch(ParseException err){
			System.err.println("failed to parse");
		}
		e.setDate(d);
		System.out.print("Expense Amount: ");
		String tmp=s.nextLine();
		String [] money=tmp.split("[.]");
		e.setDollars(money[0]);
		e.setCents(money[1]);
		System.out.print("Who was this expense paid to? ");
		e.setPaidTo(s.nextLine());
		System.out.print("Expense category: ");
		e.setCategory(s.nextLine());
		if(type.equals("partial")){
			System.out.print("Expense Balance: ");
			tmp=s.nextLine();
			money=tmp.split("[.]");
			e.setRemainingDollars(money[0]);
			e.setRemainingCents(money[1]);
		}
		else{
			e.setRemainingDollars("0");
			e.setRemainingCents("0");
		}	
		StoredExpenses.add(index,e);
		index++;
	}
	public static void sortExpenses(){
		System.out.println("Keys to sort by: ");
		String [] keys=s.nextLine().split("[ ]");
		Comparator<Expense> forSort=new ExpenseCategoryComparator();
		int dist=keys.length;
		if(dist==1){
			if(keys[0].equals("date")){
				forSort=new ExpenseDateComparator();
			}
			else if(keys[0].equals("amount")){
				forSort=new ExpenseAmountComparator();
			}
			else if(keys[0].equals("payee")){
				forSort=new ExpensePayeeComparator();
			}
			else{
				forSort=new ExpenseCategoryComparator();
			}
		}
		else if(dist>1){
			forSort=delegate(dist,0,keys);
		}
		Collections.sort(StoredExpenses,forSort);
	}
	public static Comparator<Expense> delegate(int marker,int index,String [] keys){
		if(index<marker-1){
			if(keys[index].equals("date")){
				return new ExpenseDateDelegateComparator(delegate(marker,index+1,keys));
			}
			else if(keys[index].equals("amount")){
				return new ExpenseAmountDelegateComparator(delegate(marker,index+1,keys));
			}
			else if(keys[index].equals("payee")){
				return new ExpensePayeeDelegateComparator(delegate(marker,index+1,keys));
			}
			else{
				return new ExpenseCategoryDelegateComparator(delegate(marker,index+1,keys));
			}	
		}
		else{
			if(keys[0].equals("date")){
				return new ExpenseDateComparator();
			}
			else if(keys[0].equals("amount")){
				return new ExpenseAmountComparator();
			}
			else if(keys[0].equals("payee")){
				return new ExpensePayeeComparator();
			}
			else{
				return new ExpenseCategoryComparator();
			}
		}
	}
	public static void chooseAction(){
		s=new Scanner(System.in);
		System.out.print(" 1. Display \n 2. Add Expense \n 3. Sort \n 4. Save \n 5. Quit \n\n Enter choice: ");
		int choice=Integer.parseInt(s.nextLine());
		while(choice!=5){
			switch(choice){
				case 1:  //display expenses
					displayExpenses();
					break;
				case 2:  //add an expense
					addExpense();
					break;
				case 3:  //sort expenses
					sortExpenses();
					break;
				case 4:  //save expenses
					save();
					break;
				case 5:  //quit
					return;
				default:
					System.out.println("invalid input");
					break;
			}
			System.out.print(" 1. Display \n 2. Add Expense \n 3. Sort \n 4. Save \n 5. Quit \n\n Enter choice: ");
			choice=Integer.parseInt(s.nextLine());
		}
	}
	public static void main(String [] args_){
		index=0; //yes I like arrays, this is the index for the array of expenses
		dateFormat= new SimpleDateFormat("MM/dd/yyyy");
		load();
		chooseAction();
	}
	
}