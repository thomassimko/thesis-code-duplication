import java.util.Comparator;


public class ExpenseAmountDelegateComparator 
	implements Comparator<Expense> 
{
	private Comparator<Expense> comp;

	public ExpenseAmountDelegateComparator(Comparator<Expense> comp)
	{
		this.comp = comp;
	}
	@Override
	public int compare(Expense amt1, Expense amt2) 
	{
		/*int dollar1 = ((amt1.getDollar())*100)+amt1.getCent();
		int dollar2 = ((amt2.getDollar())*100)+amt2.getCent();*/
		

		if(amt1.paidToString().compareTo(amt2.paidToString()) == 0)
		{
			return comp.compare(amt1, amt2);
		}
		else
		{
			return amt1.paidToString().compareTo(amt2.paidToString());
		}
	}

}
