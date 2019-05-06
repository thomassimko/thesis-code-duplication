import java.util.*;

public class InFullExpense
	extends Expense
{
	public InFullExpense(Calendar date, String category, String payee, Amount paid)
	{
		super("in-full", date, category, payee, paid, new Amount(0, 0));
	}

	public String toString()
	{
		return super.getDateString() + String.format("%-15.15s %s [%s]",
			super.getPayee(), super.getPaidString(), super.getCategory());
	}
}