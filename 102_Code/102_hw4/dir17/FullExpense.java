import java.util.Calendar;

public class FullExpense
 extends AbstractExpense
{
  public FullExpense(Calendar date, String category, String paidTo,
    Payment amount)
  {
    super( date, category, paidTo, amount );
  }

  public boolean isFull()
  {
    return true;
  }

  public Payment getRemainingAmount()
  {
    throw new UnsupportedOperationException();
  }

  public String toString()
  {
    return String.format("%1$2tm/%<2td/%<tY ", getDate() ) + 
      String.format("%-15.15s %10s [%s]", getPaidTo(), 
      getAmount().toString(), getDescription() );
  }
}
