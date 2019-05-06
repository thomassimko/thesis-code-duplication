import java.text.ParseException;
import java.util.Calendar;

public class Item
  implements RSSItem
{
  private String title;
  private String link;
  private Calendar date;

  public Item( String title, String link, Calendar date )
  {
    this.title = title;
    this.link = link;
    this.date = date;
  }

  public String getTitle()
  {
    return this.title;
  }

  public String getLink()
  {
    return this.link;
  }

  public Calendar getDate()
  {
    return this.date;
  }
}
