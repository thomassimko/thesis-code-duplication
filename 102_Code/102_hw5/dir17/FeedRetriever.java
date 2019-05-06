import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathFactory;
import javax.xml.xpath.XPathExpressionException;
import org.w3c.dom.Document;

public class FeedRetriever
  implements FeedReader
{
  private List<String> sources = new ArrayList();
  private List<String> badSources;

  public void addSource( String src )
  {
    sources.add(src);
  }

  public List<RSSItem> retrieveFeedItems()
  {
    List<RSSItem> items = new ArrayList();
    badSources = new ArrayList();

    DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
    DocumentBuilder builder = null;

    XPathFactory xpfactory = XPathFactory.newInstance();
    XPath xpath = xpfactory.newXPath();

    try    
    {
      builder = factory.newDocumentBuilder();
    }
    catch( ParserConfigurationException e )
    {
      System.err.println(e);
    }

    for( String src : sources )
    {
      try
      {
        Document feedDocument = getDocument( src, builder );
        int itemCount = getCount( feedDocument, xpath );
        items = addRSSItems( itemCount, feedDocument, items, xpath );
      }
      catch( Exception e )
      {
        badSources.add(src);
        System.err.println("ERROR: " + e);
      }
    }

    return items;
  }

  private Document getDocument( String src, DocumentBuilder builder )
    throws Exception
  {
    return builder.parse(src);
  }

  private int getCount( Document feedDoc, XPath xpath )
    throws XPathExpressionException
  {
    String countStr = null;

    countStr = xpath.evaluate("count(/rss/channel/item)", feedDoc );

    return Integer.parseInt(countStr);
  }

  private List<RSSItem> addRSSItems( int itemCount, Document feedDoc, 
    List<RSSItem> list, XPath xpath )
    throws XPathExpressionException
  {
    System.out.println("adding " + itemCount + " items");
    for( int i=0; i<itemCount; i++ )
    {
      try
      {
        list.add( getRSSItem(i, feedDoc, xpath) );
      }
      catch( ParseException e )
      {
        System.out.println("DATE ERROR: " + e );
      }
    }

    return list;
  }

  private RSSItem getRSSItem( int cur, Document feedDoc, XPath xpath )
    throws XPathExpressionException, ParseException
  {
    String title = null, link = null, dateStr = null;

    title = xpath.evaluate("/rss/channel/item[" + cur +
      "]/title", feedDoc);
    link = xpath.evaluate("/rss/channel/item[" + cur +
      "]/link", feedDoc);
    dateStr = xpath.evaluate("/rss/channel/item[" + cur +
      "]/pubDate", feedDoc);

    Calendar date = getDate(dateStr);

    return new Item( title, link, date );
  }

  private Calendar getDate( String dateStr )
    throws ParseException
  {
    SimpleDateFormat df = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss zzz");
    Date d = df.parse(dateStr);
    Calendar c = Calendar.getInstance();
    c.setTime(d);

    return c;
  }

  public List<String> getSources()
  {
    return sources;
  }

  public List<String> getBadSources()
  {
    return badSources;
  }

  public void removeBadSources()
  {
    for( String badSrc : badSources )
    {
      sources.remove(badSrc);
    }
  }
}
