import java.util.Calendar;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.text.ParseException; 

public class RSSInstance
	implements RSSItem
{
	String title, link;
	Calendar date;
	public RSSInstance(String title, Calendar date, String link)
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
	public String getDateString()
	{
		try
		{
			DateFormat format = new SimpleDateFormat("EEE MMM dd HH:mm:ss z YYYY");
			DateFormat want = new SimpleDateFormat("MM/dd/YYYY HH:mm");
			Date get = format.parse(this.date.getTime().toString());
			String out = want.format(get);
			return out;
		}
		catch (ParseException e)
		{
		}
		return "";
	}
}