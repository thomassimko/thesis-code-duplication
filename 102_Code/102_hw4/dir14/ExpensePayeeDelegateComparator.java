import java.util.*;

public class ExpensePayeeDelegateComparator 
	implements Comparator<Expense>
{
	private Comparator<Expense> comp;
	public ExpensePayeeDelegateComparator(Comparator<Expense> comp)
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
