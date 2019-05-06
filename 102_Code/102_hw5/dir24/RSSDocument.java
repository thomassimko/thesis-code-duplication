import java.util.*;

public class RSSDocument
   implements RSSItem
{
   private String title;
   private Calendar date;
   private String link;

   public RSSDocument(String title, Calendar date, String link)
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
}
