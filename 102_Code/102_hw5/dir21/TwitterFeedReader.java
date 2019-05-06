import java.util.*;
import java.text.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.*;
import javax.xml.xpath.*;
import javax.xml.xpath.XPathFactory;
import java.text.ParseException;
import org.w3c.dom.Document;

public class TwitterFeedReader implements FeedReader{
	List<String> sources,badSources;
	List<RSSItem> feedItems;
	public TwitterFeedReader(){
		sources=new ArrayList<String>();
		badSources=new ArrayList<String>();
		feedItems=new ArrayList<RSSItem>();
	}
	/**
      Adds a new source to the list of sources from which feeds are
      retrieved.
      @param: src The URL of the source.
	*/
	public void addSource(String src){
		int l=sources.size();
		boolean added=false;
		for(int i=0;i<l&&added==false;i++){
			if(sources.get(i).compareTo(src)>0){
				sources.add(i,src);
				added=true;
			}
		}
		if(added==false){
			sources.add(src);
		}
	}
	/**
      Returns the list of sources that this reader is working with.
	*/
	public List<String> getSources(){
		return sources;
	}
	/**
      Returns a list of feed items pulled from the current list of sources.
	*/
	public List<RSSItem> retrieveFeedItems(){
		DocumentBuilderFactory factory;
		DocumentBuilder builder;
		Document feedDocument;
		XPathFactory xpfactory;
		XPath xpath;
		String countStr,title="",link="",date,URI;
		int itemCount;
		RSSItem r;
		DateFormat formatter;
		formatter = new SimpleDateFormat("EEE, d MMM yyyy kk:mm:ss Z");
		Date tmpTime=new Date();
	
		Iterator iter = sources.iterator();
		while(iter.hasNext()){
			URI=(String)(iter.next());
			factory=DocumentBuilderFactory.newInstance();
			try{
				builder=factory.newDocumentBuilder();
			}
			catch(Exception e){
				break;
			}
			try{
				feedDocument = builder.parse(URI);
				xpfactory = XPathFactory.newInstance();
				xpath = xpfactory.newXPath();
				countStr = xpath.evaluate("count(/rss/channel/item)", feedDocument);
				itemCount = Integer.parseInt(countStr);
				if(itemCount==0){
					badSources.add(URI);
				}
			}
			catch(Exception e){
				badSources.add(URI);
				break;
			}
			
			for(int i=1;i<=itemCount;i++){ 
				try{
					title = xpath.evaluate("/rss/channel/item["+i+"]/title", feedDocument);
					link = xpath.evaluate("/rss/channel/item["+i+"]/link", feedDocument);
					date = xpath.evaluate("/rss/channel/item["+i+"]/pubDate", feedDocument);
					tmpTime=formatter.parse(date);

				}
				catch(XPathExpressionException e){
					badSources.add(URI);
				}
				catch(ParseException e){
					badSources.add(URI);
				}
				r=new TwitterRSSItem(title,tmpTime,link);
				
				int l=feedItems.size();
				boolean added=false;
				for(int j=0;j<l&&added==false;j++){
					if((feedItems.get(j).getDate()).after(tmpTime)){
						feedItems.add(j,r);
						added=true;
					}
				}
				if(added==false){
					feedItems.add(r);
				}
			}
		}
		return feedItems;
	}
	/**
      Returns a list of those sources found to be bad during the
      last retrieval of feed items.
	*/
	public List<String> getBadSources(){
		return badSources;
	}
	/**
      Removes the currently identified set of bad sources from the
      full set of sources.
	*/
	public void removeBadSources(){
		for(String bs:badSources){
			sources.remove(bs);
		}
		badSources.clear();
	}
}