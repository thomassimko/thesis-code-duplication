import java.io.File;
import java.io.FileNotFoundException;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Scannered {
	public static List<Expenses> Scanned(){
		List<Expenses> expended = new ArrayList<Expenses>();
		File f = new File("StoredExpenses");
		if(f.exists()){ 
			try {
				Scanner sc =new Scanner(f);
				Scanner sp;
				SimpleDateFormat df = new SimpleDateFormat("MM/dd/yyyy ");
				
				double remaining;
				String name = null;
				String category = null;
				Date d;
				double amount;
				
				while (sc.hasNext()){
					
					String string = sc.nextLine();
					if(string.equals("in-full")){
						d = df.parse(sc.nextLine());
						Calendar c = Calendar.getInstance();
						c.setTime(d);
						
						category = sc.nextLine();
						name = sc.nextLine();
						amount = (int) (Double.parseDouble(sc.nextLine())*100);
						
						expended.add(new inFull(d,(int) amount, name, category));
					}else if (string.equals("partial")){
						d = df.parse(sc.nextLine());
						Calendar c = Calendar.getInstance();
						c.setTime(d);
						
						category = sc.nextLine();
						name = sc.nextLine();
						amount = (int) (Double.parseDouble(sc.nextLine())*100);
						remaining = Double.parseDouble(sc.nextLine());
						

						
						expended.add(new partial(d, (int) amount, name, category, remaining));
					}else{
						System.err.println("invalid strings in "+ f.toString());
						return expended;
					}
				}
				
			System.out.println("File Loaded");

			}catch( FileNotFoundException e ){
				System.err.println("cant find "+ f.toString());
				return expended;
			} catch (ParseException e) {
				System.err.println("invalid strings in "+ f.toString());
				return expended;
			}
		}
		return expended;
	}
}
