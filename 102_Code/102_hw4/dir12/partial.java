import java.util.*;

public class partial implements Expenses {
	private Date date;
	private double balance;
	private int amount;
	private String name, category;
	
	public partial(Date d, int a, String who, String c, double b){
		this.date=d;
		this.amount=a;
		this.name=who;
		this.category=c;
		this.balance=b;
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
	
	public double getBalance(){
		return balance;
	}

	public String print() {

		return String.format("%1$2tm/%<2td/%<tY ", date)+ String.format("%-15.15s %s (%s) [%s]", name, (double)amount/100, balance, category);
	}

	public String getType() {

		return "partial";
	}
}
