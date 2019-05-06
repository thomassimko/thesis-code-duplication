
public class CategoryComparator 
implements java.util.Comparator<Expenses>
{
    public int compare(Expenses left, Expenses right)
    {
    	String leftString=left.getCategory();
    	String rightString=right.getCategory();
    	return leftString.compareTo(rightString);
    }
}
