import java.util.*;
import javax.xml.parsers.*;
import javax.xml.xpath.*;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;
import java.io.IOException;
import java.text.*;

public class TwitterFeed implements FeedReader
{
   private List<String> sources;
   private List<String> badSources;
   
   public TwitterFeed()
   {
      sources = new ArrayList<String>();
      badSources = new ArrayList<String>();
   }
   public void addSource(String src)
   {
      this.sources.add(src);
   }
   public List<String> getSources()
   {
      return this.sources;
   }
   public List<RSSItem> retrieveFeedItems()
   {
      List<RSSItem> list = new ArrayList<RSSItem>();
      int size = this.sources.size();
      int badSize = this.badSources.size();
      HashSet<String> hash = new HashSet<String>();
      for(int i = 0; i < size; i++)
      {
         try
         {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document feedDocument = builder.parse(this.sources.get(i));

            XPathFactory xpfactory = XPathFactory.newInstance();
            XPath xpath = xpfactory.newXPath();
            String countStr = xpath.evaluate("count(/rss/channel/item)", feedDocument);
            int itemCount = Integer.parseInt(countStr);
                                                
            for(int j = 1; j <= itemCount; j++)
            {
               String title = xpath.evaluate("/rss/channel/item[" + j + "]/title", feedDocument);
               String link = xpath.evaluate("/rss/channel/item[" + j + "]/link", feedDocument);
               String date = xpath.evaluate("/rss/channel/item[" + j + "]/pubDate", feedDocument);
            
               RSSItem r = new Feed(title, toCalendar(date), link);
               list.add(r);
            }
         }
         catch(ParserConfigurationException p)
         {
            hash.add(this.sources.get(i));
         }
         catch(SAXException s)
         {
            hash.add(this.sources.get(i));
         }
         catch(XPathExpressionException x)
         {
            hash.add(this.sources.get(i));
         }
         catch(IOException io)
         {
            hash.add(this.sources.get(i));
         }
      }
      badSources.clear();
      badSources.addAll(hash);
      return list;
   }
   private Calendar toCalendar(String date)
   {
      Calendar c = null;
      try
      {
         DateFormat df = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss z");
         Date d = df.parse(date);
         
         DateFormat dff = new SimpleDateFormat("MM/dd/yyyy HH:mm");
         String formatted = dff.format(d);
         
         Date da = dff.parse(formatted);
         c = Calendar.getInstance();
         c.setTime(da);
         return c;
      }
      catch(ParseException p)
      {
      }
      return c;
   }
   public List<String> getBadSources()
   {
      return this.badSources;
   }
   public void removeBadSources()
   {
      int badSize = this.badSources.size();
      int sourceSize = this.sources.size();

      for(int i = 0; i < badSize; i++)
      {
         for(int j = 0; j < sourceSize; j++)
         {
            if(sources.get(j).equals(badSources.get(i)))
            {
               sources.remove(j);
               sourceSize--;
            }
         }
      }
   }
}