import java.util.*;
import java.text.*;
import javax.xml.parsers.*;
import javax.xml.xpath.*;
import java.io.IOException;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class FeedReaderClass
    implements FeedReader
{
    private List<String> listSources;
    private List<RSSItem> listItems;
    private List<String> listBadSources;
    public FeedReaderClass()
    {
	this.listSources = new ArrayList<String>();
        this.listItems = new ArrayList<RSSItem>();
	this.listBadSources = new ArrayList<String>();
    }
    public void addSource(String src)
    {
	listSources.add(src);
    }
    private void addSourceHelper(String src, Document feedDocument)
    {
    }
    public List<String> getSources()
    {
	return listSources;
    }
    public List<RSSItem> retrieveFeedItems()
    {
	List<RSSItem> items = new ArrayList<RSSItem>();
	String title, link, date;
	Calendar c = null;
	for(String src : listSources){
	    try{
		Document feedDocument = null;
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		feedDocument = builder.parse(src);
		XPathFactory xpfactory = XPathFactory.newInstance();
		XPath xpath = xpfactory.newXPath();
		String countStr = xpath.evaluate("count(/rss/channel/item)", feedDocument);
		int itemCount = Integer.parseInt(countStr);

		for(int i = 1; i <= itemCount; i++){
		     title = xpath.evaluate("/rss/channel/item["+ i +"]/title", feedDocument);
		     link = xpath.evaluate("/rss/channel/item["+ i +"]/link", feedDocument);
		     date = xpath.evaluate("/rss/channel/item["+ i +"]/pubDate", feedDocument);
		     c = dateConverter(date, src);
		     RSSItem temp = new Item(title, c, link);
		     listItems.add(temp);
		}
	    }
	    catch(Exception e){
		listBadSources.add(src);
	    }
	}
	return listItems;
    }
    public List<String> getBadSources()
    {
	return listBadSources;
    }
    public void removeBadSources()
    {
	for(String s: listBadSources){
	    listSources.remove(s);
	}
    }
    private Calendar dateConverter(String str, String link)
    {
	Calendar c = null;
	try{
	    DateFormat df = new SimpleDateFormat("EEE, dd MMMM yyyy " + "HH:mm:ss zzz");
	    Date d = df.parse(str);
	    c = Calendar.getInstance();
	    c.setTime(d);
	}
	catch(ParseException e){
	    System.err.println("Wrong date format");
	}
	return c;
    }
}