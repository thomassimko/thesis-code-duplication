import java.util.Calendar;

public class RSSItemClass implements RSSItem {
	
	private String title,link;
	private Calendar date;
	
	public RSSItemClass(String title, String link, Calendar date){
		this.title=title;
		this.link=link;
		this.date=date;
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
