import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class RSSItemClass 
   implements RSSItem 
{
	private String title;
	private String link;
	private Date date;
	
	public RSSItemClass(String title, String link, Date date)
	{
		this.title = title;
		this.link = link;
		this.date = date;
	}
	
	public String getTitle() 
	{
		return title;
	}

	public Calendar getDate() 
	{
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		return calendar;
	}
	
	public String getStringDate()
	{
		DateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm");
		String string = df.format(this.date);
		return string;
	}

	public String getLink() 
	{
		return link;
	}
}
