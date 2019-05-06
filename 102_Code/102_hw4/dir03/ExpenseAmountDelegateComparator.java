import java.util.Comparator;


public class ExpenseAmountDelegateComparator 
implements Comparator<Expenses>
{
	Comparator<Expenses> primary;
	public ExpenseAmountDelegateComparator(Comparator<Expenses> primary)
	{
		this.primary=primary;
	}
	
	public int compare(Expenses left, Expenses right)
    {
		int i;
    	int leftDollars=left.getAmtDollars();
    	int leftCents=left.getAmtCents();
    	int rightDollars=right.getAmtDollars();
    	int rightCents=right.getAmtCents();
    	
        if (leftDollars>rightDollars)
            i=1;
        if (leftDollars<rightDollars)
        	i=-1;
        else
        {
        	if(leftCents>rightCents)
        		i=1;
        	if(leftCents<rightCents)
        		i=-1;
        	else
        		return primary.compare(left, right);
        }
        return i;
            
    }
}
