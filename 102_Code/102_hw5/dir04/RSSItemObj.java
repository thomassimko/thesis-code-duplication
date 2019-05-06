import java.util.Calendar;

public class RSSItemObj 
	implements RSSItem
{
	private String title;
	private Calendar date;
	private String link;
	
	public RSSItemObj(String title, Calendar date, String link)
	{
		this.title = title;
		this.date = date;
		this.link = link;
	}
	
	public String getTitle() 
	{
		return this.title;
	}

	public Calendar getDate() 
	{
		return this.date;
	}

	public String getLink() 
	{
		return this.link;
	}
	
	public String strDate()
	{	
		String s = String.format("%1$tm/%1$td/%1$tY %1$tI:%1$tM", date);
		return s;		
	}

}
