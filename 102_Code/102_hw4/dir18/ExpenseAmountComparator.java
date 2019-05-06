import java.util.*;

public class ExpenseAmountComparator
    implements Comparator<Expense>
{
    public int compare(Expense left, Expense right)
    {
	return left.getAmount() - right.getAmount();
    }
}