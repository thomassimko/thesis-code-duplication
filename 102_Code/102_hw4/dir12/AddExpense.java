import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class AddExpense {

	public static List<Expenses> add(List<Expenses> expended) throws ParseException {
		SimpleDateFormat df = new SimpleDateFormat("MM/dd/yyyy");
		Scanner in = new Scanner(System.in);
		double amount,balance = 0;
		String type, name, category, d;
		Date date = null;
		Calendar c;
		
		System.out.print("Expense type (in-full, partial)? ");
		type = in.nextLine();
		
		if(type.equals("in-full")){
			
			try {
				System.out.print("Payment date: ");
				d = in.next();
				date = df.parse(d);
				c = Calendar.getInstance();
				c.setTime(date);
				
				
			} catch (ParseException e) {
				System.err.println("that's not a date");
				throw e;
			}
			System.out.print("Expense Amount: ");
			amount = in.nextDouble();
			System.out.print("Who was this expense paid to? ");
			name = in.next();
			System.out.print("Expense category: ");
			category = in.next();
			amount = amount*100;
			expended.add(new inFull(date, (int) amount, name, category));
		}
		
		else if(type.equals("partial")){
			try {
				System.out.print("Payment date: ");
				d = in.next();
				date = df.parse(d);
				c = Calendar.getInstance();
				c.setTime(date);
				
				
			} catch (ParseException e) {
				System.err.println("that's not a date");
				throw e;
			}
			System.out.print("Expense Amount: ");
			amount = in.nextDouble();
			System.out.print("Who was this expense paid to? ");
			name = in.next();
			System.out.print("Expense category: ");
			category = in.next();
			System.out.print("Expense Balance: ");
			balance = in.nextDouble();
			amount = amount*100;
			
			expended.add(new partial(date,(int) amount, name, category, balance));
		}
		
		else{
			System.out.println("Invalid Type");
		}
		return expended;
	}
}
