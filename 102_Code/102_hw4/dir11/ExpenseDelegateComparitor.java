import java.util.Comparator;


public class ExpenseDelegateComparitor implements Comparator<Expense>
{
	Comparator<Expense> c1;
	Comparator<Expense> c2;
	
	public ExpenseDelegateComparitor(Comparator<Expense> c1, Comparator<Expense> c2)
	{
		this.c1 = c1;
		this.c2 = c2;
	}
	
	@Override
	public int compare(Expense arg0, Expense arg1)
	{
		if(c1.compare(arg0, arg1) == 0)
		{
			return c2.compare(arg0, arg1);
		}
		return c1.compare(arg0, arg1);
	}

}
