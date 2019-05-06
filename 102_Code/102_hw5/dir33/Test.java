import java.util.*;
import java.text.*;
import javax.xml.xpath.XPathExpressionException;

public class Test
{
   public static void main(String[] args)
   {
      try
      {
         FeedReader feed = new FeedReaderData(); 
         feed.addSource("https://search.twitter.com/search.rss?q=from:keen_csc102");

         feed.addSource("bad");
         List<RSSItem> list = feed.retrieveFeedItems();         
         List<String> bad = feed.getBadSources();

         System.out.println("Bad source: " + bad.get(0) + "\n");
         
         System.out.println("Link " + list.get(0).getLink()); 
         System.out.println("Date " + list.get(0).calendarToString());
         System.out.println("Title " + list.get(0).getTitle());
      }
      catch (ParseException e)
      {
         System.err.println("Parse exception");
      }
   }
}
