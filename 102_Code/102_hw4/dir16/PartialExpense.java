import java.util.*;

public class PartialExpense
	extends Expense
{
	public PartialExpense(Calendar date, String category, String payee, Amount paid, Amount remaining)
	{
		super("partial", date, category, payee, paid, remaining);
	}

	public String toString()
	{
		return super.getDateString() + String.format("%-15.15s %s (%s) [%s]",
			super.getPayee(), super.getPaidString(), super.getRemainingString(), super.getCategory());
	}
}