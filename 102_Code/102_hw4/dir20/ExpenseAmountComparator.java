import java.util.Comparator;

import java.util.Date;
import java.util.Calendar;
import java.text.SimpleDateFormat;
import java.text.DateFormat;
import java.text.ParseException;

public class ExpenseAmountComparator
  implements Comparator<Expenses>
  {
     public int compare(Expenses left, Expenses right)
     {
         MoneyConverter conLeft = new MoneyConverter( left.getAmountPaid());        
         int icents = conLeft.getCents();
         int idollars = conLeft.getDollars();
               
         MoneyConverter conRight = new MoneyConverter( right.getAmountPaid());
			int rcents = conRight.getCents();
         int rdollars = conRight.getDollars();
		  
         return (idollars *100 + icents) - (rdollars * 100 + rcents);
     }
  }