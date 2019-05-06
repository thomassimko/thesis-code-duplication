import java.util.Comparator;

public class RSSItemComparator implements Comparator<RSSItem> {

	@Override
	public int compare(RSSItem a, RSSItem b) {
		// TODO Auto-generated method stub
		if (a.getDate().before(b.getDate())) {
			return -1;
		} else if (a.getDate().after(b.getDate())) {
			return 1;
		}
		return 0;
	}

}
