import java.util.*;
import java.text.*;

public class RSSItems
   implements RSSItem
{
   private String title;
   private Calendar date;
   private String link;

   public RSSItems(String title, Calendar date, String link)
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

   public String calendarToString()
      throws ParseException
   {
      DateFormat newDf = new SimpleDateFormat("MM/dd/yyyy HH:mm");   
      String s = newDf.format(this.date.getTime());

      return s;         
   }
}
