import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class expenseFileReader 
{
	private String type;
	private String d;
	private String category;
	private String paidTo;
	private String amountDollarsString;
	private int amountDollars;
	private int amountCents;
	private String amountRemainingDollarsString;
	private int amountRemainingDollars;
	private int amountRemainingCents;
	
	private Date date;
	
	private Scanner scanner;
	
	public expenseFileReader(Scanner scanner)
	{		
		this.scanner = scanner;
		
		readType();
		
		if(type.equals("partial"))
		{
			readDate();
			readCat();
			readPaidTo();
			readAmount();
			readPartialAmount();
		}
		else
		{
			readDate();
			readCat();
			readPaidTo();
			readAmount();
		}
	}
	
	private void readType()
	{		
		this.type = scanner.nextLine();
	}
	
	private void readDate()
	{
		this.d = scanner.nextLine();
		
		convertDate();
	}
	
	private void readCat()
	{
		this.category = scanner.nextLine();
	}
	
	private void readPaidTo()
	{
		this.paidTo = scanner.nextLine();
	}
	
	private void readAmount()
	{
		this.amountDollarsString = scanner.nextLine();
		
		convertAmount();
	}
	
	private void readPartialAmount()
	{
		this.amountRemainingDollarsString = scanner.nextLine();
		
		convertPartialAmount();
	}
	
	private void convertDate()
	{
		DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
		try 
		{
			this.date = df.parse(d);
		} 
		catch (ParseException e) 
		{
			System.out.println("Invalid date.");
		}
	}
	
	private void convertAmount()
	{
		int decimalIndex;
		
		decimalIndex = amountDollarsString.indexOf('.');
		
		Integer i;
		
		i = new Integer(amountDollarsString.substring(0, decimalIndex));
		this.amountDollars = i.intValue();

		i = new Integer(amountDollarsString.substring(decimalIndex + 1, decimalIndex + 3));
		this.amountCents = i.intValue();
	}
	
	private void convertPartialAmount()
	{
		int decimalIndex;
		
		decimalIndex = amountRemainingDollarsString.indexOf('.');
		
		Integer i;
		
		i = new Integer(amountRemainingDollarsString.substring(0, decimalIndex));
		this.amountRemainingDollars = i.intValue();
		
		i = new Integer(amountRemainingDollarsString.substring(decimalIndex + 1, decimalIndex + 3));
		this.amountRemainingCents = i.intValue();
	}
	
	public String getType()
	{
		return this.type;
	}
	
	public Date getDate()
	{
		return this.date;
	}
	
	public String getCategory()
	{
		return this.category;
	}
	
	public String getPaidTo()
	{
		return this.paidTo;
	}
	
	public int getAmountDollars()
	{
		return this.amountDollars;
	}
	
	public int getAmountCents()
	{
		return this.amountCents;
	}
	
	public int getAmountRemainingDollars()
	{
		return this.amountRemainingDollars;
	}
	
	public int getAmountRemainingCents()
	{
		return this.amountRemainingCents;
	}
}
