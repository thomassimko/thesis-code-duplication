import java.util.Calendar;

public class Status
   implements RSSItem
{
   private String title, link;
   private Calendar pubDate;
   
   public Status(String title, String link, Calendar pubDate)
   {
      this.title = title;
      this.link = link;
      this.pubDate = pubDate;
   }
   
   public String getTitle()
   {
      return this.title;
   }

   public Calendar getDate()
   {
      return this.pubDate;
   }

   public String getLink()
   {
      return this.link;
   }
}