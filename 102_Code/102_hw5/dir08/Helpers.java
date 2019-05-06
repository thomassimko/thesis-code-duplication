import java.util.*;
import org.w3c.dom.*;
import java.text.*;
import javax.xml.xpath.*;

public class Helpers
{
   public static Calendar convertToDate(String s) throws Exception
   {
      Calendar c = Calendar.getInstance();
      
      DateFormat df = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss Z");
      Date d = df.parse(s);
      c.setTime(d);
      
      return c;
   }
   
   public static String dateToString(Calendar c)
   {
      return String.format("%1$tm/%<td/%<tY %<tH:%<tM", c);
   }
   
   public static void addRSSItems(List<RSSItem> list, Document d) throws Exception
   {
      XPathFactory xpfactory = XPathFactory.newInstance(); 
      XPath xpath = xpfactory.newXPath();
      
      String countStr = xpath.evaluate("count(/rss/channel/item)", d); 
      int itemCount = Integer.parseInt(countStr);
      
      for (int i = 1; i <= itemCount; i++)
      {
         String title = xpath.evaluate("/rss/channel/item[" + i + "]/title", d);
         String link = xpath.evaluate("/rss/channel/item[" + i + "]/link", d);
         String date = xpath.evaluate("/rss/channel/item[" + i + "]/pubDate", d);
         Calendar c = convertToDate(date);
         
         list.add(new Item(title, link, c));
      }
   }
}
