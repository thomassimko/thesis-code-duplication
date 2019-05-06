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

public class FeedReaderClass implements FeedReader {

	private ArrayList<String> sources = new ArrayList<String>();
	private ArrayList<String> badSources = new ArrayList<String>();

	@Override
	public void addSource(String src) {
		sources.add(src);
	}

	@Override
	public List<String> getSources() {
		Collections.sort(sources);
		return sources;
	}

	@Override
	public List<RSSItem> retrieveFeedItems() {
		DocumentBuilder builder;
		ArrayList<RSSItem> items = new ArrayList<RSSItem>();
		badSources.clear();
		try {
			builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
			for (String s : sources) {
				try {
					Document feedDocument = builder.parse(s);

					XPathFactory xpfactory = XPathFactory.newInstance();
					XPath xpath = xpfactory.newXPath();
					String countStr = xpath.evaluate(
							"count(/rss/channel/item)", feedDocument);
					int itemCount = Integer.parseInt(countStr);
					for (int i = 1; i <= itemCount; i++) {
						String title = xpath.evaluate("/rss/channel/item[" + i
								+ "]/title", feedDocument);
						String link = xpath.evaluate("/rss/channel/item[" + i
								+ "]/link", feedDocument);
						String dateString = xpath.evaluate("/rss/channel/item["
								+ i + "]/pubDate", feedDocument);
						Calendar cal = Calendar.getInstance();
						SimpleDateFormat sdf = new SimpleDateFormat();
						sdf.applyPattern("EEE, dd MMM yyyy HH:mm:ss zzz");
						Date date = sdf.parse(dateString);
						cal.setTime(date);
						items.add(new RSSItemClass(title, link, cal));
					}
				} catch (Exception e) {
					badSources.add(s);
				}
			}
		} catch (ParserConfigurationException e) {
			System.err.println("error creating DocumentBuilder: "
					+ e.getMessage());
		}
		Collections.sort(items,new RSSItemComparator());
		return items;
	}

	@Override
	public List<String> getBadSources() {
		return badSources;
	}

	@Override
	public void removeBadSources() {
		for (String s : badSources)
			sources.remove(s);
		badSources.clear();
	}

}
