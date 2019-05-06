import java.util.*;

public class ExpensePayeeDelegateComparator
    implements Comparator<Expense>
{
    private Comparator<Expense> comp;
    public ExpensePayeeDelegateComparator(Comparator<Expense> c)
    {
	comp = c;
    }
    public int compare(Expense left, Expense right)
    {
	if(left.getPayee().equals(right.getPayee())){
	    return comp.compare(left, right);
	}
	return left.getPayee().compareToIgnoreCase(right.getPayee());
    }
}