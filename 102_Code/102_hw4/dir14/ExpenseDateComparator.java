import java.util.Comparator;


public class ExpenseDateComparator 
   implements Comparator<Expense> 
{
	public int compare(Expense left, Expense right)
	{
		return left.getDate().compareTo(right.getDate());
	}
}
