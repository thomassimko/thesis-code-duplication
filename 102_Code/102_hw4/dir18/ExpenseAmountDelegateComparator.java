import java.util.*;

public class ExpenseAmountDelegateComparator
    implements Comparator<Expense>
{
    private Comparator<Expense> comp;
    public ExpenseAmountDelegateComparator(Comparator<Expense> c)
    {
	comp = c;
    }
    public int compare(Expense left, Expense right)
    {
	if(left.getAmount() == right.getAmount()){
	    return comp.compare(left, right);
	}
	return left.getAmount() - right.getAmount();
    }
}