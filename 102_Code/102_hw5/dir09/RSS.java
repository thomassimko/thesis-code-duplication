import java.util.*;
import java.text.*;

public class RSS
   implements RSSItem
{
   private String title, link;
   private Date date;
   
   public RSS(String title, Date date, String link)
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
      Calendar c = Calendar.getInstance();
      c.setTime(date);
      return c;  
   }
   
   public String getLink()
   {
      return link;
   }
	
	public String dateToString()
	{
	   DateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm");
		String str = df.format(this.date);
		return str;
	}
	
	public Date getTime()
	{
	   return date;
	}
}

