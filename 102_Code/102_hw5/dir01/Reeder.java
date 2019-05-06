import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class Reeder implements FeedReader {

	private ArrayList<Document> sources;
	private ArrayList<String> sourceStrs;
	private ArrayList<RSSItem> items;
	private ArrayList<String> badStrs;

	public Reeder() {
		this.sources = new ArrayList<Document>();
		this.sourceStrs = new ArrayList<String>();
		this.items = new ArrayList<RSSItem>();
		this.badStrs = new ArrayList<String>();
	}

	@Override
	public void addSource(String src) {
		this.sourceStrs.add(src);
	}

	@Override
	public List<String> getSources() {
		return this.sourceStrs;
	}

	public List<RSSItem> OList() {
		return this.items;
	}

	@Override
	public List<RSSItem> retrieveFeedItems() {
		this.badStrs = new ArrayList<String>();
		this.sources = new ArrayList<Document>();
		for (int v = 0; v < this.sourceStrs.size(); v++) {
			String src = this.sourceStrs.get(v);
			DocumentBuilderFactory factory = DocumentBuilderFactory
					.newInstance();
			DocumentBuilder builder;
			try {
				builder = factory.newDocumentBuilder();
				Document feedDocument = builder.parse(src);
				this.sources.add(feedDocument);
			} catch (ParserConfigurationException e) {
				// e.printStackTrace();
				// this.sources.add(null);
				this.badStrs.add(src);
			} catch (SAXException e) {
				// e.printStackTrace();
				// this.sources.add(null);
				this.badStrs.add(src);
			} catch (IOException e) {
				// e.printStackTrace();
				// this.sources.add(null);
				this.badStrs.add(src);
			}
		}

		XPathFactory xpfactory = XPathFactory.newInstance();
		XPath xpath = xpfactory.newXPath();
		items = new ArrayList<RSSItem>();
		for (int v = 0; v < this.sources.size(); v++) {
			Document feedDocument = this.sources.get(v);
			if (feedDocument != null) {
				String countStr;
				try {
					countStr = xpath.evaluate("count(/rss/channel/item)",
							feedDocument);
					int itemcount = Integer.parseInt(countStr);
					for (int x = 1; x <= itemcount; x++) {
						String title = xpath.evaluate("/rss/channel/item[" + x
								+ "]/title", feedDocument);
						String link = xpath.evaluate("/rss/channel/item[" + x
								+ "]/link", feedDocument);
						String date = xpath.evaluate("/rss/channel/item[" + x
								+ "]/pubDate", feedDocument);
						Item z = new Item(title, link, date);
						items.add(z);
					}
				} catch (XPathExpressionException e) {
					// e.printStackTrace();
					this.badStrs.add(this.sourceStrs.get(v));
				} catch (BadItemException e) {
					// TODO Auto-generated catch block
					this.badStrs.add(this.sourceStrs.get(v));
				}
			}
		}
		return this.items;
	}

	@Override
	public List<String> getBadSources() {
		this.badStrs = new ArrayList<String>();
		this.sources = new ArrayList<Document>();
		for (int v = 0; v < this.sourceStrs.size(); v++) {
			String src = this.sourceStrs.get(v);
			DocumentBuilderFactory factory = DocumentBuilderFactory
					.newInstance();
			DocumentBuilder builder;
			try {
				builder = factory.newDocumentBuilder();
				Document feedDocument = builder.parse(src);
				this.sources.add(feedDocument);
			} catch (ParserConfigurationException e) {
				// e.printStackTrace();
				// this.sources.add(null);
				this.badStrs.add(src);
			} catch (SAXException e) {
				// e.printStackTrace();
				// this.sources.add(null);
				this.badStrs.add(src);
			} catch (IOException e) {
				// e.printStackTrace();
				// this.sources.add(null);
				this.badStrs.add(src);
			}
		}
		return this.badStrs;
	}

	@Override
	public void removeBadSources() {
		this.sources = new ArrayList<Document>();
		for (int v = 0; v < this.sourceStrs.size(); v++) {
			String src = this.sourceStrs.get(v);
			DocumentBuilderFactory factory = DocumentBuilderFactory
					.newInstance();
			DocumentBuilder builder;
			try {
				builder = factory.newDocumentBuilder();
				Document feedDocument = builder.parse(src);
				this.sources.add(feedDocument);
			} catch (ParserConfigurationException e) {
				// e.printStackTrace();
				//this.sources.add(null);
				this.badStrs.add(this.sourceStrs.get(v));
			} catch (SAXException e) {
				// e.printStackTrace();
				//this.sources.add(null);
				this.badStrs.add(this.sourceStrs.get(v));
			} catch (IOException e) {
				// e.printStackTrace();
				//this.sources.add(null);
				this.badStrs.add(this.sourceStrs.get(v));
			}
		}
		for (int i = 0; i < this.sourceStrs.size(); i++) {
			for (int y = 0; y < this.badStrs.size(); y++) {
				if (this.sourceStrs.get(i).equals(this.badStrs.get(y))) {
					this.sourceStrs.remove(i);
					break;
				}
			}
		}
	}

}
