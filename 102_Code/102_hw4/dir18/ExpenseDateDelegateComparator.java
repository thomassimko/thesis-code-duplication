import java.util.*;

public class ExpenseDateDelegateComparator
    implements Comparator<Expense>
{
    private Comparator<Expense> comp;
    public ExpenseDateDelegateComparator(Comparator<Expense> c)
    {
	comp = c;
    }
    public int compare(Expense left, Expense right)
    {
	if(left.getDate().compareTo(right.getDate()) == 0){
	    return comp.compare(left, right);
	}
	return (int)(left.getDate().compareTo(right.getDate()));
    }
}