import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Scanner;
import java.util.List;

public class ExpensesTracker
{
  final static int DISPLAY = 1;
  final static int ADD = 2;
  final static int SORT = 3;
  final static int SAVE = 4;
  final static int QUIT = 5;

  public static void main( String[] args )
  {
    Scanner in = new Scanner(System.in);
    int choice = -1;
    List<Expense> expenses = readIn();

    while( choice != QUIT )
    {
      choice = promptChoices(in);

      switch (choice)
      {
        case DISPLAY:
          displayExpenses( expenses );
          break;
        case ADD:
          expenses = addExpense( expenses, in );
          break;
        case SORT:
          expenses = sortExpenses( expenses, in );
          break;
        case SAVE:
          save( expenses );
          break;
        case QUIT:
          break;
        default:
          System.out.println("Unknown choice");
      }
    }
  }

  private static int promptChoices(Scanner input)
  {
    System.out.println("");
    System.out.println("1. Display");
    System.out.println("2. Add Expense");
    System.out.println("3. Sort");
    System.out.println("4. Save");
    System.out.println("5. Quit");
    System.out.print("\nEnter choice:  ");

    return input.nextInt();
  }

  /* DISPLAY METHODS -----------------------------------------------*/
  public static void displayExpenses( List<Expense> expenses )
  {
    int size = expenses.size();

    System.out.println("");

    if( size == 0 )
    {
      System.out.println("No stored expenses");
      return;
    }

    for( Expense e : expenses )
    {
      System.out.println( e.toString() );
    }
  }

  /* READ IN FROM FILE METHODS ---------------------------------------- */
  public static List<Expense> readIn()
  {
    boolean fileFound = true;
    Scanner in = null;

    try
    {
      in = new Scanner( new File("StoredExpenses.txt") );
    }
    catch(FileNotFoundException e)
    {
      fileFound = false;
    }

    if( fileFound )
    {
      return getExpenses( in );
    }
    else
    {
      System.out.println("File not found");
      return new ArrayList();
    }
  }

  private static List<Expense> getExpenses( Scanner source )
  {
    List<Expense> expenses = new ArrayList();
    boolean success = true;

    while( source.hasNextLine() )
    {
      String type = source.nextLine();
      if( isPartial(type) )
      {
        try
        {
          expenses.add( expenses.size(), new PartialExpense(
            getDate( source.nextLine() ),
            getDescription( source.nextLine() ),
            getPaidTo( source.nextLine() ),
            getAmount( source.nextLine() ),
            getAmount( source.nextLine() ) ));
        }
        catch( Exception e )
        {
          success = false;
        }
      }
      else if( isFull(type) )
      {
        try
        {
          expenses.add( expenses.size(), new FullExpense(
            getDate( source.nextLine() ),
            getDescription( source.nextLine() ),
            getPaidTo( source.nextLine() ),
            getAmount( source.nextLine() ) ));
        }
        catch( Exception e )
        {
          success = false;
        }
      }
    }
    if( !success )
      System.out.println("Not all contents were read from file");
    else
      System.out.println("File loaded");

    return expenses;
  }

  private static boolean isPartial( String type )
  {
    return type.toLowerCase().equals("partial");
  }

  private static boolean isFull( String type )
  {
    return type.toLowerCase().equals("in-full");
  }

  private static Calendar getDate( String unparsed ) throws ParseException
  {
    DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
    Date d = df.parse( unparsed );
    Calendar c = Calendar.getInstance();
    c.setTime(d);

    return c;
  }

  private static String getDescription( String description )
  {
    return description;
  }

  private static String getPaidTo( String to )
  {
    return to;
  }

  private static Payment getAmount( String amount )
  {
    return new Payment( amount );
  }

  /* WRITE TO FILE METHODS ----------------------------------------------- */
  public static void save( List<Expense> expenses )
  {
    print(expenses);

    System.out.println("\nExpensesSaved");
  }

  public static void print( List<Expense> expenses )
  {
    PrintWriter writer = null;

    try
    {
      writer = new PrintWriter("StoredExpenses.txt");
    }
    catch( FileNotFoundException e )
    {
      System.err.println("Unable to save expenses");
      return;
    }

    int size = expenses.size();
    for( int i=0; i<size; i++ )
    {
      Expense cur = expenses.get(i);

      if( !cur.isFull() )
      {
        writer.print( expenseFormatter(cur) );
      }
      else
      {
        writer.print( expenseFormatter(cur) );
      }
    }

    writer.close();
  }

