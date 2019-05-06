import java.util.Calendar;

public class PartialExpense
  extends AbstractExpense
{
  public PartialExpense(Calendar date, String category, String paidTo,
    Payment amount, Payment remainingAmount)
  {
    super( date, category, paidTo, amount, remainingAmount );
  }

  public boolean isFull()
  {
    return false;
  }

  public String toString()
  {
    return String.format("%1$2tm/%<2td/%<tY ", getDate() ) + 
      String.format("%-15.15s %10s (%s) [%s]", getPaidTo(), 
      getAmount().toString(), getRemainingAmount().toString(), 
      getDescription());
  }
}
