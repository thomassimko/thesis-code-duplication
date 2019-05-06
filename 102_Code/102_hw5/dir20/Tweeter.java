import java.util.ArrayList;
import java.util.List;
import java.util.Calendar;
import java.text.SimpleDateFormat;
import javax.swing.JFrame;
import javax.swing.BoxLayout;
import java.awt.FlowLayout;

public class Tweeter
   extends javax.swing.JFrame
{
   public static void main(String [] args)
	{
	 
	   ArrayList<String> sourceList = new ArrayList<String>();
	   List<RSSItem> rssItemList = new ArrayList<RSSItem>();
	   List<String> badSourceList = new ArrayList<String>();
	   
	   String string1 = "http://search.twitter.com/search.rss?q=from:keen_csc102";
	   
	   sourceList.add(string1);
	   
	   TwitterReader twit = new TwitterReader(sourceList);
	   
	   List<String> check = twit.getSources();
	   
	   System.out.println(check.get(0));
	   
	   rssItemList = twit.retrieveFeedItems();
	   
		badSourceList = twit.getBadSources();
	   
	   System.out.println( rssItemList.size());
	   
	   for (int i= 0 ; i < rssItemList.size(); i++)
	   {
	      
	      SimpleDateFormat regDate = new SimpleDateFormat("EEE, d MMM yyyy HH:mm:ss Z");
	      Calendar calDate = rssItemList.get(i).getDate();
	      String zDate;
	      zDate = regDate.format(calDate.getTime());
	   
	      
	      System.out.println( rssItemList.get(i).getTitle() );
	      
	      System.out.println( zDate );
	      System.out.println( rssItemList.get(i).getLink() );
	      System.out.println( );
	   
	   }
		
		for(int j = 0; j < badSourceList.size(); j++)
		{
		   System.out.println( badSourceList.get(j));
		}
		
		TwitterGUI gui = new TwitterGUI();
		
	}
}