  public static String expenseFormatter( Expense expense )
  { 
    Calendar date = expense.getDate();
    String paidTo = expense.getPaidTo();
    Payment paid = expense.getAmount();
    String description = expense.getDescription();

    if( expense.isFull() )
    {
      return "in-full\n" + String.format("%1$2tm/%<2td/%<tY\n", date) +
        description + "\n" + paidTo + "\n" + paid.toString() + "\n";
    }
    else
    {
      Payment remaining = expense.getRemainingAmount();

      return "Partial\n" + String.format("%1$2tm/%<2td/%<tY\n", date) +
        description + "\n" + paidTo + "\n" + paid.toString() + "\n" +
        remaining.toString() + "\n";
    }
  }

  /* ADDING METHODS ---------------------------------------------------*/
  public static List<Expense> addExpense( List<Expense> expenses, Scanner in )
  {
    expenses.add( 0, promptNewExpense(in) );

    return expenses;
  }

  public static Expense promptNewExpense( Scanner reader )
  {
    boolean isFull = false;
    Calendar date = null;
    String description = null;
    String paidTo = null;
    Payment amount = null;
    Payment remainingAmount = null;

    String trash = reader.nextLine();

    System.out.print("Expense tpye(in-full, partial): ");
    String choice = reader.nextLine();

    if( choice.equals("in-full") )
      isFull = true;
    else if( choice.equals("partial") )
      isFull = false;

    while( date == null )
    {
      System.out.print("Payment date(MM/dd/yyyy): ");

      try
      {
        date = getDate( reader.nextLine() );
      }
      catch( ParseException e )
      {
        System.out.println("Unable to read date, please try again");
      }
    }

    while( amount == null )
    {
      System.out.print("Expense Amount: ");
      amount = getAmount( reader.nextLine() );
    }

    while( paidTo == null )
    {
      System.out.print("Who was this expense paid to? ");
      paidTo = getPaidTo( reader.nextLine() );
    }

    while( description == null )
    {
      System.out.print("Expense Category: ");
      description = getDescription( reader.nextLine() );
    }

    if( !isFull )
    {
      while( remainingAmount == null )
      {
        System.out.print("Expense Balance: ");
        remainingAmount = getAmount( reader.nextLine() );
      }

      return new PartialExpense( date, description, paidTo, amount,
        remainingAmount );
    }
    else
    {
      return new FullExpense( date, description, paidTo, amount );
    }
  }

  /* SORTING METHODS ---------------------------------------------------- */
  public static List<Expense> sortExpenses( List<Expense> expenses, 
    Scanner reader )
  {
    return sort( expenses, promptKeys(reader) );
  }

  public static List<String> promptKeys( Scanner reader )
  {
    List<String> keys = new ArrayList();

    System.out.print("Keys to sort by: ");

    String trash = reader.nextLine();
    Scanner parser = new Scanner( reader.nextLine() );

    for(int i=0; parser.hasNext(); i++ )
    {
      keys.add( i, parser.next() );
    }

    return keys;
  }

  public static List<Expense> sort( List<Expense> expenses, List<String> keys )
  {
    Comparator<Expense> sorter = null;
    int size = keys.size();
    for(int i=size-1; i>=0; i-- )
    {
      sorter = getComparator( keys.get(i), sorter );
    }

    Collections.sort( expenses, sorter );

    return expenses;
  }

  public static Comparator<Expense> getComparator( String sortBy, 
    Comparator<Expense> oldComparator )
  {
    if( sortBy.contains("amount") )
    {
      return new ExpenseAmountComparator( oldComparator );
    }
    else if( sortBy.contains("category") )
    {
      return new ExpenseCategoryComparator( oldComparator );
    }
    else if( sortBy.contains("payee") )
    {
      return new ExpensePayeeComparator( oldComparator );
    }
    else if( sortBy.contains("date") )
    {
      return new ExpenseDateComparator( oldComparator );
    }
    else
    {
      System.out.println("Unknown sort key: " + sortBy);
      return oldComparator;
    }
  }      
}
