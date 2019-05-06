import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


public class RSS implements RSSItem 
{
	private String title;
	private Date date;
	private String link;
	
	public RSS(String title, Date date, String link)
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
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		return c;
	}

	@Override
	public String getLink() 
	{
		return link;
	}

	@Override
	public String getStringDate() 
	{
		SimpleDateFormat outFormatter = new SimpleDateFormat("MM/dd/yyyy HH:mm");
		
		Calendar now = Calendar.getInstance();
		now.setTime(date);
		
		String strdate = outFormatter.format(date);
		
		return strdate;
	}

}
