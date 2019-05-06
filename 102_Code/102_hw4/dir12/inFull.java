import java.util.*;

public class inFull implements Expenses {
	private Date date;
	private int amount;
	private String name, category;
	
	public inFull(Date date2, int a, String name, String c){
		this.date=date2;
		this.amount=a;
		this.name=name;
		this.category=c;
		
	}
	
	public Date getDate(){
		return date;
	}

	public double getAmount(){
		return amount;
	}
	
	public String getName(){
		return name;
	}
	
	public String getCategory(){
		return category;
	}

	public double getBalance() {

		return 0;
	}

	public String print() {
		
		return String.format("%1$2tm/%<2td/%<tY ", date)+ String.format("%-15.15s %s [%s]", name, (double)amount/100, category);
	}

	public String getType() {
		
		return "in-full";
	}
}