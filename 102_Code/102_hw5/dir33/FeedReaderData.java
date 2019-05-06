import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathFactory;
import java.util.*;
import java.text.*;
import javax.xml.xpath.XPathExpressionException;
import org.xml.sax.SAXException;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class FeedReaderData
   implements FeedReader
{
   private List<String> list;
   private List<String> badSources;
   private List<RSSItem> RSSItemList;

   public FeedReaderData()
   {
      this.list = new ArrayList<String>();
      this.badSources = new ArrayList<String>();
      this.RSSItemList = new ArrayList<RSSItem>();
   }

   /**
      Adds a new source to the list of sources from which feeds are
      retrieved.
      @param: src The URL of the source.
   */
   public void addSource(String src)
   {
      if (!src.equals(""))
      {
         list.add(src);
      }
   }

   /**
      Returns the list of sources that this reader is working with.
   */
   public List<String> getSources()
   {
      return this.list;
   }

   /**
      Returns a list of feed items pulled from the current list of sources.
   */
   public List<RSSItem> retrieveFeedItems()
   {
      int j = 0;
      int size = list.size();

      badSources.clear();

      try
      {
         DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
         DocumentBuilder builder = factory.newDocumentBuilder();

         XPathFactory xpfactory = XPathFactory.newInstance();
         XPath xpath = xpfactory.newXPath();

         for (j = 0; j < size; j++)
         {
            try
            {
               Document feedDocument = builder.parse(list.get(j));

               int numItems = numItems(feedDocument, xpath);

               for (int i = 1; i <= numItems; i++)
               {
                  String title = xpath.evaluate("/rss/channel/item[" + i + "]/title", feedDocument);
                  String link = xpath.evaluate("/rss/channel/item[" + i + "]/link", feedDocument);
                  String date = xpath.evaluate("/rss/channel/item[" + i + "]/pubDate", feedDocument);
                  
                  RSSItemList.add(new RSSItems(title, dateReader(date), link));
               }
            }
            catch (ParseException e)
            {
               badSources.add(list.get(j));
            }
            catch (IOException e)
            {
               badSources.add(list.get(j));
            }
         }

      }
      catch (ParserConfigurationException e)
      {
         badSources.add(list.get(j));
      } 
      catch (SAXException e)
      {
         badSources.add(list.get(j)); 
      }
      catch (XPathExpressionException e)
      {
         badSources.add(list.get(j));
      }
      catch (NullPointerException e)
      {
         badSources.add(list.get(j));
      }

      return RSSItemList;
   }

   public static Calendar dateReader(String date)
      throws ParseException
   {
      DateFormat df = new SimpleDateFormat("EEE, d MMM yyyy HH:mm:ss Z");
      DateFormat newDf = new SimpleDateFormat("MM/dd/yyyy HH:mm");

      Date d = df.parse(date);
      String newDate = newDf.format(d);
      Date newD = newDf.parse(newDate);

      Calendar c = Calendar.getInstance();
      c.setTime(newD);

      return c;
   }

   private static int numItems(Document feedDocument, XPath xpath)
      throws XPathExpressionException
   {
      String countStr = xpath.evaluate("count(/rss/channel/item)", feedDocument);
      int itemCount = Integer.parseInt(countStr);

      return itemCount;
   }

   /**
      Returns a list of those sources found to be bad during the
      last retrieval of feed items.
   */
   public List<String> getBadSources()
   {
      return badSources;
   }

   /**
      Removes the currently identified set of bad sources from the
      full set of sources.
   */
   public void removeBadSources()
   {
      for (int i = 0; i < badSources.size(); i++)
      {
         list.remove(badSources.get(i));
      }

      badSources.clear();
   }

   public void sortSource()
   {
      Collections.sort(list, new SourceComparator());
   }

   public void sortDate()
   {
      Collections.sort(RSSItemList, new DateComparator());
   }
}
