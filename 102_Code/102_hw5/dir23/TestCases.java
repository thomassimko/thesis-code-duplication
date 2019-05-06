import java.text.SimpleDateFormat;
import java.util.*;


public class TestCases {
	public static void test() {
		System.err.println("Testing: INITIATED");
		System.out.println("");
		FeedReaderClass feedReader = new FeedReaderClass();
		feedReader.addSource("http://search.twitter.com/search.rss?q=from:keen_csc102");
		feedReader.addSource("http://search.twitter.com/search.rss?q=from:ThisKidMikey");
		feedReader.addSource("http://search.twitter.com/search.rss?q=from:e_cavazos");
		feedReader.addSource("http://search.twitter.com/search.rss?q=from:autocorrects");
		feedReader.addSource("http://search.twitter.c");
		feedReader.addSource("http://search.twitter.com/search.r");
		
		System.err.println("Phase 1 Testing: INITIATED");
		Check.check(feedReader.getSources().size(), 6);
		int size = feedReader.getSources().size();
		System.err.println("-----SOURCE LIST-----");
		for(int i=0; i<size; i++) {
			System.out.println(feedReader.getSources().get(i));
		}
		System.err.println("Phase 1 Testing: COMPLETED");
		
		System.out.println("");
		System.err.println("Phase 2 Testing: INITIATED");
		List<RSSItem> rssList = feedReader.retrieveFeedItems();
		List<String> badSourceList = feedReader.getBadSources();
		Check.check(badSourceList.size(), 2);
		int badSize = badSourceList.size();
		System.err.println("-----BAD SOURCES-----");
		for(int i=0; i<badSize; i++) {
			System.out.println(badSourceList.get(i));
		}
		int rssSize = rssList.size();
		System.err.println("-----RSS ITEM TITLES-----");
		for(int i=0; i<rssSize; i++) {
			System.out.println(rssList.get(i).getTitle());
		}
		System.err.println("Phase 2 Testing: COMPLETED");
		
		System.out.println("");
		System.err.println("Phase 3 Testing: INITIATED");
		int sourceSize = feedReader.getSources().size();
		System.err.println("-----SOURCE LIST AGAIN-----");
		for(int i=0; i<sourceSize; i++) {
			System.out.println(feedReader.getSources().get(i));
		}
		feedReader.removeBadSources();
		System.err.println("-----BAD SOURCES REMOVED-----");
		int newSourceSize = feedReader.getSources().size();
		for(int i=0; i<newSourceSize; i++) {
			System.out.println(feedReader.getSources().get(i));
		}
		System.err.println("Phase 3 Testing: COMPLETED");
		
		System.out.println("");
		System.err.println("Phase 4 Testing: INITIATED");
		SourceSort<String> sourceSorter = new SourceSort<String>();
		SourceComparator sourceComparator = new SourceComparator();
		List<String> newSourceList = sourceSorter.sourceSort(feedReader.getSources(), sourceComparator);
		System.err.println("-----ALPHABATIZED SOURCES-----");
		int newSize = newSourceList.size();
		for(int i=0; i<newSize; i++) {
			System.out.println(newSourceList.get(i));
		}
		System.err.println("Phase 4 Testing: COMPLETED");
		
		System.out.println("");
		System.err.println("Phase 5 Testing: INITIATED");
		DateSort dateSorter = new DateSort();
		DateComparator dateComparator = new DateComparator();
		List<RSSItem> newRSSList = dateSorter.dateSort(rssList, dateComparator);
		SimpleDateFormat df2 = new SimpleDateFormat("MM/dd/yyyy HH:mm");
		System.err.println("-----ORDERED DATES-----");
		int newRSSSize = newRSSList.size();
		for(int i=0; i<newRSSSize; i++) {
			String formattedDate = df2.format(newRSSList.get(i).getDate().getTime());
			System.out.println(formattedDate);
		}
		System.err.println("Phase 5 Testing: COMPLETED");
	}
	public static void main(String[] args) {
		test();
		System.err.println("Testing: COMPLETED");
	}
}
