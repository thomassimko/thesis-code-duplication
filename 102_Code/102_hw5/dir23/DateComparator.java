import java.util.Comparator;


public class DateComparator implements Comparator<RSSItem> {

	@Override
	public int compare(RSSItem arg0, RSSItem arg1) {
		// TODO Auto-generated method stub
		return arg0.getDate().compareTo(arg1.getDate());
	}

}
