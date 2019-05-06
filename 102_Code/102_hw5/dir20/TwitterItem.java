import java.util.Calendar;

public class TwitterItem
   implements RSSItem
{
   private String title;
	private Calendar cal = Calendar.getInstance();
	private String link;

   public TwitterItem(String title, Calendar cal, String link)
	{
	   this.title = title;
		this.link = link;
		this.cal = cal;
	}

   public String getTitle()
	{
	   return this.title;
	}
   public Calendar getDate()
	{
	   return this.cal;
	}
   public String getLink()
	{
	  return this.link;
	}
}