import java.util.Calendar;


public class Item 
	implements RSSItem
{
	private String title;
	private Calendar date;
	private String link;
	
	public Item(String title, Calendar date, String link)
	{
		this.title = title;
		this.date = date;
		this.link = link;
	}

	@Override
	public String getTitle()
	{
		return title;
	}

	@Override
	public Calendar getDate()
	{
		return date;
	}

	@Override
	public String getLink()
	{
		return link;
	}

}
