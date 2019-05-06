import java.util.Calendar;

public class RSSItemParser implements RSSItem {
	String title, link;
	Calendar date;
	
	public RSSItemParser(String title, String link, Calendar date) {
		this.title = title;
		this.link = link;
		this.date = date;
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
