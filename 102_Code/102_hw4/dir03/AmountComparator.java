
public class AmountComparator
implements java.util.Comparator<Expenses>
{
    public int compare(Expenses left, Expenses right)
    {
    	int leftDollars=left.getAmtDollars();
    	int leftCents=left.getAmtCents();
    	int rightDollars=right.getAmtDollars();
    	int rightCents=right.getAmtCents();
    	
        if (leftDollars>rightDollars)
            return 1;
        if (leftDollars<rightDollars)
        	return -1;
        else
        {
        	if(leftCents>rightCents)
        		return 1;
        	if(leftCents<rightCents)
        		return -1;
        	else
        		return 0;
        }
            
    }

}
