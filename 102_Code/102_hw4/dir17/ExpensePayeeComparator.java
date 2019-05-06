import java.util.Comparator;

public class ExpensePayeeComparator
  implements Comparator<Expense>
{
  private Comparator<Expense> nextComparator;
  private boolean hasNextComparator;

  public ExpensePayeeComparator()
  {
    this.hasNextComparator = false;
  }

  public ExpensePayeeComparator( Comparator<Expense> nextComparator )
  {
    this.nextComparator = nextComparator;
    this.hasNextComparator = (nextComparator != null);
  }

  public int compare( Expense first, Expense second )
  {
    int compareResult = second.getPaidTo().compareTo( first.getPaidTo() );

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
