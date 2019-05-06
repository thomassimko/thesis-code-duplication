import java.util.Calendar;

public class Tweet implements RSSItem {
	
	String title;
	Calendar date;
	String link;
	
	public Tweet(String title, Calendar date, String link) {
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
