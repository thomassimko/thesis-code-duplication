import java.text.*;
import java.util.*;

public class inFull
    implements Expense
{
    private String description;
    private String payee;
    private int dollars;
    private int cents;
    private Calendar date;
    public inFull(Calendar date, String payee, int dollars, int cents, String description)
    {
	this.date = date;
	this.dollars = dollars;
	this.cents = cents;
	this.payee = payee;
	this.description = description;
    }
    public Calendar getDate()
    {
	return date;
    }
    public int getDollarsPaid()
    {
	return dollars;
    }
    public int getCentsPaid()
    {
	return cents;
    }
    public String getPayee()
    {
	return payee;
    }
    public String getDescription()
    {
	return description;
    }
    public int getDollarsLeft()
    {
	throw new UnsupportedOperationException();
    }
    public int getCentsLeft()
    {
	throw new UnsupportedOperationException();
    }
    public String toString()
    {
	return String.format("%1$2tm/%<2td/%<tY ", date) + String.format("%-15.15s %s [%s]", payee, amountToString(), description);
    }
    public int getAmount()
    {
	return (dollars*100) + cents;
    }
    private String amountToString()
    {
	if(cents < 10 && cents >= 0){
	    return dollars + ".0" + cents;
	}
	return dollars + "." + cents;
    }
    public String toFileString()
    {
	return ("in-full\n" + String.format("%1$2tm/%<2td/%<tY", date) + "\n" + description + "\n" + payee + "\n" + amountToString());
    }
}