import java.util.Comparator;


public class RSSItemComparator implements Comparator<RSSItem> {

	@Override
	public int compare(RSSItem item1, RSSItem item2) {
		if(item1.getDate().before(item2.getDate())){
			return 1;
		}else if(item1.getDate().after(item2.getDate())){
			return -1;
		}
		return 0;
	}

}
