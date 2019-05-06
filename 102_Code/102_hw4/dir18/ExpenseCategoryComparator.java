import java.util.*;

public class ExpenseCategoryComparator
    implements Comparator<Expense>
{
    public int compare(Expense left, Expense right)
    {
	return left.getDescription().compareToIgnoreCase(right.getDescription());
    }
}