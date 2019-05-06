import java.util.Comparator;

public class ExpenseDateComparator
  implements Comparator<Expense>
{
  private Comparator<Expense> nextComparator;
  private boolean hasNextComparator;

  public ExpenseDateComparator( Comparator<Expense> nextComparator )
  {
    this.nextComparator = nextComparator;
    this.hasNextComparator = (nextComparator != null);
  }

  public ExpenseDateComparator()
  {
    this.hasNextComparator = false;
  }

  public int compare( Expense first, Expense second )
  {
    int compareResult;

    if( first.getDate().before(second.getDate()) )
    {
      compareResult = -1;
    }
    else if( second.getDate().before(first.getDate()) )
    {
      compareResult = 1;
    }
    else
    {
      compareResult = 0;
    }

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
