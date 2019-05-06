import java.util.Comparator;


public class ExpensePayeeComparator 
   implements Comparator<Expense> 
{
	public int compare(Expense left, Expense right)
	{
		return left.getPaidTo().compareToIgnoreCase(right.getPaidTo());
	}
}
