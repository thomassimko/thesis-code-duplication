import java.util.Comparator;

public class SourceComparator
    implements Comparator<String>
{
    public int compare(String left, String right)
    {
	return left.compareTo(right);
    }
}