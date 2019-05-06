import java.util.Calendar;


public class RSS implements RSSItem
{
	String title;
	Calendar date;
	String link;

	public RSS(String title, Calendar date, String link)
	{
		this.title = title;
		this.date = date;
		this.link = link;
	}

	@Override
	public String getTitle()
	{
		return this.title;
	}

	@Override
	public Calendar getDate()
	{
		return this.date;
	}

	@Override
	public String getLink()
	{
		return this.link;
	}

}
