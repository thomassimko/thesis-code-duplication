import java.util.*;

public class ExpensePayeeComparator
    implements Comparator<Expense>
{
    public int compare(Expense left, Expense right)
    {
	return left.getPayee().compareToIgnoreCase(right.getPayee());
    }
}