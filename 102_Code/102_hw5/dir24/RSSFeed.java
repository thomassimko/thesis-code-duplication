import java.util.*;
import java.text.*;
import java.io.*;
import javax.xml.xpath.*;
import javax.xml.parsers.*;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class RSSFeed
   implements FeedReader
{
   private ArrayList<String> source;
   private ArrayList<RSSItem> item;
   private ArrayList<String> badSource;
   
   private DocumentBuilderFactory factory;
   private DocumentBuilder builder;
   private Document feedDocument;
   
   private XPathFactory xpfactory;
   private XPath xpath;

   public RSSFeed()
   {
      try
      {
         this.source = new ArrayList<String>();
         this.item = new ArrayList<RSSItem>();
         
         this.factory = DocumentBuilderFactory.newInstance();
         this.builder = this.factory.newDocumentBuilder();
         
         this.xpfactory = XPathFactory.newInstance();
         this.xpath = this.xpfactory.newXPath();
      }
      catch(ParserConfigurationException p)
      {
         System.err.println("some error happened");
      }
   }
   
   /**
      Adds a new source to the list of sources from which feeds are
      retrieved.
      @param: src The URL of the source.
   */
   public void addSource(String src)
   {
      int stop = source.size();
      boolean go = true;
      for(int i = 0; i < stop; i++)
      {
         if(source.get(i).equals(src))
         {
            go = false;
         }
      }
      if(go == true)
      {
         this.source.add(src);
      }
   }

   /**
      Returns the list of sources that this reader is working with.
   */
   public List<String> getSources()
   {
      return this.source;
   }

   /**
      Returns a list of feed items pulled from the current list of sources.
   */
   public List<RSSItem> retrieveFeedItems()
   {
      this.badSource = new ArrayList<String>();
      String temp = null;
      String countStr = null;
      int itemCount = 0;
      for(int i = 0; i < source.size(); i++)
      {
         temp = source.get(i);
         try
         {
            this.feedDocument = this.builder.parse(source.get(i));
            countStr = xpath.evaluate("count(/rss/channel/item)", feedDocument);
            itemCount = Integer.parseInt(countStr);
         }
         catch(Exception e)
         {
            this.badSource.add(temp);
         }
         for(int j = 1; j <= itemCount; j++)
         {
            String title = null;
            String link = null;
            String toDate = null;
            Date date = null;
            DateFormat df = new SimpleDateFormat("EEE, d MMM yyyy HH:mm:ss Z");
            Calendar cal = Calendar.getInstance();
            try
            {
               title = this.xpath.evaluate("/rss/channel/item[" + j + "]/title", feedDocument);
               link = this.xpath.evaluate("/rss/channel/item[" + j + "]/link", feedDocument);
               toDate = this.xpath.evaluate("/rss/channel/item[" + j + "]/pubDate", feedDocument);
               date = df.parse(toDate);
               cal.setTime(date);
            }
            catch(Exception f)
            {
               this.badSource.add(temp);
            }
            RSSItem rss_item = new RSSDocument(title, cal, link);
            this.item.add(rss_item);
         }

/*
         catch(ParseException e)
         {
            this.badSource.add(temp);
         }
         catch(XPathExpressionException x)
         {
            this.badSource.add(temp);
         }
         catch(SAXException s)
         {
            this.badSource.add(temp);
         }
         catch(IOException o)
         {
            this.badSource.add(temp);
         }
*/
      }
      return this.item;
   }

   /**
      Returns a list of those sources found to be bad during the
      last retrieval of feed items.
   */
   public List<String> getBadSources()
   {
      return this.badSource;
   }

   /**
      Removes the currently identified set of bad sources from the
      full set of sources.
   */
   public void removeBadSources()
   {
      int size = this.badSource.size();
      for(int i = 0; i < size; i++)
      {
         this.source.remove(this.badSource.get(i));
      }
      this.badSource = new ArrayList<String>();
   }
}
