import java.util.Comparator;

public class SourceComparator<T> implements Comparator<String> {

	public int compare(String o1, String o2) {
		int comp = 0;
		comp = o1.compareTo(o2);
		return comp;
	}
}
