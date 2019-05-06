import java.util.Calendar;
import java.util.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
public class TwitRSSItem
  implements RSSItem
{
  private String title;
  private String calStr;
  private String link;
  private static final DateFormat df = new SimpleDateFormat("EEE, d MMM yyyy HH:mm:ss Z");
  public TwitRSSItem(String title, String calStr, String link)
  {
    this.title = title;
    this.calStr = calStr;
    this.link = link;
  }
  public String getTitle()
  {
    return this.title;
  }
  public Calendar getDate()
  {
    try
    { 
      Date d = df.parse(this.calStr);
      Calendar cal = Calendar.getInstance();
      cal.setTime(d);
      return cal;
    }
    catch(ParseException PE)
    {
      return null;
    }
  }
  public String getLink()
  {
    return this.link;
  }
}
