import java.util.Calendar;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.Date;

public class RSSObject
	implements RSSItem
{
	private String title;
	private Calendar date;
	private String link;

	public RSSObject(String title, Calendar date, String link)
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

	public String dateString()
		throws ParseException
	{
		String s;
		SimpleDateFormat form = new SimpleDateFormat("MM/dd/yyyy HH:mm");
		if (date != null)
		{
			s = form.format(date.getTime());
			return s;
		}
		return null;
	}
}
