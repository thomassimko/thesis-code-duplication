	import java.text.ParseException;
import java.util.*;
import java.io.*;
	
public class Main {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		List<Expenses> expended = Scannered.Scanned();
		int step = 0;
		
		while(step != 5){
				
			System.out.println("");
			System.out.println("1. Display");
			System.out.println("2. Add Expense");
			System.out.println("3. Sort");
			System.out.println("4. Save");
			System.out.println("5. Quit");
			System.out.println("");
			System.out.print("Enter choice: ");
			step = in.nextInt();
				
				if(step<1||step>5){
					System.out.println("");
					System.out.println("Invalid choice.");
				}
				else if(step==1){
					 Display.Display(expended);
				}
				else if(step==2){
					System.out.println("");
					try {
						expended = AddExpense.add(expended);
					} catch (ParseException e) {
					}
				}
				else if(step==3){
					System.out.println("Keys to sort by: ");
					String order = in.nextLine();
					expended = Sort.sortIt(expended, order);
				}
				else if(step==4){
					Save.save(expended);
				}
			}
	}

}
