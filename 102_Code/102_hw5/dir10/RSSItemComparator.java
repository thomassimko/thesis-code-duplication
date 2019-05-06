import java.util.Comparator;

public class RSSItemComparator implements Comparator<RSSItem> {

	@Override
	public int compare(RSSItem lft, RSSItem rht) {
		return rht.getDate().compareTo(lft.getDate());
	}

}
