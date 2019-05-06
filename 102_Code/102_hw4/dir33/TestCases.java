import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.text.SimpleDateFormat;
import java.text.DateFormat;
import java.util.Date;
import java.util.Calendar;
import java.text.ParseException;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class TestCases
{
   public static void main(String[] args)
   {
      Calendar date = dateReader("8/21/1992");
      Calendar date2 = dateReader("8/23/1992");

      Expense exp = new InFull(date, "Food", "Starbucks", new Amount(6, 55));
      Expense exp2 = new InFull(date2, "Dog", "Petco", new Amount(6, 55));
      Expense exp3 = new InFull(date, "Food", "TacoBell", new Amount(2, 01));
      Expense exp4 = new InFull(date2, "Food", "Starbucks", new Amount(6, 45));
      Expense exp5 = new InFull(date2, "Food", "Starbucks", new Amount(6, 45));

      ExpenseAmountComparator compAmount = new ExpenseAmountComparator();
      ExpenseCategoryComparator compCategory = new ExpenseCategoryComparator();
      ExpenseDateComparator compDate = new ExpenseDateComparator();
      ExpensePayeeComparator compPayee = new ExpensePayeeComparator();

      Check.check(compAmount.compare(exp, exp2) == 0, true);
      Check.check(compAmount.compare(exp, exp3) > 0, true);
      Check.check(compAmount.compare(exp4, exp2) < 0, true);

      Check.check(compCategory.compare(exp, exp4) == 0, true);
      Check.check(compCategory.compare(exp, exp2) > 0, true);
      Check.check(compCategory.compare(exp3, exp2) > 0, true);

      Check.check(compDate.compare(exp, exp3) == 0, true);
      Check.check(compDate.compare(exp, exp2) < 0, true);
      Check.check(compDate.compare(exp2, exp) > 0, true);

      Check.check(compPayee.compare(exp, exp4) == 0, true);
      Check.check(compPayee.compare(exp, exp2) > 0, true);
      Check.check(compPayee.compare(exp3, exp4) > 0, true);

      ExpenseDelegateComparator comp5 = new ExpenseDelegateComparator(compAmount, compCategory);
      ExpenseDelegateComparator comp6 = new ExpenseDelegateComparator(compDate, comp5);
      ExpenseDelegateComparator comp7 = new ExpenseDelegateComparator(comp5, comp6);

      Check.check(comp5.compare(exp, exp3) > 0, true);
      Check.check(comp5.compare(exp, exp2) > 0, true);
      Check.check(comp5.compare(exp4, exp5) == 0, true);

      Check.check(comp6.compare(exp, exp3) > 0, true);
      Check.check(comp6.compare(exp, exp2) < 0, true);
      Check.check(comp6.compare(exp4, exp5) == 0, true);

      Check.check(comp7.compare(exp, exp2) > 0, true);
      Check.check(comp7.compare(exp, exp2) > 0, true);
      Check.check(comp7.compare(exp4, exp5) == 0, true);

      Amount money = new Amount(50, 6);
      Amount money2 = new Amount(00, 5);

      Check.check(money.toString(), "6.50");
      Check.check(money2.toString(), "5.00");
  }

   public static Calendar dateReader(String date)
   {
      try
      {
         DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
         Date d = df.parse(date);
         Calendar c = Calendar.getInstance();
         c.setTime(d);

         return c;
      }
      catch (ParseException e)
      {
         System.out.println("Parse exception!");         
      }
   
      return null;
   }
}
