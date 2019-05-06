import java.util.*;

public class Tweet
	implements RSSItem
{
	private String title;
	private Calendar date;
	private String link;

	public Tweet(String title, Calendar date, String link)
	{
		this.title = title;
		this.date = date;
		this.link = link;
	}

	public String getTitle()
	{
		return title;
	}

	public Calendar getDate()
	{
		return date;
	}

	public String getLink()
	{
		return link;
	}
}