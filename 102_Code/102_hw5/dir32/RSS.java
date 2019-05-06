import java.util.Calendar;

public class RSS
   implements RSSItem
{
   private String title;
   private String link;
   private Calendar date;

   public RSS(String title, String link, Calendar date)
   {
      this.title = title;
      this.link = link;
      this.date = date;
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
