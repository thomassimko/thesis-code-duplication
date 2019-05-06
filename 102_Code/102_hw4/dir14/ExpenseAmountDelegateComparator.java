import java.util.*;

public class ExpenseAmountDelegateComparator 
	implements Comparator<Expense>
{
	Comparator<Expense> comp;
	public ExpenseAmountDelegateComparator(Comparator<Expense> comp)
	{
		this.comp = comp;
	}
	
	public int compare(Expense left, Expense right)
	{
		int leftAmount = (left.getDollars()*100) + left.getCents();
		int rightAmount = (right.getDollars()*100) + right.getCents();
		
		if(leftAmount == rightAmount)
		{
			return comp.compare(left, right);
		}
		else
		{
			return leftAmount - rightAmount;
		}
	}
}
