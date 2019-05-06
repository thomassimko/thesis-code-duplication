import java.util.Calendar;

public class RSSItemClass
implements RSSItem
{
	private Calendar date;
	private String link;
	private String title;
	public RSSItemClass(Calendar cal, String links, String titles)
	{
		date = cal;
		link = links;
		title= titles;
	}
	public Calendar getDate()
	{
		return date;
	}
	public String getLink()
	{
		return link;
	}
	public String getTitle()
	{
		return title;
	}
	public String print()
	{
		
		return title + "\n" + "   " + (String.format("%1$2tm/%<2td/%<tY %<tH:%<tM", date)) +"\n" + "   " + link;
	}
}
