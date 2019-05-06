import java.util.Comparator;


public class ExpenseAmountComparator 
   implements Comparator<Expense> 
{
	public int compare(Expense left, Expense right)
	{
		int leftAmount = (left.getDollars()*100) + left.getCents();
		int rightAmount = (right.getDollars()*100) + right.getCents();
		return leftAmount - rightAmount;
	}
}
