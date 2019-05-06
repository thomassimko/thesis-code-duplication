import java.util.Comparator;

public class LinkComparator
    implements Comparator<String>
{
    public int compare(String left, String right)
    {
	return left.compareTo(right);
    }
}