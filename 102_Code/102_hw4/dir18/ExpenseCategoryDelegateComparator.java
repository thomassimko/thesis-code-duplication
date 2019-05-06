import java.util.*;

public class ExpenseCategoryDelegateComparator
    implements Comparator<Expense>
{
    private Comparator<Expense> comp;
    public ExpenseCategoryDelegateComparator(Comparator<Expense> c)
    {
	comp = c;
    }
    public int compare(Expense left, Expense right)
    {
	if(left.getDescription().equals(right.getDescription())){
	    return comp.compare(left, right);
	}
	return left.getDescription().compareToIgnoreCase(right.getDescription());
    }
}