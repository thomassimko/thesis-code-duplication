import java.text.*;
import java.util.*;

public class inPart
    implements Expense
{
    private Calendar date;
    private String description;
    private String payee;
    private int dollarsPaid;
    private int centsPaid;    
    private int dollarsLeft;
    private int centsLeft;
    public inPart(Calendar date, String payee, int dollarsPaid, int centsPaid, int dollarsLeft, int centsLeft, String description)
    {
	this.date = date;
	this.description = description;
	this.payee = payee;
	this.dollarsPaid = dollarsPaid;
	this.centsPaid = centsPaid;
	this.dollarsLeft = dollarsLeft;
	this.centsLeft = centsLeft;
    }
    public Calendar getDate()
    {
	return date;
    }
    public int getDollarsPaid()
    {
	return dollarsPaid;
    }
    public int getCentsPaid()
    {
	return centsPaid;
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
	return dollarsLeft;
    }
    public int getCentsLeft()
    {
	return centsLeft;
    }
    public String toString()
    {
	return String.format("%1$2tm/%<2td/%<tY ", date) + String.format("%-15.15s %s (%s) [%s]", payee, getPaid(), getLeft(), description);
    }
    private String getPaid()
    {
	if(centsPaid < 10 && centsPaid >= 0){
	    return dollarsPaid + ".0" + centsPaid;
	}
	return dollarsPaid + "." + centsPaid;
    }
    private String getLeft()
    {
	if(centsLeft < 10 && centsLeft >= 0){
	    return dollarsLeft + ".0" + centsLeft;
	}
	return dollarsLeft + "." + centsLeft;
    }
    public int getAmount()
    {
	return (dollarsPaid*100) + centsPaid;
    }
    public String toFileString()
    {
	return ("partial\n" + String.format("%1$2tm/%<2td/%<tY", date) + "\n" + description + "\n" + payee + "\n" + getPaid() + "\n" + getLeft());
    }
}