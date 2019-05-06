import java.util.*;
import java.text.*;
import java.io.*;

public class Feed implements RSSItem
{
   private String title;
   private Calendar date;
   private String link;
   public Feed(String title, Calendar date, String link)
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
   public String calToString()
   {
      DateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm");
      String formatted = df.format(this.date.getTime());
      return formatted;
   }
}