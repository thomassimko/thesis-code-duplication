import java.util.Comparator;

public class ExpenseCategoryComparator
  implements Comparator<Expense>
{
  private Comparator<Expense> nextComparator;
  private boolean hasNextComparator;

  public ExpenseCategoryComparator()
  {
    this.hasNextComparator = false;
  }

  public ExpenseCategoryComparator( Comparator<Expense> nextComparator )
  {
    this.nextComparator = nextComparator;
    this.hasNextComparator = (nextComparator != null);
  }

  public int compare( Expense first, Expense second )
  {
    int compareResult = first.getDescription().compareTo( 
      second.getDescription() );

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
