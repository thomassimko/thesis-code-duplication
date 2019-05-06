import java.util.*;

public class ExpenseCategoryDelegateComparator 
	implements Comparator<Expense>
{
	private Comparator<Expense> comp;
	public ExpenseCategoryDelegateComparator(Comparator<Expense> comp)
	{
		this.comp = comp;
	}
	
	public int compare(Expense left, Expense right)
	{
		if(left.getPaidTo().compareToIgnoreCase(right.getPaidTo()) == 0)
		{
			return comp.compare(left, right);
		}
		else
		{
			return left.getPaidTo().compareToIgnoreCase(right.getPaidTo());
		}
	}
}
