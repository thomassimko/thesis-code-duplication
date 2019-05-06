import java.util.Comparator;

public class ExpenseAmountComparator
  implements Comparator<Expense>
{
  private Comparator<Expense> nextComparator;
  private boolean hasNextComparator;

  public ExpenseAmountComparator()
  {
    this.hasNextComparator = false;
  }

  public ExpenseAmountComparator( Comparator<Expense> nextComparator )
  {
    this.nextComparator = nextComparator;
    this.hasNextComparator = (nextComparator != null);
  }

  public int compare( Expense first, Expense second )
  {
    int compareResult =  first.getAmount().toCents() - 
      second.getAmount().toCents();

    if( compareResult == 0 && hasNextComparator )
    {
      return nextComparator.compare( first, second );
    }
    else
    {
      return compareResult;
    }    
  }
}
