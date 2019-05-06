import java.text.SimpleDateFormat;



public class TestCases
{
	public static void main(String[] args)
	{
		Reader testerReader = new Reader();
		testerReader.addSource("http://search.twitter.com/search.rss?q=from:keen_csc102");
		testerReader.addSource("http://BadSource");
		SimpleDateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm");
		for(RSSItem item : testerReader.retrieveFeedItems())
		{
			System.out.println(item.getTitle());
			System.out.println(df.format(item.getDate().getTime()));
			System.out.println(item.getLink());
			System.out.println("");
		}
		for(String badSource : testerReader.getBadSources())
		{
			System.out.println(badSource);
		}
		System.out.println("End Of Bad Sources\n");

		testerReader.removeBadSources();
		for(String badSourceCleared: testerReader.getBadSources())
		{
			System.out.println(badSourceCleared);
		}
		System.out.println("End Of Bad Sources Cleared\n");
	}

}
