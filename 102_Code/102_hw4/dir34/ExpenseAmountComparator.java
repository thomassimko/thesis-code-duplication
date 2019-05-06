import java.util.Comparator;

public class ExpenseAmountComparator<T>
implements Comparator
{

	public int compare(Object o1, Object o2)
	{
		int i= ((Expenses)o1).getDollars();
		int k= ((Expenses)o1).getCents();
		double amount1 = i + k /100;
		
		int j= ((Expenses)o2).getDollars();
		int l= ((Expenses)o2).getCents();
		double amount2 = j + l /100;
		
		if(amount1 < amount2)
		{
			return -1;
		}
		if(amount1 > amount2)
		{
			return 1;
		}
		
		return 0;
	}
}
