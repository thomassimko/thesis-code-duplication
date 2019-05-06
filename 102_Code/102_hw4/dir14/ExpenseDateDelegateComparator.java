import java.util.*;

public class ExpenseDateDelegateComparator 
	implements Comparator<Expense>
{
	Comparator<Expense> comp;
	public ExpenseDateDelegateComparator(Comparator<Expense> comp)
	{
		this.comp = comp;
	}
	
	public int compare(Expense left, Expense right)
	{
		if(left.getDate().compareTo(right.getDate()) == 0)
		{
			return comp.compare(left, right);
		}
		else
		{
			return left.getDate().compareTo(right.getDate());
		}
	}
}
