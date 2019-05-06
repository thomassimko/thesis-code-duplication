import java.util.Comparator;


public class RSSItemComparator implements Comparator<RSSItem> {

	@Override
	public int compare(RSSItem o1, RSSItem o2) {
		return o2.getDate().compareTo(o1.getDate());
	}

}
