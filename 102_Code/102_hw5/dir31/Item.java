import java.util.Calendar;
import java.util.Date;


public class Item 
		implements RSSItem
{
	
	Calendar date;
	String link;
	String title;
	
	public Item(String title, String link, Date d)
	{
		this.title = title;
		this.link = link;
		date = Calendar.getInstance();
		date.setTime(d);
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
		return this.link;
	}

}
