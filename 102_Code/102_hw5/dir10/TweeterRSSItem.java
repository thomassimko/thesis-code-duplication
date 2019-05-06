import java.util.Calendar;

public class TweeterRSSItem implements RSSItem {
	private String title, link;
	private Calendar date;
	
	public TweeterRSSItem (String title, Calendar date, String link) {
		this.title = title;
		this.date = date;
		this.link = link;
	}
	
	@Override
	public String getTitle() {
		return title;
	}

	@Override
	public Calendar getDate() {
		return date;
	}

	@Override
	public String getLink() {
		return link;
	}

}
