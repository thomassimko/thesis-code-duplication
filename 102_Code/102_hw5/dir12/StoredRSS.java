import java.util.Calendar;


public class StoredRSS implements RSSItem {
	private String title;
	private Calendar date;
	private String link;

	public StoredRSS(String t, Calendar d, String l){
		title = t;
		date = d;
		link = l;
	}

	public String getTitle() {

		return title;
	}

	public Calendar getDate() {

		return date;
	}

	public String getLink() {
		
		return link;
	}

}
