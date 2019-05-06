import java.util.*;
import javax.xml.parsers.*;
import javax.xml.xpath.*;
import org.w3c.dom.*;
import java.text.*;
import org.xml.sax.*;
import java.io.*;

public class Feed
   implements FeedReader
{
   private List<String> sources;
   private List<String> badSources;
   
   public Feed()
   {
      sources = new ArrayList<String>();
		badSources = new ArrayList<String>();
   }
      
   public void addSource(String src)
   {
      sources.add(src);
   }
   
   public List<String> getSources()
   {
      return sources;
   }
   
   public List<RSSItem> retrieveFeedItems()
   {
      int i = 0, size = sources.size();
      List<RSSItem> feedItems = new ArrayList<RSSItem>();
      try
      {
         DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
         DocumentBuilder builder = factory.newDocumentBuilder();

         for(;i<size;i++)
         {
            Document feedDocument = builder.parse(sources.get(i));
            XPathFactory xpfactory = XPathFactory.newInstance();
            XPath xpath = xpfactory.newXPath();

            String countStr = xpath.evaluate("count(/rss/channel/item)", feedDocument);
            int itemCount = Integer.parseInt(countStr);

            for(int j=1;j<=itemCount;j++)
            {
               String title = xpath.evaluate("/rss/channel/item[" + j + "]/title", feedDocument);
               String link = xpath.evaluate("/rss/channel/item[" + j + "]/link", feedDocument);
               String date = xpath.evaluate("/rss/channel/item[" + j + "]/pubDate", feedDocument);
               Date d = parseDate(date);
               feedItems.add(new RSS(title, d, link));
            }
         }
      }
      catch(XPathExpressionException e)
      {
         badSources.add(sources.get(i));
      }
      catch(ParseException e)
      {
         badSources.add(sources.get(i));
      }
      catch(ParserConfigurationException e)
      {
         System.out.println("Error creating DocumentBuilder.");
      }
      catch(SAXException e)
      {
         badSources.add(sources.get(i));
      }
      catch(IOException e)
      {
         badSources.add(sources.get(i));
      }
      return feedItems;
   }
   
   public List<String> getBadSources()
   {
      return badSources;
   }
   
   public void removeBadSources()
   {
      int size1 = badSources.size();

      for(int i=0;i<size1;i++)
      {
         int size2 = sources.size();
         for(int j=0;j<size2;j++)
         {
            if(badSources.get(i).equals(sources.get(j)))
            {
               sources.remove(j);
               break;
            }
         }
      }
      badSources.removeAll(badSources);
   }
   
   private Date parseDate(String date) throws ParseException
   {
      DateFormat df = new SimpleDateFormat("EEE, d MMM yyyy HH:mm:ss Z");
      Date d = df.parse(date);
      Calendar c = Calendar.getInstance();
      c.setTime(d);
      return d;
   }   
}
