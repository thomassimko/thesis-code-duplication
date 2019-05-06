import java.util.*;
import java.io.*;
import java.text.*;
import javax.xml.xpath.*;
import javax.xml.parsers.*;
import org.xml.sax.SAXException;
import org.w3c.dom.*; 

public class Feeder
   implements FeedReader
{
   private List<RSSItem> itemlist;
   private List<String> sources;
   private List<String> badsources;

   public Feeder()
   {
      itemlist = new ArrayList<RSSItem>();
      sources = new ArrayList<String>();
      badsources = new ArrayList<String>();
   }

   public void addSource(String src)
   {
      sources.add(src);
   }

   public List<String> getSources()
   {
      return this.sources;
   }

   public List<RSSItem> retrieveFeedItems()
   {
      DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
      DocumentBuilder builder = null;
      Document feedDocument = null;
      String countStr = null;
      
      for(String src : sources)
      {
         try
         {
            builder = factory.newDocumentBuilder();
            feedDocument = builder.parse(src);
            XPathFactory xpfactory = XPathFactory.newInstance();
            XPath xpath = xpfactory.newXPath();
            countStr = xpath.evaluate("count(/rss/channel/item)", feedDocument);
            int itemCount = Integer.parseInt(countStr);
            for(int i=1; i < itemCount; i++)
            {
               String title = xpath.evaluate("rss/channel/item[" + i + "]/title", feedDocument);
               String link = xpath.evaluate("rss/channel/item[" + i + "]/link", feedDocument);
               String datestring = xpath.evaluate("rss/channel/item[" + i + "]/date", feedDocument);
               Calendar date = parseDate(datestring);

               RSSItem itemobject = new RSS(title, link, date);

               itemlist.add(itemobject);
            }
         }
         catch(XPathExpressionException e)
         {
            badsources.add(src);
            System.err.println(e);
         }
         catch(ParserConfigurationException e)
         {
       	    badsources.add(src);
            System.err.println(e);
         }
         catch(SAXException e)
         { 
            badsources.add(src);
            System.err.println(e);
         }
         catch(IOException e)
         {
            badsources.add(src);
            System.err.println(e);
         }
         catch(ParseException e)
         {
            System.err.println(e);
         }
         catch(Exception e)
         {
            System.err.println(e);
         }
      }
      return itemlist;
   }

   public List<String> getBadSources()
   {
      return this.badsources; 
   }

   public void removeBadSources()
   {
      for(String src : badsources)
      {
         sources.remove(src);
      }
      badsources = new ArrayList<String>();
   }

   public Calendar parseDate(String s)
      throws ParseException
   {
      Calendar c = null;
      try
      {
         DateFormat df = new SimpleDateFormat("EEE, dd MMMM yyyy HH:mm:ss zzz");
         Date d = df.parse(s);
         c = Calendar.getInstance();
         c.setTime(d);
      }
      catch(ParseException e)
      {
         System.err.println(e);
         throw e;
      }
 
      return c;
   }
}
