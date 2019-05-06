
public class PayeeComparator
implements java.util.Comparator<Expenses>
{
    public int compare(Expenses left, Expenses right)
    {
    	String leftString=left.getPayee();
    	String rightString=right.getPayee();
    	return leftString.compareTo(rightString);
    }
}
