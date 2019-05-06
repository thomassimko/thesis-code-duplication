import java.util.List;
import java.util.Calendar;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.text.ParseException;

public class test
{
	public static void main(String [] args)
	{
		try
		{
			Reader read = new Reader();
			read.addSource("http://search.twitter.com/search.rss?q=from:espn");
			List<RSSItem> list = read.retrieveFeedItems();
			System.out.println(list.get(1).getTitle());
			System.out.println(list.get(1).dateString());
			System.out.println(list.get(1).getLink());
		}
		catch(ParseException e)
		{
			System.err.println("err");
		}
	}
}
		
