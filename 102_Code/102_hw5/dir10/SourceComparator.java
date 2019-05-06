import java.util.Comparator;

public class SourceComparator implements Comparator<String> {

	@Override
	public int compare(String lft, String rht) {
		return lft.compareTo(rht);
	}

}
