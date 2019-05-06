import java.util.List;
import java.util.Comparator;

public class StringComparator<T>
implements Comparator
{
	public int compare(Object lft, Object rgt)
	{
		return ((String)lft).compareTo(((String)rgt));
	}
}
