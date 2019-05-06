import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;

public class Sources
   implements FeedReader
{
   private List<String> sources = new ArrayList<String>();
   private List<String> badSources = new ArrayList<String>();
   
   public void addSource(String src)
   {
      this.sources.add(src);
   }

   public List<String> getSources()
   {
      Collections.sort(this.sources, String.CASE_INSENSITIVE_ORDER);
      return this.sources;
   }

   public List<RSSItem> retrieveFeedItems()
   {
      List<RSSItem> rssItems = new ArrayList<RSSItem>();
      
      DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
      DocumentBuilder builder = null;
      try
      {
         builder = factory.newDocumentBuilder();
      }
      catch (ParserConfigurationException e)
      {
         System.err.println("Error Reading Document");
      }
      for(String src : sources)
      {
         try
         {
            Document feedDocument = builder.parse(src);
            XPathFactory xpfactory = XPathFactory.newInstance();
            XPath xpath = xpfactory.newXPath();
            String countStr = xpath.evaluate("count(/rss/channel/item)", feedDocument);
            int itemCount = Integer.parseInt(countStr);
            for(int i = 1; i <= itemCount; i++)
            {
               String title = xpath.evaluate("/rss/channel/item[" + i + "]/title", feedDocument);
               String link = xpath.evaluate("/rss/channel/item[" + i + "]/link", feedDocument);
               String dateString = xpath.evaluate("/rss/channel/item[" + i + "]/pubDate", feedDocument);
               SimpleDateFormat df = new SimpleDateFormat("EEE, d MMM yyyy HH:mm:ss Z");
               Date date = df.parse(dateString);
               Calendar pubDate = Calendar.getInstance();
               pubDate.setTime(date);
               rssItems.add(new Status(title, link, pubDate));
            }
         }
         catch(Exception e)
         {
            if(!(this.badSources.contains(src)))
            {
               this.badSources.add(src);
            }
         }
      }
      Collections.sort(rssItems, new RSSItemDateComparator());
      return rssItems;
   }

   public List<String> getBadSources()
   {
      Collections.sort(this.badSources, String.CASE_INSENSITIVE_ORDER);
      return this.badSources;
   }

   public void removeBadSources()
   {
      for(String badSource : this.badSources)
      {
         sources.remove(badSource);
      }
      this.badSources.clear();
   }
}