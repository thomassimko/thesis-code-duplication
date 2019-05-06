import java.io.FileNotFoundException;
import java.io.File;
import java.text.ParseException;
import java.util.Date;
import java.util.Calendar;
import java.text.SimpleDateFormat;
import java.text.DateFormat;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.ArrayList;
public class test
{
	public static void main(String [] args)
	{
		Calendar date = dateRead("06/22/1993");
		Money money = new Money(10,10);
		String paidTo = "bob";
		String desc = "bob";
		
		Calendar date2 = dateRead("06/22/1993");
		Money money2 = new Money(10,10);
		String paidTo2 = "bob";
		String desc2 = "bo";
		
		Expense exp = new Infull(date,money,paidTo,desc);
		Expense exp2 = new Infull(date2,money2,paidTo2,desc2);

		ExpenseAmountComparator comp = new ExpenseAmountComparator();
		ExpenseDateComparator comp2 = new ExpenseDateComparator();
		ExpensePayeeComparator comp4 = new ExpensePayeeComparator();
		ExpenseCategoryComparator comp3 = new ExpenseCategoryComparator();

		ExpenseDelegateComparator del2 = new ExpenseDelegateComparator(comp2,comp3);
		ExpenseDelegateComparator del1 = new ExpenseDelegateComparator(comp,comp3);
		int x = del1.compare(exp,exp2);
		System.out.println(x);
	}
	public static Calendar dateRead(String s)
	{
		try
		{
			DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
			Date d = df.parse(s);
			Calendar c = Calendar.getInstance();
			c.setTime(d);
			return c;
		}
		catch (ParseException e)
		{
			System.out.println("Error while parsing");
		}
		return null;
	}
}
