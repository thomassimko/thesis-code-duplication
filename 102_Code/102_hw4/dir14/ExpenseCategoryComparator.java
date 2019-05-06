import java.util.Comparator;


public class ExpenseCategoryComparator 
   implements Comparator<Expense> 
{
	public int compare(Expense left, Expense right)
	{
		return left.getCategory().compareToIgnoreCase(right.getCategory());
	}
}
