import java.util.GregorianCalendar;
import java.util.Calendar;
import java.util.Date;

public class Expense{
	private Calendar c;
	private String type,category,paidTo;
	private String cents,dollars,remainingCents,remainingDollars;
	
	public Expense(){
		c=Calendar.getInstance();
	}
	public void setType(String t){
		type=t;
	}
	public String getType(){
		return type;
	}
	public Date getDate(){
		return c.getTime();
	}
	public void setDate(Date d){
		c.setTime(d);
	}
	public String getCategory(){
		return category;
	}
	public void setCategory(String cat){
		category=cat;
	}
	public String getPaidTo(){
		return paidTo;
	}
	public void setPaidTo(String pt){
		paidTo=pt;
	}
	public String getCents(){
		return cents;
	}
	public void setCents(String ce){
		cents=ce;
	}
	public String getDollars(){
		return dollars;
	}
	public void setDollars(String d){
		dollars=d;
	}
	public String getRemainingDollars(){
		return remainingDollars;
	}
	public void setRemainingDollars(String d){
		remainingDollars=d;
	}
	public String getRemainingCents(){
		return remainingCents;
	}
	public void setRemainingCents(String ce){
		remainingCents=ce;
	}
}