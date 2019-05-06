import java.io.IOException;
import java.util.*;
import javax.xml.parsers.*;
import java.text.*;
import org.w3c.dom.*;
import org.xml.sax.SAXException;
import javax.xml.xpath.*;


public class FeedReaderClass implements FeedReader {
	private List<String> sourceList = new LinkedList<String>();
	private List<String> badSourceList = new LinkedList<String>();
	
	@Override
	public void addSource(String src) {
		// TODO Auto-generated method stub
		sourceList.add(src);
	}

	@Override
	public List<String> getBadSources() {
		// TODO Auto-generated method stub
		return badSourceList;
	}

	@Override
	public List<String> getSources() {
		// TODO Auto-generated method stub
		return sourceList;
	}

	@Override
	public void removeBadSources() {
		// TODO Auto-generated method stub
		int i, j;
		int size = sourceList.size();
		int badSize = badSourceList.size();
		
		for(i=0; i<size; i++) {
			for(j=0; j<badSize; j++) {
				if(sourceList.get(i).equals(badSourceList.get(j))) {
					sourceList.remove(i);
					size = sourceList.size();
				}
			}
		}
	}

	@Override
	public List<RSSItem> retrieveFeedItems() {
		// TODO Auto-generated method stub
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder;
		badSourceList.clear();
		List<RSSItem> rssList = new LinkedList<RSSItem>();
		rssList.clear();
		int i, j;
		int size = sourceList.size();
		for(i=0; i<size; i++) {
			String sourceListItem = sourceList.get(i);
			
			try {
				builder = factory.newDocumentBuilder();
				Document feedDocument = builder.parse(sourceListItem);
				XPathFactory xpfactory = XPathFactory.newInstance();
				XPath xpath = xpfactory.newXPath();
				String countStr = xpath.evaluate("count(/rss/channel/item)", feedDocument);
				int itemCount = Integer.parseInt(countStr);
				for(j=1; j<=itemCount; j++) {
					try {
						String title = xpath.evaluate("/rss/channel/item[" + j + "]/title", feedDocument);
						String link = xpath.evaluate("/rss/channel/item[" + j + "]/link", feedDocument);
						String date = xpath.evaluate("/rss/channel/item[" + j + "]/pubDate", feedDocument);
						DateFormat df = new SimpleDateFormat("EEE, d MMM yyyy HH:mm:ss Z");
						Calendar c = Calendar.getInstance();
						Date d = df.parse(date);
						c.setTime(d);
						RSSItemClass rssItem = new RSSItemClass(title, link, c);
						rssList.add(rssItem);
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						badSourceList.add(sourceListItem);
					}
				}
			} catch (ParserConfigurationException e) {
				// TODO Auto-generated catch block
				badSourceList.add(sourceListItem);
			} catch (SAXException e) {
				// TODO Auto-generated catch block
				badSourceList.add(sourceListItem);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				badSourceList.add(sourceListItem);
			} catch (XPathExpressionException e) {
				// TODO Auto-generated catch block
				badSourceList.add(sourceListItem);
			}
		}
		return rssList;
	}
}
