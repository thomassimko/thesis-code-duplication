import java.util.Comparator;
import java.util.Date;


public class ExpenseDateDelegateComparator implements Comparator<Expenses> {
	Comparator<Expenses> next;
	public ExpenseDateDelegateComparator(Comparator<Expenses> next)
	{
		this.next = next;
	}
	@Override
	public int compare(Expenses e1, Expenses e2) {
		// TODO Auto-generated method stub
	   Date o1 = e1.getDate();
	   Date o2 = e2.getDate();
	   int comparisonResult = o1.compareTo(o2);
	   if ( comparisonResult > 0)
	   {
		   return 1;
	   }
	   if ( comparisonResult < 0)
	   {
		   return -1;
	   }
	   return next.compare(e1, e2);
	   
	}
}
