import java.util.*;

public class Item
   implements RSSItem
{
   private String title, link;
   Calendar cal;
   
   public Item(String t, String l, Calendar c)
   {
      this.title = t;
      this.link = l;
      this.cal = c;
   }
   
   public String getTitle()
   {
      return title;
   }
   
   public String getLink()
   {
      return link;
   }
   
   public Calendar getDate()
   {
      return cal;
   }

   public String toString()
   {
      return title + "\n   " +
             Helpers.dateToString(cal) + "\n   " +
             link + "\n\n";
   }
}
