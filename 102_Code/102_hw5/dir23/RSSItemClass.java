import java.util.Calendar;


public class RSSItemClass implements RSSItem {
	private String title, link;
	private Calendar date;
	
	public RSSItemClass(String title, String link, Calendar date) {
		this.title = title;
		this.link = link;
		this.date = date;
	}

	@Override
	public Calendar getDate() {
		// TODO Auto-generated method stub
		return this.date;
	}

	@Override
	public String getLink() {
		// TODO Auto-generated method stub
		return this.link;
	}

	@Override
	public String getTitle() {
		// TODO Auto-generated method stub
		return this.title;
	}
	
	
}
