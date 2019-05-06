import java.util.Calendar;


public class RSSinfo implements RSSItem 
{
	String title, link;
	Calendar date;
	
	public RSSinfo(String title, Calendar date, String link)
	{
		this.title=title;
		this.date=date;
		this.link=link;
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
